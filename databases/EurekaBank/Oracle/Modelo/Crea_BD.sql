/*
Empresa        :  EurekaBank
Software       :  Sistema de Cuentas de Ahorro
DBMS           :  Oracle
Base de Datos  :  eurekabank
Script         :  Crea la Base de Datos
Responsable    :  Ing. Eric Gustavo Coronel Castillo
Telefono       :  (511) 9966-64457
Email          :  gcoronelc@gmail.com
Blog           :  http://gcoronelc.blogspot.com
*/

-- =============================================
-- CRACIÓN DE LA APLICACIÓN
-- =============================================

DECLARE
	N INT;
	COMMAND VARCHAR2(200);
BEGIN
	COMMAND := 'DROP USER eureka CASCADE';
	SELECT COUNT(*) INTO N
	FROM DBA_USERS
	WHERE USERNAME = 'EUREKA';
	IF ( N = 1 ) THEN
		EXECUTE IMMEDIATE COMMAND;
	END IF;
END;
/

CREATE USER eureka IDENTIFIED BY admin;

GRANT CONNECT, RESOURCE TO eureka;


-- =============================================
-- CONECTARSE A LA APLICACIÓN
-- =============================================

CONNECT eureka/admin


-- =============================================
-- CREACIÓN DE LOS OBJETOS DE LA BASE DE DATOS
-- =============================================

CREATE TABLE Empleado (
       chr_emplcodigo       CHAR(4) NOT NULL,
       vch_emplpaterno      VARCHAR(25) NOT NULL,
       vch_emplmaterno      VARCHAR(25) NOT NULL,
       vch_emplnombre       VARCHAR(30) NOT NULL,
       vch_emplciudad       VARCHAR(30) NOT NULL,
       vch_empldireccion    VARCHAR(50) NOT NULL,
       vch_emplusuario      VARCHAR(15) NOT NULL,
       vch_emplclave        VARCHAR(15) NOT NULL,
       CONSTRAINT XPKEmpleado 
              PRIMARY KEY (chr_emplcodigo)
);


CREATE TABLE Sucursal (
       chr_sucucodigo       CHAR(3) NOT NULL,
       vch_sucunombre       VARCHAR(50) NOT NULL,
       vch_sucuciudad       VARCHAR(30) NOT NULL,
       vch_sucudireccion    VARCHAR(50) NOT NULL,
       int_sucucontcuenta   NUMBER(5,0) NOT NULL,
       CONSTRAINT XPKSucursal 
              PRIMARY KEY (chr_sucucodigo)
);


CREATE TABLE Asignado (
       chr_asigcodigo       CHAR(6) NOT NULL,
       chr_sucucodigo       CHAR(3) NOT NULL,
       chr_emplcodigo       CHAR(4) NOT NULL,
       dtt_asigfechaalta    DATE NOT NULL,
       dtt_asigfechabaja    DATE NULL,
       CONSTRAINT XPKAsignado 
              PRIMARY KEY (chr_asigcodigo), 
       CONSTRAINT fk_asignado_empleado
              FOREIGN KEY (chr_emplcodigo)
                             REFERENCES Empleado, 
       CONSTRAINT fk_asignado_sucursal
              FOREIGN KEY (chr_sucucodigo)
                             REFERENCES Sucursal
);


CREATE TABLE TipoMovimiento (
       chr_tipocodigo       CHAR(3) NOT NULL,
       vch_tipodescripcion  VARCHAR(40) NOT NULL,
       vch_tipoaccion       VARCHAR(10) NOT NULL
                                   CONSTRAINT chk_tipomovimiento_accion8
                                          CHECK (vch_tipoaccion IN ('INGRESO', 'SALIDA')),
       vch_tipoestado       VARCHAR(15) DEFAULT 'ACTIVO' NOT NULL
                                   CONSTRAINT chk_estado21
                                          CHECK (vch_tipoestado IN ('ACTIVO', 'ANULADO', 'CANCELADO')),
       CONSTRAINT XPKTipoMovimiento 
              PRIMARY KEY (chr_tipocodigo)
);


CREATE TABLE Cliente (
       chr_cliecodigo       CHAR(5) NOT NULL,
       vch_cliepaterno      VARCHAR(25) NOT NULL,
       vch_cliematerno      VARCHAR(25) NOT NULL,
       vch_clienombre       VARCHAR(30) NOT NULL,
       chr_cliedni          CHAR(8) NOT NULL,
       vch_clieciudad       VARCHAR(30) NOT NULL,
       vch_cliedireccion    VARCHAR(50) NOT NULL,
       vch_clietelefono     VARCHAR(20) NULL,
       vch_clieemail        VARCHAR(50) NULL,
       CONSTRAINT XPKCliente 
              PRIMARY KEY (chr_cliecodigo)
);


CREATE TABLE Moneda (
       chr_monecodigo       CHAR(2) NOT NULL,
       vch_monedescripcion  VARCHAR(20) NOT NULL,
       CONSTRAINT XPKMoneda 
              PRIMARY KEY (chr_monecodigo)
);


