delimiter //

create procedure sp_consultar_saldo
( in p_cuenta char(8), out p_saldo decimal(12,2) )
begin
    select dec_cuensaldo
    into p_saldo
    from cuenta
    where chr_cuencodigo = p_cuenta;
end//

delimiter ;