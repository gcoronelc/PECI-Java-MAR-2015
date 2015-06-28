
CREATE GLOBAL TEMPORARY TABLE tmp_egcc_demo(
  fila number not null,
  co_proyecto_actividad varchar2(10),
  estado_proyecto varchar2(20),
  anho char(4),
  co_tipo_intervencion char(2),
  co_criterio char(2)
) ON COMMIT PRESERVE ROWS;

-- Esto se implementa en un SP
begin

  -- Se elimina todas las filas
  delete from tmp_egcc_demo;
  
  -- generamos la maxima cantidad de filas posibles con datos generales
  FOR cont IN  1..1000
  LOOP
    insert into tmp_egcc_demo(fila, co_proyecto_actividad,estado_proyecto)
    select cont, co_proyecto_actividad,estado_proyecto 
    from GPVW_PROYECTO_ACTIVIDAD2
    where CO_PROYECTO_ACTIVIDAD='T000844' and CO_ANIO_EJEC='2016';
  END LOOP;
  
  -- Primera subconsulta  

  MERGE INTO tmp_egcc_demo a
  USING ( select rownum fila, ANHO, CO_TIPO_INTERVENCION, CO_CRITERIO
      from gptr_matriz_criterios
      where anho='2016' and CO_PROGRAMA_PRESUPUESTAL='0072' ) b
  ON ( a.fila = b.fila )
  WHEN MATCHED THEN 
  UPDATE SET  a.ANHO = b.ANHO,
              a.CO_TIPO_INTERVENCION = b.CO_TIPO_INTERVENCION,
              a.CO_CRITERIO = b.CO_CRITERIO;

end;

delete from tmp_egcc_demo;

select * from tmp_egcc_demo
order by 1
where CO_TIPO_INTERVENCION is not null;


