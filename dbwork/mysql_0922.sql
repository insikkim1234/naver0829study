#table조회
show tables; -- 전체 테이블 조회
select *
from test01; -- test01 조회

desc test01; -- 테이블 구조 확인

-- insert
insert into test01 (name,age)
values ('kim','40');
-- num 에 nulll 값을 주면 auto 숫자 발생
insert into test01
values (null,'son',26,188.9,now(),'2023-01-01');

-- table구조 변경(add, drop column,modify,rename)
-- 컬럼추가
alter table test01 
add hp varchar(20)
default '010-1111-1111';
-- 컬럼 삭제
alter table test01
drop column age;
-- 컬럼명 수정
alter table test01
rename column birthday to 
birth;

-- 테이블명 변경a
alter table test01
rename member;
-- 사원 테이블 생성 후 제약조건 추가
 create table sawon (
              num smallint auto_increment,
              name varchar(20),
              score smallint,
              gender varchar(10),
              buseo varchar(10),
              constraint pk_sawon_num primary key(num),
  		constraint ck_sawon_score check (score between 0 and 100),
 		constraint ck_sawon_gender check (gender in ('여자','남자')));
        
        
desc sawon;
-- 사원의 제약 조건들 확인하기
 select * 
 from information_schema.table_constraints 
 where table_name='sawon';
 
 -- 데이터 추가
 insert into sawon
 values(null,'이하나',89,'여자','홍보부');
 
 -- 제약 조건 오류 확인하기
 insert into sawon 
 values (null,'이두나',120,'여자','홍보부');-- 점수
 
  insert into sawon 
 values (null,'이두나',120,'여','홍보부');-- 성별alter
 
 -- 제대로된 데이터 각자 7개 정도 추가alter
 insert into sawon
 values (null,'강호동',90,'남자','인사부');
 insert into sawon
 values (null,'한가인',67,'여자','인사부');
 insert into sawon
 values (null,'오연수',79,'여자','홍보부');
 insert into sawon
 values (null,'손지창',99,'남자','인사부');
 insert into sawon
 values (null,'손호준',100,'남자','교육부');
 insert into sawon
 values (null,'이서진',87,'남자','인사부');
 insert into sawon
 values (null,'광수',74,'남자','홍보부');
  insert into sawon
 values (null,'이이랑',97,'남자','인사부');
-- select limit
select *
from sawon
order by name asc;

select *
from sawon
order by name limit 0,3;

select *
from sawon
order by name limit 3,3;

-- 문자함수들 연습
select concat('hello','kitty','!!')
from dual;

-- sawon의name에서 '이' 를 포함한 데이터 조회
select *
from sawon
where name like concat('%','이','%');

-- happy를 나이스로 변경후 출력
select replace('happy day!!','happy','nice')
from dual;
-- day의 위치찾기 1부터
select instr('happy day','day')
from dual;

select instr('happy day','hello')
from dual;-- 없으면 0
-- 왼쪽에서 4글자 추철
select left('have a nice day',4) 
from dual;

select right('have a nice day',8)
from dual;     

select mid('have a nice day',6,6)
from dual;        

select substring('have a nice day',6,6)
from dual;


-- 왼쪽 공백 제거
select ltrim('          hello           ')
from dual;
-- 오른쪽
select rtrim('          hello           ')
from dual;
-- 양쪽
select trim('          hello           ')
from dual;

-- 대소문자 변환
select lcase('Happy')
from dual;

select lower('Happy')
from dual;

select ucase('Happy')
from dual;

select upper('Happy')
from dual;

-- reverese

select reverse('Happy')
from dual;
