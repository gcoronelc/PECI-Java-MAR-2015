-- CASO 01

delimiter $$
      
create function fn_suma( a int, b int)
returns int
return (a+b)$$

delimiter ;

-- CASO 02

delimiter $$
      
create function fn_suma( a int, b int)
returns int
begin
    declare r int;
    set r = a + b;
    return r;
end $$   

delimiter ;


