DELIMITER $$

CREATE PROCEDURE usp_consulta_movimientos
( in nrocuenta char(8) )
BEGIN

	select 
		c.chr_cuencodigo,
		c.dec_cuensaldo,
		m.vch_monedescripcion,
		c.vch_cuenestado
	from cuenta as c
	inner join moneda as m on c.chr_monecodigo = m.chr_monecodigo
	where c.chr_cuencodigo = nrocuenta;

	select
		m.dtt_movifecha,
		t.vch_tipodescripcion,
		case 
			when t.vch_tipoaccion = 'INGRESO' then m.dec_moviimporte
			else (-1) * m.dec_moviimporte
		end as importe
	from movimiento as m
	inner join tipomovimiento as t on m.chr_tipocodigo = t.chr_tipocodigo
	where m.chr_cuencodigo = nrocuenta
	order by 1 desc
	limit 5;

END$$

DELIMITER ;