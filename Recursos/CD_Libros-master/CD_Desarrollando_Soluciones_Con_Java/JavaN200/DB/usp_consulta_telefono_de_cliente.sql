DELIMITER $$

CREATE PROCEDURE usp_consulta_telefono_de_cliente2
( in codigo char(5), out telefono varchar(20) )
BEGIN

  select vch_clietelefono 
  into telefono
  from cliente
  where chr_cliecodigo = codigo;

END$$

DELIMITER ;
//