DELIMITER $$

DROP PROCEDURE IF EXISTS usp_consulta_movimientos$$

CREATE PROCEDURE usp_consulta_movimientos
(IN cuencodigo char(8))
BEGIN
	
	select * from movimiento
	where chr_cuencodigo = cuencodigo
	order by 2 desc;
	
END$$

DELIMITER ;

/*

CALL usp_consulta_movimientos('00100002');

*/