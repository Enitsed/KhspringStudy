
---------------------------------------------------------------


create table deptex(
 dno number primary key,
 dname varchar2(100));
 
 insert into deptex values(10,'aaa');
 insert into deptex values(20,'bbb');
 select * from deptex;

 create table empex( 
 num number primary key,
 name varchar2(100),
 dno number,
 constraint deptno_pk foreign key(dno)
  references deptex(dno) on delete cascade
 );

 insert into empex values(1,'one',10);
 delete from deptex where dno=10;
 select * from empex;
 
select table_name, constraint_name  from user_constraints; 
select * from ALL_CONSTRAINTS WHERE TABLE_NAME='EMP09';
alter table EMP09 drop constraint emp09_deptno_fk;
 
 
[ 트리거 ]
 개발자가 호출해서 사용하는 것이 아니라, 특정 이벤트와 연동해서 그 이벤트, 조건이 발생시
 자동적으로 수행하는 동작을 의미한다.
  (데이터베이스가 미리 정해 놓은 조건들을 만족하거나, 특정 이벤트가 발생하면 자동적으로
  수행되는 동작(PL/SQL 블럭)으로 오라클에서 자동적으로 실행되는 PL/SQL 블럭을 의미)

[트리거 형식]

CREATE or REPLACE TRIGGER 트리거이름

BEFORE|AFTER 

[INSERT,DELETE,UPDATE]ON 테이블이름

[Referencing OLD AS {변경전 값을 참조하는 변수명} NEW AS {변경후 값을 참조하는 변수명}]

[ FOR EACH ROW ]

DECLARE

-- 변수선언

BEGIN

-- 트리거 코드

EXCEPTION

WHEN

--익셉션

END;

[이벤트]
 INSERT, UPDATE, DELETE
 BEFORE : 구문을 실행하기 전에 트리거를 시작
 AFTER : 구문을 실행한 후에 트리거를 시작
 FOR EACH ROW : 행 트리거임을 알림
 WHEN 조건 : 사용자의 트리거 이벤트 중에 조건에 만족하는 데이터만 트리거 한다.
 REFERENCING : 영향 받는 행의 값을 참조

 :NEW.컬럼명: DML트리거의 수정 또는 삽입문 내에서 사용이 가능하다. -> SQL 반영 후의 컬럼 데이터
 :OLD.컬럼명 : DML트리거의 수정 또는 삭제문 내에서 사용이 가능하다. -> SQL 반영전의 컬럼 데이터