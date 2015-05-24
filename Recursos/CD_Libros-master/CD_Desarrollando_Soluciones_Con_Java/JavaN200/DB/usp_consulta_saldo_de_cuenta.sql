DELIMITER $$

CREATE PROCEDURE usp_consulta_saldo_de_cuenta
( inout dato varchar(15) )
BEGIN
  
	declare saldo numeric(10,2);
  
	select dec_cuensaldo 
	into saldo
	from cuenta
	where chr_cuencodigo = dato;

	if isnull(saldo) then
		set dato = null;
	else
		set dato = cast(saldo as char);
	end if;
  
END$$

DELIMITER ;