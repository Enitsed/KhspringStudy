create table member (
	num number(5),
	id varchar2(20),
	pass varchar2(20)
)

select * from member

drop table member;

delete from member;

insert into member values(mem_seq.nextval, 'kim', '1235');

CREATE SEQUENCE mem_seq
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
SELECT fk.owner, fk.constraint_name , fk.table_name 
  FROM all_constraints fk, all_constraints pk 
 WHERE fk.R_CONSTRAINT_NAME = pk.CONSTRAINT_NAME
 ORDER BY fk.TABLE_NAME
