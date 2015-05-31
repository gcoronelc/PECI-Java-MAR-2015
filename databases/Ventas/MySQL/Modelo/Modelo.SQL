/*
Empresa        :  EGCC
Software       :  Sistema de Ventas
DBMS           :  MySQL
Esquema        :  ventas
Script         :  Crea la base de datos con sus respectivas tablas
Responsable    :  Ing. Eric Gustavo Coronel Castillo
Telefono       :  (511) 9966-64457
Email          :  gcoronelc@gmail.com
Blog           :  http://gcoronelc.blogspot.com
Creado el      :  20-FEB-2015

20-FEB-2015 Se agrega la tabla USUARIO.
20-FEB-2015 Se modifica la PK de la tabla PAGO y se agrega un UNIQUE (IdVenta,IdTipo)
*/



-- =============================================
-- CreaciÃ³n de la Base de Datos
-- =============================================

DROP DATABASE IF EXISTS VENTAS;

CREATE DATABASE VENTAS;


-- =============================================
-- Seleccionar la Base de Datos
-- =============================================

USE VENTAS;


-- =============================================
-- CREACION DE TABLAS DE EMPLEADOS
-- =============================================

CREATE TABLE EMPLEADO
(
	idemp                INTEGER AUTO_INCREMENT,
	nombre               VARCHAR(50) NOT NULL,
	apellido             VARCHAR(50) NOT NULL,
	email                VARCHAR(50) NOT NULL,
	telefono             VARCHAR(20) NULL,
	PRIMARY KEY (idemp)
);


INSERT INTO EMPLEADO(IDEMP,NOMBRE,APELLIDO,EMAIL,TELEFONO) 
VALUES(1001,'CLAUDIA','RAMOS','cramos@gmail.com',NULL);

INSERT INTO EMPLEADO(IDEMP,NOMBRE,APELLIDO,EMAIL,TELEFONO)  
VALUES(1002,'ANGELICA','TORRES','atorres@gmail.com','967345634');

INSERT INTO EMPLEADO(IDEMP,NOMBRE,APELLIDO,EMAIL,TELEFONO)  
VALUES(1003,'KARLA','GUTIERREZ','kgutierrez@gmail.com','995466783');

INSERT INTO EMPLEADO(IDEMP,NOMBRE,APELLIDO,EMAIL,TELEFONO)  
VALUES(1004,'LEONOR','CARRASCO','lcarrasco@gmail.com','986754373');

-- =============================================
-- CREACION DE TABLAS DEL USUARIOS
-- =============================================

CREATE TABLE USUARIO
(
	idemp                INTEGER NOT NULL,
	usuario              VARCHAR(20) NOT NULL,
	clave                VARCHAR(40) NOT NULL,
	estado               NUMERIC(2,0) NOT NULL,
	PRIMARY KEY (idemp),
  CONSTRAINT CHK_USUARIO_ESTADO CHECK ( estado IN (1, 0) ),
	FOREIGN KEY fk_usuario_empleado (idemp) REFERENCES EMPLEADO (idemp)
);

INSERT INTO USUARIO(IDEMP, USUARIO, CLAVE, ESTADO)
VALUES(1002,'atorres',SHA('suerte'),1);

INSERT INTO USUARIO(IDEMP, USUARIO, CLAVE, ESTADO)
VALUES(1003,'kgutierrez',SHA('alegria'),1);

INSERT INTO USUARIO(IDEMP, USUARIO, CLAVE, ESTADO)
VALUES(1004,'lcarrasco',SHA('felicidad'),0);


-- =============================================
-- CREACION DE TABLAS DEL CATALOGO
-- =============================================


CREATE TABLE CATEGORIA
(
	idcat                INTEGER NOT NULL,
	nombre               VARCHAR(50) NOT NULL,
	PRIMARY KEY (idcat)
);

INSERT INTO CATEGORIA(IDCAT,NOMBRE) VALUES(1,'LINEA BLANCA');
INSERT INTO CATEGORIA(IDCAT,NOMBRE) VALUES(2,'MENAJE');
INSERT INTO CATEGORIA(IDCAT,NOMBRE) VALUES(3,'CAMA');
INSERT INTO CATEGORIA(IDCAT,NOMBRE) VALUES(4,'MUEBLES');
INSERT INTO CATEGORIA(IDCAT,NOMBRE) VALUES(5,'ROPA DE DAMAS');
INSERT INTO CATEGORIA(IDCAT,NOMBRE) VALUES(6,'ROPA DE CABALLEROS');
INSERT INTO CATEGORIA(IDCAT,NOMBRE) VALUES(7,'ROPA DE SEÑORITAS');
INSERT INTO CATEGORIA(IDCAT,NOMBRE) VALUES(8,'ROPA DE NIÑOS');
INSERT INTO CATEGORIA(IDCAT,NOMBRE) VALUES(9,'ROPA DE NIÑAS');
INSERT INTO CATEGORIA(IDCAT,NOMBRE) VALUES(10,'ELECTRODOMESTICOS');
INSERT INTO CATEGORIA(IDCAT,NOMBRE) VALUES(11,'COMPUTO');



