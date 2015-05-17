delimiter //

create procedure sp_consultar_cuentas( p_sucursal char(3) )
begin
    select chr_cuencodigo, chr_monecodigo, dec_cuensaldo
    from cuenta
    where chr_sucucodigo = p_sucursal;
end//

delimiter ;