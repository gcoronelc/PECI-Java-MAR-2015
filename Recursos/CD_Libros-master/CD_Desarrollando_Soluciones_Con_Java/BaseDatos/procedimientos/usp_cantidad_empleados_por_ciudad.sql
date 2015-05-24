CREATE PROCEDURE usp_cantidad_empleados_por_ciudad()
begin

	select vch_emplciudad as ciudad,  count(*) AS empleados
	from empleado
	group by vch_emplciudad
	order by vch_emplciudad ASC;

end;