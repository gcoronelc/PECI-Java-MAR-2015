DELIMITER $$

DROP PROCEDURE IF EXISTS usp_retiro$$

CREATE PROCEDURE usp_retiro( 
	out p_estado varchar(500), -- Parámetro de salida
	p_cuenta char(8), 
	p_clave  varchar(15),
	p_importe decimal(12,2),  
	p_empleado char(4)
)
BEGIN

    DECLARE moneda char(2);
	DECLARE saldo  decimal(12,2);
	DECLARE cargo decimal(12,2);
	DECLARE cont int;
	DECLARE claveDB varchar(15);
	DECLARE codigo varchar(8);
/*	
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING, NOT FOUND
	BEGIN
		rollback;
        if( p_estado is null ) then
            set p_estado = 'Error en el proceso de actualización.';
        end if;
	END;
*/
	set p_estado = null;

	-- Obtener Datos de la Cuenta
	select chr_monecodigo, dec_cuensaldo, int_cuencontmov, chr_cuenclave
	into moneda, saldo, cont, claveDB
	from cuenta where chr_cuencodigo = p_cuenta;
	
	if( p_clave != claveDB ) then
		set p_estado = 'Error, datos no son correctos.';
	else
        -- Obtener cargo por movimiento
		select dec_costimporte into cargo
		from costomovimiento where chr_monecodigo = moneda;
		
		if(  (p_importe + cargo) > saldo ) then
			set p_estado = 'Error, saldo insuficiente.';
		else
            -- Se inicia la Transacción
			start transaction;
			-- Actualizar Saldo de la Cuenta
			update cuenta 
				set dec_cuensaldo = dec_cuensaldo - (p_importe + cargo),
				    int_cuencontmov = int_cuencontmov + 2
				where chr_cuencodigo = p_cuenta;
            -- Registrar Importe
			set cont = cont + 1;
            insert into movimiento(chr_cuencodigo,int_movinumero,dtt_movifecha,
				chr_emplcodigo,chr_tipocodigo,dec_moviimporte,chr_cuenreferencia)
				values(p_cuenta,cont,current_date,p_empleado,'004',p_importe,null);             
			-- Registrar Cargo por Movimiento
			set cont = cont + 1;
			insert into movimiento(chr_cuencodigo,int_movinumero,dtt_movifecha,
				chr_emplcodigo,chr_tipocodigo,dec_moviimporte,chr_cuenreferencia)
				values(p_cuenta,cont,current_date,p_empleado,'010',cargo,null);
            -- Finalizar Transacción
            commit;
			set p_estado = 'ok';
		end if;
	end if;
END$$

DELIMITER ;

/*

call usp_retiro(@estado,'00100001','123456',100,'0001');
select @estado;

*/