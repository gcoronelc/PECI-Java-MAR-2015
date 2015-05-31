
create or replace procedure usp_crea_producto(
	p_idprod out nocopy producto.idprod%type,
	p_idcat in producto.idcat%type,
	p_nombre in producto.nombre%type,
	p_precio in producto.precio%type,
	p_stock in producto.stock%type
) as
begin 
	insert into producto(idprod,idcat,nombre,
	precio,stock) values(sq_Producto.nextval,
	p_idcat, p_nombre, p_precio, p_stock)
	RETURNING idprod INTO p_idprod;
	commit;
exception
	when others then
		rollback;
		raise_application_error(-20000,'Error en el proceso.');
end;


declare
  id number(5);
begin
  usp_crea_producto(id, 3, 'Demo', 56, 67);
  dbms_output.put_line( 'id = ' || id );
end;
/

