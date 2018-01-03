create table orderitem(
 id varchar2(20),
 cnt number(10),
 remark varchar2(50),
 address varchar2(100));
 
 
 select * from orderitem
 
 create table emptest
 as
 select first_name, salary, hire_date
 from employees
 where 1=0;
 
 insert all
 into emptest
 values(first_name,salary,hire_date) 
 select first_name, salary,hire_date
 from employees;
 
 select * from emptest;