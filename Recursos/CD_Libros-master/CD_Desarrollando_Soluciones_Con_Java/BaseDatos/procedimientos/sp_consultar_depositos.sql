delimiter //

create procedure sp_consultar_depositos()
begin
    declare promedio decimal(12,2);
    select 
        avg(dec_moviimporte)
        into promedio
        from movimiento
        where chr_tipocodigo = '003';
    select 
        chr_cuencodigo, int_movinumero, dtt_movifecha, dec_moviimporte
        from movimiento
        where chr_tipocodigo = '003'
        and dec_moviimporte < promedio;
end //

delimiter ;