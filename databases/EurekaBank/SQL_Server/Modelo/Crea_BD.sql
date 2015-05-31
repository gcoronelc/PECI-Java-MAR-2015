/*
Empresa        :  EurekaBank
Software       :  Sistema de Cuentas de Ahorro
DBMS           :  SQL Server
Base de Datos  :  eurekabank
Script         :  Crea la Base de Datos
Responsable    :  Ing. Eric Gustavo Coronel Castillo
Telefono       :  (511) 9966-64457
Email          :  gcoronelc@gmail.com
Blog           :  http://gcoronelc.blogspot.com
*/


-- =============================================
-- Creación de la Base de Datos
-- =============================================

USE master;
go

IF( EXISTS ( SELECT name FROM master.sys.databases WHERE name = 'EUREKABANK' ) )
BEGIN
	DROP DATABASE EUREKABANK;
END;
go

CREATE DATABASE EUREKABANK;
go


-- =============================================
-- Seleccionar la Base de Datos
-- =============================================

USE EUREKABANK;
go


-- =============================================
-- Creación de los Objetos de la Base de Datos
-- =============================================

CREATE TABLE TipoMovimiento (
	chr_tipocodigo       CHAR(3) NOT NULL,
	vch_tipodescripcion  VARCHAR(40) NOT NULL,
	vch_tipoaccion       VARCHAR(10) NOT NULL,
	vch_tipoestado       VARCHAR(15) DEFAULT 'ACTIVO' NOT NULL,
	CONSTRAINT PK_TipoMovimiento PRIMARY KEY (chr_tipocodigo),
	CONSTRAINT chk_tipomovimiento_vch_tipoaccion
		CHECK (vch_tipoaccion IN ('INGRESO', 'SALIDA')),
	CONSTRAINT chk_tipomovimiento_vch_tipoestado
		CHECK (vch_tipoestado IN ('ACTIVO', 'ANULADO', 'CANCELADO'))						
);
go

CREATE TABLE Sucursal (
	chr_sucucodigo       CHAR(3) NOT NULL,
	vch_sucunombre       VARCHAR(50) NOT NULL,
	vch_sucuciudad       VARCHAR(30) NOT NULL,
	vch_sucudireccion    VARCHAR(50) NULL,
		int_sucucontcuenta   INTEGER NOT NULL,
	CONSTRAINT PK_Sucursal PRIMARY KEY (chr_sucucodigo)
);
go

CREATE TABLE Empleado (
	chr_emplcodigo       CHAR(4) NOT NULL,
	vch_emplpaterno      VARCHAR(25) NOT NULL,
	vch_emplmaterno      VARCHAR(25) NOT NULL,
	vch_emplnombre       VARCHAR(30) NOT NULL,
	vch_emplciudad       VARCHAR(30) NOT NULL,
	vch_empldireccion    VARCHAR(50) NULL,
	vch_emplusuario      VARCHAR(15) NOT NULL,
	vch_emplclave        VARCHAR(15) NOT NULL,
	CONSTRAINT PK_Empleado PRIMARY KEY (chr_emplcodigo),
	CONSTRAINT U_Empleado_vch_emplusuario UNIQUE (vch_emplusuario)
);
go

CREATE TABLE Asignado (
	chr_asigcodigo       CHAR(6) NOT NULL,
	chr_sucucodigo       CHAR(3) NOT NULL,
	chr_emplcodigo       CHAR(4) NOT NULL,
	dtt_asigfechaalta    DATETIME NOT NULL,
	dtt_asigfechabaja    DATETIME NULL,
	CONSTRAINT PK_Asignado PRIMARY KEY (chr_asigcodigo), 
	CONSTRAINT fk_asignado_empleado FOREIGN KEY (chr_emplcodigo) REFERENCES Empleado (chr_emplcodigo), 
	CONSTRAINT fk_asignado_sucursal FOREIGN KEY (chr_sucucodigo) REFERENCES Sucursal (chr_sucucodigo)
);
go

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
	CONSTRAINT PK_Cliente PRIMARY KEY (chr_cliecodigo)
);
go

CREATE TABLE Moneda (
	chr_monecodigo       CHAR(2) NOT NULL,
	vch_monedescripcion  VARCHAR(20) NOT NULL,
	CONSTRAINT PK_Moneda PRIMARY KEY (chr_monecodigo)
);
go

