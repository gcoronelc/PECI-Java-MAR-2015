delimiter //

create function fn_factorial( n int )
returns int
begin
    declare f int default 1;
    while n > 1 do
        set f = f * n;
        set n = n - 1;
    end while;
    return f;
end //

delimiter ;
