DECLARE
   v_cuenta cuenta.chr_cuencodigo%TYPE;
   v_saldo  cuenta.dec_cuensaldo%TYPE;
BEGIN
   
   UPDATE cuenta 
   SET dec_cuensaldo = dec_cuensaldo + 500 
   WHERE chr_cuencodigo = '00100001'
   RETURNING chr_cuencodigo, dec_cuensaldo 
   INTO v_cuenta, v_saldo;
   DBMS_OUTPUT.PUT_LINE('Cuenta: ' || v_cuenta);
   DBMS_OUTPUT.PUT_LINE('Saldo: ' || v_saldo);
   ROLLBACK;
END;
/