
CALL usp_actualiza_datos_cliente( @estado, '00021', 'GUARACHI', 
'CORONEL', 'ALEJANDRA MARIEL', '10459823', 'CHICLAYO', 
'FRANCISCO CABRERA 1255', '2398456', 'alejandra@perudev.com' );

select @estado;



CALL usp_actualiza_datos_cliente( @estado, '00021', 'GUARACHI', 
NULL, 'ALEJANDRA MARIEL', '10459823', 'CHICLAYO', 
'FRANCISCO CABRERA 1255', '2398456', 'alejandra@perudev.com' );

select @estado;


SELECT * FROM CLIENTE ORDER BY 1 DESC;