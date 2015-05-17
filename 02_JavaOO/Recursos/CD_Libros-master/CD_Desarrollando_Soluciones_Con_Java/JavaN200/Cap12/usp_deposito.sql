DELIMITER $$

DROP PROCEDURE IF EXISTS sp_deposito$$

CREATE PROCEDURE sp_deposito( 
	out p_estado varchar(500), -- Parámetro de salida
	p_cuenta char(8), 
	p_importe decimal(12,2),  
	p_empleado char(4)
)
BEGIN
    -- Declaraciones
	DECLARE moneda char(2);
	DECLARE costoMov decimal(12,2);
	DECLARE cont int;
    -- Control de Error
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING, NOT FOUND
	BEGIN
		rollback; -- Cancela Transacción
		set p_estado := 'Error en el proceso de actualización.';
	END;
	-- Iniciar Transacción
    set p_estado = null;
	start transaction;
	-- Tabla Cuenta
	select 
        int_cuencontmov, chr_monecodigo 
        into cont, moneda
        from cuenta 
        where chr_cuencodigo = p_cuenta;
	-- Tabla CostoMovimiento
	select 
        dec_costimporte 
        into costoMov
        from costomovimiento
        where chr_monecodigo = moneda;
	
	-- Registrar el deposito
	update cuenta
		set dec_cuensaldo = dec_cuensaldo + p_importe,
			int_cuencontmov = int_cuencontmov + 1
		where chr_cuencodigo = p_cuenta;
	-- Insertar Movimiento
	set cont := cont + 1;
	insert into movimiento(chr_cuencodigo,int_movinumero,dtt_movifecha,
		chr_emplcodigo,chr_tipocodigo,dec_moviimporte,chr_cuenreferencia)
		values(p_cuenta,cont,current_date,p_empleado,'003',p_importe,null);
	-- Confirmar Transacción
	commit;
	set p_estado = 'ok';
END$$

DELIMITER ;

call usp_deposito(@estado,'00100001',100,'0001');

select @estado;