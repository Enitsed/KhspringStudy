--상품테이블
create table item(
  code varchar2(6) primary key, -- 상품 코드
  name varchar2(15) not null,--상품명
  company varchar2(15),--제조사
  price number(8),--소비자가격
  cnt number default 0 -- 재고 수량
);

select price from item where code='c0001'
select * from item where code='c0001'
select * from sales
select * from warehouse
delete from sales where num>=4

--상품추가
insert into item(code,name,company,price) values('c0001','선풍기','삼성',100000);
insert into item(code,name,company,price) values('c0002','에어컨','LG',50000);

drop table warehouse;
--입고테이블
create table warehouse(
  num number(6) primary key, --물품 입고 번호
  code varchar2(6),-- 상품코드
  indate date default sysdate, -- 입고 날짜
  incnt number(6),--입고수량
  inprice number(6),--입고단가
  constraint fk_code foreign key(code) references item(code)
);

--입고테이블 시퀀스
create sequence tb_insert_seq
start with 1
increment by 1
nocache
nocycle;

drop table sales;
--판매테이블
create table sales(
num number(6) primary key, --판매번호
code varchar2(6) not null  , --상품코드
sadate date default sysdate,--판매일자
sacnt number(6),--판매수량
saprice number(6),--판매단가
constraint fk_code2 foreign key(code) references item(code) 
);

--판매테이블 시퀀스
create sequence sa_insert_seq
start with 1
increment by 1
nocache
nocycle;

--창고(warehouse)에 상품이 입고될 때마다 상품(item)의 수량이 늘어나도록
-- [재고수량 갱신을 위한 트리거 생성]
create or replace trigger cnt_add
after insert on warehouse
for each row -- 각 row마다 반복한다는 의미
  begin
    update item set cnt = cnt + :new.incnt -- new 선언은 insert문,update문에서만 사용가능
    -- new키워드를 통해 warehouse 테이블 데이터에접근할 수 있고, warehouse 테이블에 insert작업이 이루어진 후의
    -- 데이터를 가지고 온다는 의미이다.(new)
    where code = :new.code;
  end;
/


insert into warehouse(num, code, incnt, inprice)
values(tb_insert_seq.nextval,'c0001',2,100000);
select * from item;
select * from warehouse;

--판매테이블에서 insert트리거를 작성(BEFORE트리거로 작성)
--[판매테이브레서 자료가 추가되는 경우 상품테이블의 재고수량이 변경되도록 트리거 작성
create or replace trigger trg_sales_insert
  before insert on sales
  for each row
begin
  update item
  set cnt=cnt-:NEW.sacnt
  where code=:NEW.code;
  end;
 / 
 
 insert into sales(num,code,sacnt,saprice)
values(sa_insert_seq.nextval,'c0001',200,
    (select price*1 from item  
     where code='c0001'))

select * from item;
select * from sales;
update item set cnt=100 where code='c0001'
select price from item where code='c0001';

