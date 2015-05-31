create or replace procedure usp_egcc_movimientos
( p_cuenta IN cuenta.chr_cuencodigo%TYPE, 
  p_cursor OUT NOCOPY SYS_REFCURSOR )
as begin
  open p_cursor for 
    select 
      m.chr_cuencodigo cuenta,
      m.int_movinumero nromov,
      m.dtt_movifecha fecha,
      m.chr_tipocodigo tipo,
      t.vch_tipodescripcion descripcion,
      t.vch_tipoaccion accion,
      m.dec_moviimporte importe
    from tipomovimiento t
    join movimiento m 
    on t.chr_tipocodigo = m.chr_tipocodigo
    where m.chr_cuencodigo = p_cuenta;
end;
/

declare
  v_cursor SYS_REFCURSOR;
  v_cuenta movimiento.chr_cuencodigo%TYPE;
  v_nromov movimiento.int_movinumero%TYPE;
  v_fecha movimiento.dtt_movifecha%TYPE;
  v_tipo tipomovimiento.chr_tipocodigo%TYPE;
  v_desc tipomovimiento.vch_tipodescripcion%TYPE;
  v_accion tipomovimiento.vch_tipoaccion%TYPE;
  v_importe movimiento.dec_moviimporte%TYPE;
begin
  usp_egcc_movimientos( '00100001', v_cursor );
  loop
    fetch v_cursor into v_cuenta, v_nromov, v_fecha, 
      v_tipo, v_desc, v_accion, v_importe;
    exit when v_cursor%NOTFOUND;
    dbms_output.put_line(v_cuenta || ' | ' || v_nromov
      || ' | ' || v_fecha || ' | ' || v_tipo || ' | ' || 
      v_desc || ' | ' || v_accion || ' | ' || v_importe);
  end loop;
  close v_cursor;
end;
/