CREATE TABLE Cuenta (
	chr_cuencodigo       CHAR(8) NOT NULL,
	chr_monecodigo       CHAR(2) NOT NULL,
	chr_sucucodigo       CHAR(3) NOT NULL,
	chr_emplcreacuenta   CHAR(4) NOT NULL,
	chr_cliecodigo       CHAR(5) NOT NULL,
	dec_cuensaldo        MONEY NOT NULL,
	dtt_cuenfechacreacion DATETIME NOT NULL,
	vch_cuenestado       VARCHAR(15) DEFAULT 'ACTIVO' NOT NULL,
	int_cuencontmov      INTEGER NOT NULL,
	chr_cuenclave        CHAR(6) NOT NULL,
	CONSTRAINT chk_cuenta_chr_cuenestado
		CHECK (vch_cuenestado IN ('ACTIVO', 'ANULADO', 'CANCELADO')),
	CONSTRAINT PK_Cuenta PRIMARY KEY (chr_cuencodigo), 
	CONSTRAINT fk_cuenta_cliente FOREIGN KEY (chr_cliecodigo) REFERENCES Cliente (chr_cliecodigo), 
	CONSTRAINT fk_cuente_empleado FOREIGN KEY (chr_emplcreacuenta) REFERENCES Empleado (chr_emplcodigo), 
	CONSTRAINT fk_cuenta_sucursal FOREIGN KEY (chr_sucucodigo) REFERENCES Sucursal (chr_sucucodigo), 
	CONSTRAINT fk_cuenta_moneda FOREIGN KEY (chr_monecodigo) REFERENCES Moneda (chr_monecodigo)
);
go

CREATE TABLE Movimiento (
	chr_cuencodigo       CHAR(8) NOT NULL,
	int_movinumero       INTEGER NOT NULL,
	dtt_movifecha        DATETIME NOT NULL,
	chr_emplcodigo       CHAR(4) NOT NULL,
	chr_tipocodigo       CHAR(3) NOT NULL,
	dec_moviimporte      MONEY NOT NULL,
	chr_cuenreferencia   CHAR(8) NULL,
	CONSTRAINT chk_Movimiento_importe CHECK (dec_moviimporte >= 0.0),		 
	CONSTRAINT PK_Movimiento PRIMARY KEY (chr_cuencodigo, int_movinumero), 
	CONSTRAINT fk_movimiento_tipomovimiento FOREIGN KEY (chr_tipocodigo) REFERENCES TipoMovimiento (chr_tipocodigo),
	CONSTRAINT fk_movimiento_empleado FOREIGN KEY (chr_emplcodigo) REFERENCES Empleado (chr_emplcodigo), 
	CONSTRAINT fk_movimiento_cuenta FOREIGN KEY (chr_cuencodigo) REFERENCES Cuenta (chr_cuencodigo)
);
go

CREATE TABLE Parametro (
	chr_paracodigo       CHAR(3) NOT NULL,
	vch_paradescripcion  VARCHAR(50) NOT NULL,
	vch_paravalor        VARCHAR(70) NOT NULL,
	vch_paraestado       VARCHAR(15) DEFAULT 'ACTIVO' NOT NULL,
	CONSTRAINT chk_parametro_vch_paraestado
		CHECK (vch_paraestado IN ('ACTIVO', 'ANULADO', 'CANCELADO')),
	CONSTRAINT PK_Parametro PRIMARY KEY (chr_paracodigo)
);
go

CREATE TABLE InteresMensual (
	chr_monecodigo       CHAR(2) NOT NULL,
	dec_inteimporte      DECIMAL(12,2) NOT NULL,
	CONSTRAINT PK_InteresMensual PRIMARY KEY (chr_monecodigo), 
	CONSTRAINT fk_interesmensual_moneda FOREIGN KEY (chr_monecodigo) REFERENCES Moneda (chr_monecodigo)
);
go

CREATE TABLE CostoMovimiento (
	chr_monecodigo       CHAR(2) NOT NULL,
	dec_costimporte      MONEY NOT NULL,
	CONSTRAINT PK_CostoMovimiento PRIMARY KEY (chr_monecodigo), 
	CONSTRAINT fk_costomovimiento_moneda FOREIGN KEY (chr_monecodigo) REFERENCES Moneda (chr_monecodigo)
);
go

CREATE TABLE CargoMantenimiento (
	chr_monecodigo       CHAR(2) NOT NULL,
	dec_cargMontoMaximo  MONEY NOT NULL,
	dec_cargImporte      MONEY NOT NULL,
	CONSTRAINT PK_CargoMantenimiento PRIMARY KEY (chr_monecodigo), 
	CONSTRAINT fk_cargomantenimiento_moneda FOREIGN KEY (chr_monecodigo) REFERENCES Moneda (chr_monecodigo)
);
go

CREATE TABLE Contador (
	vch_conttabla        VARCHAR(30) NOT NULL,
	int_contitem         INTEGER NOT NULL,
	int_contlongitud     INTEGER NOT NULL,
	CONSTRAINT PK_Contador PRIMARY KEY (vch_conttabla)
);
go



