create table trabajador(
   id int not null auto_increment,
   nombre varchar(20) not null,
   jefe int null,
   primary key(id)
);

insert into trabajador(nombre,jefe) values('Gustavo',null);
insert into trabajador(nombre,jefe) values('Ricardo',1);
insert into trabajador(nombre,jefe) values('Sergio',1);
insert into trabajador(nombre,jefe) values('Hugo',1);
insert into trabajador(nombre,jefe) values('Claudia',2);
insert into trabajador(nombre,jefe) values('Julio',2);
insert into trabajador(nombre,jefe) values('Cesar',2);
insert into trabajador(nombre,jefe) values('Adriana',3);
insert into trabajador(nombre,jefe) values('Miguel',3);
insert into trabajador(nombre,jefe) values('Rosario',3);
insert into trabajador(nombre,jefe) values('Arturo',4);
insert into trabajador(nombre,jefe) values('Angel',4);
insert into trabajador(nombre,jefe) values('Andrea',4);

select t.id, t.nombre, j.nombre as jefe
from trabajador as t
join trabajador as j on t.jefe = j.id

