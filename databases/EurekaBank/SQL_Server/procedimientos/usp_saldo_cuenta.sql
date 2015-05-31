DELIMITER $$

DROP PROCEDURE IF EXISTS usp_saldo_cuenta$$

CREATE PROCEDURE usp_saldo_cuenta
(IN p_cuencodigo char(8), OUT p_cuensaldo decimal(12,2))
BEGIN
	
	DECLARE cuensaldo decimal(12,2);
	
	select dec_cuensaldo into cuensaldo
	from cuenta
	where chr_cuencodigo = p_cuencodigo;
	
	set p_cuensaldo = cast(cuensaldo as char);
	
END$$

DELIMITER ;

/*

CALL usp_saldo_cuenta('00100002',@saldo);
select @saldo;

*/