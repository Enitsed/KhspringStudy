select b.* from (select rownum as rn, a.* from (select * from employees order by salary desc)a)b where rn > 5 and rn < 11