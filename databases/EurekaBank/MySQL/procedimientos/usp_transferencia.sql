DELIMITER $$

DROP PROCEDURE IF EXISTS usp_transferencia$$

CREATE PROCEDURE usp_transferencia( 
	out p_estado varchar(500), -- Parámetro de salida
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
	DECLARE clave1 varchar(15);
	DECLARE codigo varchar(8);
	
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING, NOT FOUND
	BEGIN
		rollback;
		if( p_estado is null ) then
			set p_estado = 'Error en el proceso de actualización.';
		end if;
	END;
	
	set p_estado = null;

	-- Verificar la moneda
	select chr_monecodigo, dec_cuensaldo, int_cuencontmov, chr_cuenclave
	into moneda1, saldo1, cont1, clave1
	from cuenta 
	where chr_cuencodigo = p_cuenta1;
	
	select chr_monecodigo, int_cuencontmov
	into moneda2, cont2
	from cuenta 
	where chr_cuencodigo = p_cuenta2;
	
	if ( moneda1 != moneda2 ) then
		set p_estado = 'Error, cuentas deben ser de la misma moneda';
	else 
		if( p_clave1 != clave1 ) then
			set p_estado = 'Error, datos no son correctos';
		else
		    
			select dec_costimporte into cargo
			from costomovimiento where chr_monecodigo = moneda1;
		
			if(  (p_importe + cargo) > saldo1 ) then
				set p_estado = 'Error, saldo insuficiente.';
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
					set dec_cuensaldo = dec_cuensaldo + p_importe,
					    int_cuencontmov = int_cuencontmov + 1
					where chr_cuencodigo = p_cuenta2;
				
				set cont2 = cont2 + 1;
				
				insert into movimiento(chr_cuencodigo,int_movinumero,dtt_movifecha,
					chr_emplcodigo,chr_tipocodigo,dec_moviimporte,chr_cuenreferencia)
					values(p_cuenta2,cont2,current_date,p_empleado,'008',p_importe,p_cuenta1);
				commit;
				set p_estado = 'ok';
			end if;
		end if;
	end if;
END$$

DELIMITER ;

/*

call usp_transferencia(@estado,'00100001','00200001','123456',900,'0001');

select @estado;

*/