create table producto(
	chr_prodcodigo char(4) primary key,
	vch_prodnombre varchar2(30) not null,
	num_prodprecio numeric(10,2) not null,
	num_prodstock numeric(6,0) not null
);

insert into producto values('0001','TECLADO',55.00,55);
insert into producto values('0002','CASE DE 350W',120.00,48);
insert into producto values('0003','MEMORIA 1MB',80.00,62);
insert into producto values('0004','DISCO DURO SATA 160GB',186.00,34);