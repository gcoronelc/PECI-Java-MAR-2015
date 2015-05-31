DELIMITER $$

DROP PROCEDURE IF EXISTS usp_cantidad_empleados_por_ciudad$$

CREATE PROCEDURE usp_cantidad_empleados_por_ciudad()
BEGIN

	select vch_emplciudad as ciudad,  count(*) AS empleados
	from empleado
	group by vch_emplciudad
	order by vch_emplciudad ASC;

END$$

DELIMITER ;

/*

SHOW procedure status;

CALL usp_cantidad_empleados_por_ciudad();


*/