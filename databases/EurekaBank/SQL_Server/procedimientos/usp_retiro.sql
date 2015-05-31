
DELIMITER $$

DROP PROCEDURE IF EXISTS usp_retiro$$

CREATE PROCEDURE usp_retiro( 
	out p_estado varchar(500), -- Parámetro de salida
	p_cuenta char(8), 
	p_importe decimal(12,2),  
	p_empleado char(4),
	p_clave char(6)
)
BEGIN

	DECLARE moneda char(2);
	DECLARE costoMov decimal(12,2);
	DECLARE cont int;
	DECLARE saldo decimal(12,2);
	
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING, NOT FOUND
	BEGIN
		-- Cancela la transacción
		rollback; 
		set p_estado := 'Error en el proceso de actualización.';
	END;

	set p_estado = null;
	
	-- Tabla Cuenta
	select int_cuencontmov, chr_monecodigo, dec_cuensaldo
	into cont, moneda, saldo
	from cuenta 
	where chr_cuencodigo = p_cuenta
	and chr_cuenclave = p_clave;
	
	select dec_costimporte into costoMov
	from costomovimiento
	where chr_monecodigo = moneda;
	
	-- Verificar el saldo
	if saldo < (p_importe + costoMov)  then
	
		set p_estado := 'Saldo insuficiente.';
	
	else
	
		-- Iniciar Transacción
		start transaction;
		
		-- Registrar el retiro
		update cuenta
		set dec_cuensaldo = dec_cuensaldo - (p_importe + costoMov),
			int_cuencontmov = int_cuencontmov + 2
		where chr_cuencodigo = p_cuenta;
	
		set cont := cont + 1;
	
		insert into movimiento(chr_cuencodigo,int_movinumero,dtt_movifecha,
			chr_emplcodigo,chr_tipocodigo,dec_moviimporte,chr_cuenreferencia)
			values(p_cuenta,cont,current_date,p_empleado,'004',p_importe,null);
	
		set cont := cont + 1;
	
		insert into movimiento(chr_cuencodigo,int_movinumero,dtt_movifecha,
			chr_emplcodigo,chr_tipocodigo,dec_moviimporte,chr_cuenreferencia)
			values(p_cuenta,cont,current_date,p_empleado,'010',costoMov,null);
		
		-- Confirma Transacción
		commit;
	
		set p_estado = 'ok';
	
	end if;
	
END$$

DELIMITER ;

/*

call usp_retiro(@estado,'00100001',500,'0001','123456');

select @estado;

select chr_cuencodigo, dec_cuensaldo, int_cuencontmov 
from cuenta 
where chr_cuencodigo = '00100002';

select * from movimiento
where chr_cuencodigo = '00100002';


*/