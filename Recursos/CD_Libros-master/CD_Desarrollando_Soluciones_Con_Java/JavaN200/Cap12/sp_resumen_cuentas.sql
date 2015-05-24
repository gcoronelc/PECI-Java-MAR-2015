delimiter //

create procedure sp_resumen_cuentas()
begin
    -- declaraciones
    declare v_cuenta char(8);
    declare v_ingresos decimal(12,2);
    declare v_salidas decimal(12,2);
    declare v_control_cursor int default 1;
    declare c_cuentas cursor for 
        select cuenta from resumen;
    declare continue handler for not found
        set v_control_cursor = 0;
    -- tabla temporal para construir el resumen
    create temporary table resumen(
        cuenta char(8) null,
        saldo decimal(12,2) null,
        ingresos decimal(12,2) null,
        salidas decimal(12,2) null
    );
    -- inserto datos en la tabla resumen
    insert into resumen(cuenta,saldo)
        select chr_cuencodigo,dec_cuensaldo from cuenta;
    -- Proceso
    open c_cuentas;
    fetch c_cuentas into v_cuenta;
    while v_control_cursor = 1 do
        select sum(m.dec_moviimporte) into v_ingresos
            from movimiento as m
            join tipomovimiento as t on m.chr_tipocodigo = t.chr_tipocodigo
            where t.vch_tipoaccion = 'INGRESO'
            and m.chr_cuencodigo = v_cuenta;
        select sum(m.dec_moviimporte) into v_salidas
            from movimiento as m
            join tipomovimiento as t on m.chr_tipocodigo = t.chr_tipocodigo
            where t.vch_tipoaccion = 'SALIDA'
            and m.chr_cuencodigo = v_cuenta;
        update resumen set 
            ingresos = v_ingresos,
            salidas = v_salidas
            where cuenta = v_cuenta;
        fetch c_cuentas into v_cuenta;
    end while;
    -- Consulta final
    select * from resumen;
    drop table resumen;
end //

delimiter ;