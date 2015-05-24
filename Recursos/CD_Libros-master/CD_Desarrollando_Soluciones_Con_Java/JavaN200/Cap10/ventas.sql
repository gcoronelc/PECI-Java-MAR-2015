create table ventas(
    id int not null auto_increment,
	tienda char(2) not null,
	fecha date not null,
	importe numeric(10,2) not null,
	primary key( id )
);

-- Enero

insert into ventas(tienda,fecha,importe) values('01','2008-01-05',400.00);
insert into ventas(tienda,fecha,importe) values('01','2008-01-11',300.00);
insert into ventas(tienda,fecha,importe) values('01','2008-01-14',800.00);
insert into ventas(tienda,fecha,importe) values('01','2008-01-20',100.00);
insert into ventas(tienda,fecha,importe) values('01','2008-01-25',700.00);

insert into ventas(tienda,fecha,importe) values('02','2008-01-05',200.00);
insert into ventas(tienda,fecha,importe) values('02','2008-01-11',800.00);
insert into ventas(tienda,fecha,importe) values('02','2008-01-14',100.00);
insert into ventas(tienda,fecha,importe) values('02','2008-01-20',300.00);
insert into ventas(tienda,fecha,importe) values('02','2008-01-25',600.00);

insert into ventas(tienda,fecha,importe) values('03','2008-01-05',900.00);
insert into ventas(tienda,fecha,importe) values('03','2008-01-11',200.00);
insert into ventas(tienda,fecha,importe) values('03','2008-01-14',600.00);
insert into ventas(tienda,fecha,importe) values('03','2008-01-20',400.00);
insert into ventas(tienda,fecha,importe) values('03','2008-01-25',200.00);

-- Febrero

insert into ventas(tienda,fecha,importe) values('01','2008-02-05',300.00);
insert into ventas(tienda,fecha,importe) values('01','2008-02-11',500.00);
insert into ventas(tienda,fecha,importe) values('01','2008-02-14',100.00);
insert into ventas(tienda,fecha,importe) values('01','2008-02-20',800.00);
insert into ventas(tienda,fecha,importe) values('01','2008-02-25',600.00);

insert into ventas(tienda,fecha,importe) values('02','2008-02-05',900.00);
insert into ventas(tienda,fecha,importe) values('02','2008-02-11',300.00);
insert into ventas(tienda,fecha,importe) values('02','2008-02-14',400.00);
insert into ventas(tienda,fecha,importe) values('02','2008-02-20',100.00);
insert into ventas(tienda,fecha,importe) values('02','2008-02-25',400.00);

insert into ventas(tienda,fecha,importe) values('03','2008-02-05',330.00);
insert into ventas(tienda,fecha,importe) values('03','2008-02-11',150.00);
insert into ventas(tienda,fecha,importe) values('03','2008-02-14',450.00);
insert into ventas(tienda,fecha,importe) values('03','2008-02-20',720.00);
insert into ventas(tienda,fecha,importe) values('03','2008-02-25',440.00);

-- Marzo

insert into ventas(tienda,fecha,importe) values('01','2008-03-05',530.00);
insert into ventas(tienda,fecha,importe) values('01','2008-03-11',650.00);
insert into ventas(tienda,fecha,importe) values('01','2008-03-14',910.00);
insert into ventas(tienda,fecha,importe) values('01','2008-03-20',180.00);
insert into ventas(tienda,fecha,importe) values('01','2008-03-25',260.00);

insert into ventas(tienda,fecha,importe) values('02','2008-03-05',910.00);
insert into ventas(tienda,fecha,importe) values('02','2008-03-11',330.00);
insert into ventas(tienda,fecha,importe) values('02','2008-03-14',420.00);
insert into ventas(tienda,fecha,importe) values('02','2008-03-20',160.00);
insert into ventas(tienda,fecha,importe) values('02','2008-03-25',480.00);

insert into ventas(tienda,fecha,importe) values('03','2008-03-05',230.00);
insert into ventas(tienda,fecha,importe) values('03','2008-03-11',350.00);
insert into ventas(tienda,fecha,importe) values('03','2008-03-14',650.00);
insert into ventas(tienda,fecha,importe) values('03','2008-03-20',120.00);
insert into ventas(tienda,fecha,importe) values('03','2008-03-25',840.00);


select 
	tienda,
	sum( case month(fecha) when 1 then importe else 0 end ) as Enero,
	sum( case month(fecha) when 2 then importe else 0 end ) as Febrero,
	sum( case month(fecha) when 3 then importe else 0 end ) as Marzo,
	sum( importe ) as total
from ventas
where year(fecha) = 2008
and month(fecha) in (1,2,3)
group by tienda;



