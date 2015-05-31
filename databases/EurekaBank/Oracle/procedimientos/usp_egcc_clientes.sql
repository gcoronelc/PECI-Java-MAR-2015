create or replace procedure usp_egcc_clientes
( p_nombre IN cliente.vch_clienombre%TYPE, 
  p_cursor OUT NOCOPY SYS_REFCURSOR )
as 
  v_criterio varchar2(100);
begin
  v_criterio := '%' || p_nombre || '%';
  open p_cursor for 
    select chr_cliecodigo, vch_cliepaterno, vch_cliematerno, 
      vch_clienombre, chr_cliedni, vch_clieciudad, 
      vch_cliedireccion, vch_clietelefono, vch_clieemail
    from cliente
    where vch_clienombre like v_criterio;
end;
/

declare
  v_cursor SYS_REFCURSOR;
  v_rec cliente%RowType;
begin
  usp_egcc_clientes( 'GU', v_cursor );
  loop
    fetch v_cursor into v_rec;
    exit when v_cursor%NOTFOUND;
    dbms_output.put_line(v_rec.chr_cliecodigo || ' | ' || v_rec.vch_cliepaterno
      || ' | ' || v_rec.vch_cliematerno || ' | ' || v_rec.vch_clienombre );
  end loop;
  close v_cursor;
end;
/

