DELIMITER $$

DROP PROCEDURE IF EXISTS usp_transferencia$$

CREATE PROCEDURE usp_transferencia( 
	p_cuenta1 char(8),  -- Cuenta origen
	p_cuenta2 char(8),  -- Cuenta destino
	p_clave1  varchar(15), -- Clave de cuenta origen
	p_importe decimal(12,2), -- Importe a transferir
	p_empleado char(4)       -- Empleado que realiza la transacción
)
BEGIN

	DECLARE moneda1 char(2);
	DECLARE moneda2 char(2);
	DECLARE saldo1  decimal(12,2);
	DECLARE cargo decimal(12,2);
	DECLARE cont1 int;
	DECLARE cont2 int;

	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING, NOT FOUND
	BEGIN
		-- Cancela la transacción
		rollback;
		-- Retorna el estado
		select -1 as state, 'Error en el proceso de actualización.' as message;
	END;

	-- Verificar la moneda
	select chr_monecodigo, dec_cuensaldo, int_cuencontmov
	into moneda1, saldo1, cont1
	from cuenta 
	where chr_cuencodigo = p_cuenta1
	and chr_cuenclave = p_clave1;
	
	select chr_monecodigo, int_cuencontmov
	into moneda2, cont2
	from cuenta 
	where chr_cuencodigo = p_cuenta2;
	
	if ( moneda1 != moneda2 ) then

		select -1 as state, 'Error, las cuentas deben ser de la misma moneda.' as message;

	else 

		select dec_costimporte into cargo
		from costomovimiento where chr_monecodigo = moneda1;

		if(  (p_importe + cargo) > saldo1 ) then

			select -1 as state, 'Error, no hay saldo suficinte.' as message;

		else

			start transaction;

			-- Registrar el retiro
			update cuenta
				set dec_cuensaldo = dec_cuensaldo - (p_importe + cargo),
					 int_cuencontmov = int_cuencontmov + 2
				where chr_cuencodigo = p_cuenta1;

			set cont1 = cont1 + 1;

			insert into movimiento(chr_cuencodigo,int_movinumero,dtt_movifecha,
				chr_emplcodigo,chr_tipocodigo,dec_moviimporte,chr_cuenreferencia)
				values(p_cuenta1,cont1,current_date,p_empleado,'009',p_importe,p_cuenta2);

			set cont1 = cont1 + 1;

			insert into movimiento(chr_cuencodigo,int_movinumero,dtt_movifecha,
				chr_emplcodigo,chr_tipocodigo,dec_moviimporte,chr_cuenreferencia)
				values(p_cuenta1,cont1,current_date,p_empleado,'010',cargo,null);

			-- Registrar el deposito

			update cuenta
				set dec_cuensaldo = dec_cuensaldo + p_importe - cargo,
					 int_cuencontmov = int_cuencontmov + 2
				where chr_cuencodigo = p_cuenta2;

			set cont2 = cont2 + 1;

			insert into movimiento(chr_cuencodigo,int_movinumero,dtt_movifecha,
				chr_emplcodigo,chr_tipocodigo,dec_moviimporte,chr_cuenreferencia)
				values(p_cuenta2,cont2,current_date,p_empleado,'008',p_importe,p_cuenta1);

			set cont2 = cont2 + 1;

			insert into movimiento(chr_cuencodigo,int_movinumero,dtt_movifecha,
				chr_emplcodigo,chr_tipocodigo,dec_moviimporte,chr_cuenreferencia)
				values(p_cuenta2,cont2,current_date,p_empleado,'010',cargo,null);

			commit;

			select 1 as state, 'Proceso ok.' as message;

		end if;

	end if;

END$$

DELIMITER ;

/*

call usp_transferencia('00100001','00200001','123456',100,'0001');

select * from cuenta where chr_cuencodigo in ('00100001','00200001');



*/