CREATE TABLE PRODUCTO
(
	idprod               INTEGER AUTO_INCREMENT,
	idcat                INTEGER NOT NULL,
	nombre               VARCHAR(100) NOT NULL,
	precio               NUMERIC(10,2) NOT NULL,
	stock                INTEGER NOT NULL,
	PRIMARY KEY (idprod),
	FOREIGN KEY FK_PRODUCTO_CATEGORIA (idcat) REFERENCES CATEGORIA (idcat)
);

INSERT INTO PRODUCTO(IDPROD,IDCAT,NOMBRE,PRECIO,STOCK)
VALUES(1,1,'COCINA',900.0,456);

INSERT INTO PRODUCTO(IDPROD,IDCAT,NOMBRE,PRECIO,STOCK)
VALUES(2,7,'PANTALON',150.0,4567);

INSERT INTO PRODUCTO(IDPROD,IDCAT,NOMBRE,PRECIO,STOCK)
VALUES(3,1,'REFRIGERADORA',1300.0,690);

INSERT INTO PRODUCTO(IDPROD,IDCAT,NOMBRE,PRECIO,STOCK)
VALUES(4,7,'POLO DE VERANO',95.00,150);

INSERT INTO PRODUCTO(IDPROD,IDCAT,NOMBRE,PRECIO,STOCK)
VALUES(5,6,'CAMISA COLOR VERDE',140.00,250);

INSERT INTO PRODUCTO(IDPROD,IDCAT,NOMBRE,PRECIO,STOCK)
VALUES(6,6,'CAMISA DE CUADROS PEQUEÑOS',140.00,350);

INSERT INTO PRODUCTO(IDPROD,IDCAT,NOMBRE,PRECIO,STOCK)
VALUES(7,6,'PANTALON MODELO A1',1180.00,450);


-- =============================================
-- CREACION DE TABLAS DE VENTAS
-- =============================================

CREATE TABLE VENTA
(
	idventa              INTEGER AUTO_INCREMENT,
	cliente              VARCHAR(100) NOT NULL,
	fecha                DATE NOT NULL,
	importe              NUMERIC(10,2) NOT NULL,
	idemp                INTEGER NOT NULL,
	PRIMARY KEY (idventa),
	FOREIGN KEY FK_VENTA_USUARIO (idemp) REFERENCES USUARIO (idemp)
);


CREATE TABLE DETALLE
(
	iddetalle            INTEGER AUTO_INCREMENT,
	idventa              INTEGER NOT NULL,
	idprod               INTEGER NOT NULL,
	cant                 NUMERIC NOT NULL,
	precio               NUMERIC(10,2) NOT NULL,
	subtotal             NUMERIC(10,2) NULL,
	PRIMARY KEY (iddetalle),
	FOREIGN KEY FK_DETALLE_PRODUCTO (idprod) REFERENCES PRODUCTO (idprod),
	FOREIGN KEY FK_DETALLE_VENTA (idventa) REFERENCES VENTA (idventa)
);

CREATE UNIQUE INDEX U_DETALLE ON DETALLE
(
	idventa,
	idprod
);


-- =============================================
-- CREACION DE TABLAS DE PAGOS
-- =============================================

CREATE TABLE TIPO_PAGO
(
	idtipo               INTEGER NOT NULL,
	nombre               VARCHAR(50) NOT NULL,
	PRIMARY KEY (idtipo)
);


INSERT INTO TIPO_PAGO(IDTIPO,NOMBRE) VALUES(1,'EFECTIVO');
INSERT INTO TIPO_PAGO(IDTIPO,NOMBRE) VALUES(2,'TARJETA CREDITO');
INSERT INTO TIPO_PAGO(IDTIPO,NOMBRE) VALUES(3,'TARJETA DE DEBITO');
INSERT INTO TIPO_PAGO(IDTIPO,NOMBRE) VALUES(4,'CHEQUE');
INSERT INTO TIPO_PAGO(IDTIPO,NOMBRE) VALUES(5,'NOTA DE CREDITO');
INSERT INTO TIPO_PAGO(IDTIPO,NOMBRE) VALUES(6,'BONO EFECTIVO');


CREATE TABLE PAGO
(
	idpago               INTEGER AUTO_INCREMENT,
	idventa              INTEGER NOT NULL,
	idtipo               INTEGER NOT NULL,
	detalle              VARCHAR(100) NOT NULL,
	importe              NUMERIC(10,2) NOT NULL,
	obs                  VARCHAR(1000) NOT NULL,
	PRIMARY KEY (idpago),
	FOREIGN KEY FK_PAGO_VENTA (idventa) REFERENCES VENTA (idventa),
	FOREIGN KEY FK_PAGO_TIPO_PAGO (idtipo) REFERENCES TIPO_PAGO (idtipo)
);

CREATE UNIQUE INDEX U_PAGO_UNIQUE ON PAGO
(
	idventa,
	idtipo
);


-- =============================================
-- CREAR EL USUARIO
-- =============================================

USE MYSQL;
GRANT ALL PRIVILEGES ON *.* TO 'ventas'@'%' IDENTIFIED BY 'admin' WITH GRANT OPTION;
FLUSH PRIVILEGES;
USE VENTAS;

USE MYSQL;
GRANT ALL PRIVILEGES ON *.* TO 'ventas'@'localhost' IDENTIFIED BY 'admin' WITH GRANT OPTION;
FLUSH PRIVILEGES;
USE VENTAS;


-- =============================================
-- HABILITAR SALIDAS
-- =============================================

SELECT DATABASE();
SHOW TABLES;
