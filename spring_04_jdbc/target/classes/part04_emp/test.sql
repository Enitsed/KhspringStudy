select b.* from (select rownum as rn, a.* from (select * from employees order by salary desc)a)b where rn > 5 and rn < 11

select * from mem order by num

delete from mem where num = 42;
alter table mem
add constraint mem_num_pk primary key(num);