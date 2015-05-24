delimiter //

create procedure sp_demo_loop()
begin
    declare n int;
    drop table if exists demo;
    create temporary table demo(id int, dato varchar(50) );
    set n = 0;
    proceso: loop
        set n = n + 1;
        if( n = 5 ) then
            iterate proceso;
        end if;
        insert into demo values(n,'Hola Gustavo');
        if( n = 8 || n = 5) then
            leave proceso;
        end if;
    end loop proceso;
    select * from demo;
end //

delimiter ;