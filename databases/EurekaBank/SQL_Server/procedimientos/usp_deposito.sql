DELIMITER $$

DROP PROCEDURE IF EXISTS usp_deposito$$

CREATE PROCEDURE usp_deposito( 
	out p_estado varchar(500), -- Parámetro de salida
	p_cuenta char(8), 
	p_importe decimal(12,2),  
	p_empleado char(4)
)
BEGIN

	DECLARE moneda char(2);
	DECLARE costoMov decimal(12,2);
	DECLARE cont int;
	
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING, NOT FOUND
	BEGIN
		-- Cancela la transacción
		rollback; 
		set p_estado := 'Error en el proceso de actualización.';
	END;

	set p_estado = null;

	-- Iniciar Transacción
	start transaction;
	
	-- Tabla Cuenta
	select int_cuencontmov, chr_monecodigo into cont, moneda
	from cuenta where chr_cuencodigo = p_cuenta;
	
	select dec_costimporte into costoMov
	from costomovimiento
	where chr_monecodigo = moneda;
	
	-- Registrar el deposito
	update cuenta
		set dec_cuensaldo = dec_cuensaldo + p_importe - costoMov,
			int_cuencontmov = int_cuencontmov + 2
		where chr_cuencodigo = p_cuenta;
	
	set cont := cont + 1;
	
	insert into movimiento(chr_cuencodigo,int_movinumero,dtt_movifecha,
		chr_emplcodigo,chr_tipocodigo,dec_moviimporte,chr_cuenreferencia)
		values(p_cuenta,cont,current_date,p_empleado,'003',p_importe,null);
	
	set cont := cont + 1;
	
	insert into movimiento(chr_cuencodigo,int_movinumero,dtt_movifecha,
		chr_emplcodigo,chr_tipocodigo,dec_moviimporte,chr_cuenreferencia)
		values(p_cuenta,cont,current_date,p_empleado,'010',costoMov,null);
		
	-- Confirma Transacción
	commit;
	
	set p_estado = 'ok';
	
END$$

DELIMITER ;

/*

call usp_deposito(@estado,'00100002',500,'0001');

select @estado;

select chr_cuencodigo, dec_cuensaldo, int_cuencontmov 
from cuenta 
where chr_cuencodigo = '00100002';

select * from movimiento
where chr_cuencodigo = '00100002';


*/