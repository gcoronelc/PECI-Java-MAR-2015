DELIMITER $$

DROP PROCEDURE IF EXISTS usp_retiro$$

CREATE PROCEDURE usp_retiro(
	p_cuenta char(8), 
	p_importe decimal(12,2),
   p_clave char(6),
	p_empleado char(4)
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
		-- Retorna el estado
		select -1 as state, 'Error en el proceso de actualización.' as message;
	END;

	-- Iniciar Transacción
	start transaction;
	
	-- Tabla Cuenta
	select int_cuencontmov, chr_monecodigo, dec_cuensaldo
	into cont, moneda, saldo
	from cuenta 
	where chr_cuencodigo = p_cuenta
	and chr_cuenclave = p_clave;
	
	select dec_costimporte into costoMov
	from costomovimiento
	where chr_monecodigo = moneda;

	if saldo < (p_importe + costoMov) then

		select -1 as state, 'Saldo insuficiente.' as message;

	else

		-- Registrar el deposito
		update cuenta
			set dec_cuensaldo = dec_cuensaldo - p_importe - costoMov,
				int_cuencontmov = int_cuencontmov + 2
			where chr_cuencodigo = p_cuenta;

		-- Registrar el movimiento
		set cont := cont + 1;
		insert into movimiento(chr_cuencodigo,int_movinumero,dtt_movifecha,
			chr_emplcodigo,chr_tipocodigo,dec_moviimporte,chr_cuenreferencia)
			values(p_cuenta,cont,current_date,p_empleado,'004',p_importe,null);

		-- Registrar el costo del movimiento
		set cont := cont + 1;
		insert into movimiento(chr_cuencodigo,int_movinumero,dtt_movifecha,
			chr_emplcodigo,chr_tipocodigo,dec_moviimporte,chr_cuenreferencia)
			values(p_cuenta,cont,current_date,p_empleado,'010',costoMov,null);

		-- Confirma Transacción
		commit;

		-- Retorna el estado
		select 1 as state, 'Proceso ok' as message;

	end if;
	
END$$

DELIMITER ;

/*

call usp_retiro('00500001',500, '123456', '0001');

*/