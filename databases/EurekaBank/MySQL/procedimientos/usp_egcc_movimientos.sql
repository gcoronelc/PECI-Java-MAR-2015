DELIMITER $$

DROP PROCEDURE IF EXISTS usp_egcc_movimientos$$

CREATE PROCEDURE usp_egcc_movimientos
(IN p_cuenta char(8))
BEGIN
	
	select 
      m.chr_cuencodigo cuenta,
      m.int_movinumero nromov,
      m.dtt_movifecha fecha,
      m.chr_tipocodigo tipo,
      t.vch_tipodescripcion descripcion,
      t.vch_tipoaccion accion,
      m.dec_moviimporte importe
    from tipomovimiento t
    join movimiento m 
    on t.chr_tipocodigo = m.chr_tipocodigo
    where m.chr_cuencodigo = p_cuenta
    order by 2;
	
END$$

DELIMITER ;

/*

CALL usp_egcc_movimientos('00100002');

*/