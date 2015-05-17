delimiter //

create function fn_consulta_saldo( p_cuenta char(8) )
returns decimal(12,2)
begin
    declare saldo decimal(12,2);
    select dec_cuensaldo into saldo
        from cuenta
        where chr_cuencodigo = p_cuenta;
    return saldo;
end //

delimiter ;