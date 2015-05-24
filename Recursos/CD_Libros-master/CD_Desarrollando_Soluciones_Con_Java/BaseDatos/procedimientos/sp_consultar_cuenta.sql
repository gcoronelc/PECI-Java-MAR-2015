delimiter //

create procedure sp_consultar_cuenta
( in p_cuenta char(8), out p_ingreso decimal(12,2),
  out p_salida decimal(12,2), out p_saldo decimal(12,2) )
begin
    -- Consultar saldo
    select dec_cuensaldo into p_saldo
    from cuenta where chr_cuencodigo = p_cuenta;
    -- Consultar ingreso y salida
    select 
        sum(case when t.vch_tipoaccion = 'INGRESO' 
            then m.dec_moviimporte else 0.0 end), 
        sum(case when t.vch_tipoaccion = 'SALIDA' 
            then m.dec_moviimporte else 0.0 end)
    into p_ingreso, p_salida
    from movimiento as m
    join tipomovimiento as t
    on m.chr_tipocodigo = t.chr_tipocodigo
    where m.chr_cuencodigo = p_cuenta;
end //

delimiter ;