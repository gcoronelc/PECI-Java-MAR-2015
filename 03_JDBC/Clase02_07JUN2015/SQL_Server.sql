

select * from CursoProgramado;


declare @precio money;
begin tran;
update CursoProgramado
set @precio = PreCursoProg,
      PreCursoProg = PreCursoProg * 1.10
where IdCursoProg = 1;
print @precio;
rollback tran;






