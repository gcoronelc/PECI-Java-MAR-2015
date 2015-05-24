DELIMITER $$

DROP PROCEDURE IF EXISTS usp_actualiza_datos_cliente$$

CREATE PROCEDURE usp_actualiza_datos_cliente( 
	out p_estado varchar(200), -- Parámetro de salida
	p_cliecodigo char(5), 
	p_cliepaterno varchar(25), 
	p_cliematerno varchar(25),  
	p_clienombre varchar(30), 
	p_cliedni char(8), 
	p_clieciudad varchar(30),
	p_cliedireccion varchar(50), 
	p_clietelefono varchar(20),
	p_clieemail varchar(50) 
)
BEGIN

	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING, NOT FOUND
	BEGIN
		rollback;
		set p_estado = 'Error en el proceso de actualización.';
	END;

	start transaction;
	set p_estado = null;
	update cliente
	set
		vch_cliepaterno   = p_cliepaterno,
		vch_cliematerno   = p_cliematerno,
		vch_clienombre    = p_clienombre,
		chr_cliedni       = p_cliedni,
		vch_clieciudad    = p_clieciudad,
		vch_cliedireccion = p_cliedireccion,
		vch_clietelefono  = p_clietelefono,
		vch_clieemail     = p_clieemail
	where
		chr_cliecodigo = p_cliecodigo;

	commit;

END$$

DELIMITER ;