CREATE TABLE Cuenta (
       chr_cuencodigo       CHAR(8) NOT NULL,
       chr_monecodigo       CHAR(2) NOT NULL,
       chr_sucucodigo       CHAR(3) NOT NULL,
       chr_emplcreacuenta   CHAR(4) NOT NULL,
       chr_cliecodigo       CHAR(5) NOT NULL,
       dec_cuensaldo        NUMBER(12,2) NOT NULL,
       dtt_cuenfechacreacion DATE NOT NULL,
       vch_cuenestado       VARCHAR(15) DEFAULT 'ACTIVO' NOT NULL
                                   CONSTRAINT chk_estado22
                                          CHECK (vch_cuenestado IN ('ACTIVO', 'ANULADO', 'CANCELADO')),
       int_cuencontmov      NUMBER(6,0) NOT NULL,
       chr_cuenclave        CHAR(6) NOT NULL,
       CONSTRAINT XPKCuenta 
              PRIMARY KEY (chr_cuencodigo), 
       CONSTRAINT fk_cuente_cliente
              FOREIGN KEY (chr_cliecodigo)
                             REFERENCES Cliente, 
       CONSTRAINT fk_cuente_empleado
              FOREIGN KEY (chr_emplcreacuenta)
                             REFERENCES Empleado, 
       CONSTRAINT fk_cuenta_sucursal
              FOREIGN KEY (chr_sucucodigo)
                             REFERENCES Sucursal, 
       CONSTRAINT fk_cuenta_moneda
              FOREIGN KEY (chr_monecodigo)
                             REFERENCES Moneda
);


CREATE TABLE Movimiento (
       chr_cuencodigo       CHAR(8) NOT NULL,
       int_movinumero       NUMBER(6,0) NOT NULL,
       dtt_movifecha        DATE NOT NULL,
       chr_emplcodigo       CHAR(4) NOT NULL,
       chr_tipocodigo       CHAR(3) NOT NULL,
       dec_moviimporte      NUMBER(12,2) NOT NULL
                                   CONSTRAINT chk_importe8
                                          CHECK (dec_moviimporte >= 0.0),
       chr_cuenreferencia   CHAR(8) NULL,
       CONSTRAINT XPKMovimiento 
              PRIMARY KEY (chr_cuencodigo, int_movinumero), 
       CONSTRAINT fk_movimiento_tipomovimiento
              FOREIGN KEY (chr_tipocodigo)
                             REFERENCES TipoMovimiento, 
       CONSTRAINT fk_movimiento_empleado
              FOREIGN KEY (chr_emplcodigo)
                             REFERENCES Empleado, 
       CONSTRAINT fk_movimiento_cuenta
              FOREIGN KEY (chr_cuencodigo)
                             REFERENCES Cuenta
);


CREATE TABLE Parametro (
       chr_paracodigo       CHAR(3) NOT NULL,
       vch_paradescripcion  VARCHAR(50) NOT NULL,
       vch_paravalor        VARCHAR(70) NOT NULL,
       vch_paraestado       VARCHAR(15) DEFAULT 'ACTIVO' NOT NULL
                                   CONSTRAINT chk_estado23
                                          CHECK (vch_paraestado IN ('ACTIVO', 'ANULADO', 'CANCELADO')),
       CONSTRAINT XPKParametro 
              PRIMARY KEY (chr_paracodigo)
);


CREATE TABLE InteresMensual (
       chr_monecodigo       CHAR(2) NOT NULL,
       dec_inteimporte      NUMBER(12,2) NOT NULL,
       CONSTRAINT XPKInteresMensual 
              PRIMARY KEY (chr_monecodigo), 
       CONSTRAINT fk_interesmensual_moneda
              FOREIGN KEY (chr_monecodigo)
                             REFERENCES Moneda
);


CREATE TABLE CostoMovimiento (
       chr_monecodigo       CHAR(2) NOT NULL,
       dec_costimporte      NUMBER(12,2) NOT NULL,
       CONSTRAINT XPKCostoMovimiento 
              PRIMARY KEY (chr_monecodigo), 
       CONSTRAINT fk_costomovimiento_moneda
              FOREIGN KEY (chr_monecodigo)
                             REFERENCES Moneda
);


CREATE TABLE CargoMantenimiento (
       chr_monecodigo       CHAR(2) NOT NULL,
       dec_cargMontoMaximo  NUMBER(12,2) NOT NULL,
       dec_cargImporte      NUMBER(12,2) NOT NULL,
       CONSTRAINT XPKCargoMantenimiento 
              PRIMARY KEY (chr_monecodigo), 
       CONSTRAINT fk_cargomantenimiento_moneda
              FOREIGN KEY (chr_monecodigo)
                             REFERENCES Moneda
);


CREATE TABLE Contador (
       vch_conttabla        VARCHAR(30) NOT NULL,
       int_contitem         NUMBER(6,0) NOT NULL,
       int_contlongitud     NUMBER(3,0) NOT NULL,
       CONSTRAINT XPKContador 
              PRIMARY KEY (vch_conttabla)
);