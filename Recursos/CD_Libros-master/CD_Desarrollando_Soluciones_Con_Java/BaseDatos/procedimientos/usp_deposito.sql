DELIMITER $$

DROP PROCEDURE IF EXISTS usp_deposito$$

CREATE PROCEDURE usp_deposito( 
	out p_estado varchar(500), -- Parámetro de salida
	p_cuenta char(8), 
	p_importe decimal(12,2),  
	p_empleado char(4)
)
BEGIN

	DECLARE costoMov decimal(12,2);
	DECLARE cont int;
	
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING, NOT FOUND
	BEGIN
		rollback;
		set p_estado := 'Error en el proceso de actualización.';
	END;

	set p_estado = "ok";

	-- Iniciar Transacción
	start transaction;
	
	-- Tabla Cuenta: Contador de Movimientos
	select int_cuencontmov into cont
	from cuenta where chr_cuencodigo = p_cuenta;
	
	-- Registrar el deposito
	update cuenta
		set dec_cuensaldo = dec_cuensaldo + p_importe,
			int_cuencontmov = int_cuencontmov + 1
		where chr_cuencodigo = p_cuenta;
	
	set cont := cont + 1;
	
	insert into movimiento(chr_cuencodigo,int_movinumero,dtt_movifecha,
		chr_emplcodigo,chr_tipocodigo,dec_moviimporte,chr_cuenreferencia)
		values(p_cuenta,cont,current_date,p_empleado,'003',p_importe,null);
	
	commit;
	
END$$

DELIMITER ;

/*

call usp_deposito(@estado,'00100001',100,'0001');

select @estado;

*/