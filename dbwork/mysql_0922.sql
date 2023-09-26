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


-- 조건함수 decode대체
select if(1=2,'happy','nice')
from dual;

select name,score, if(score>90,'합격','불합격') 평가
from sawon;


-- 오라클 nvl mysql에서는 if null

select name,ifnull(height,0)
from member;

-- 수학함수
select ceiling(5.3),ceiling(5.9)
from dual;

select floor(5.3),floor(5.9)
from dual;
-- 소수점 2자리까지 출력 뒤는 무조건 버림
select truncate(2.345,2)
from dual;
-- 나머지
select mod(7,2)
from dual;

-- group by 

-- 부서별 인원수 최고점수 최저점수 평균점후
select buseo 부서,count(*) 인원수,max(score) 최고점수,min(score) 최저점수,avg(score) 평균점수
from sawon
group by buseo;

-- 조인
create table bitclass (
   idx smallint primary key,
   class varchar(30),
   price int,
   gigan smallint);

create table stu (
   num smallint auto_increment primary key,
   name varchar(20),
   idx smallint,
   sugangday date,
   constraint stu_fk_idx foreign key(idx) references bitclass(idx));

-- bitclass 에 데이타 추가
insert into bitclass values (100,'Java',110000,10);
insert into bitclass values (200,'HTML5',90000,8);

insert into bitclass values (300,'jQuery',130000,12);
insert into bitclass values (400,'Oracle',180000,20);


-- stu 에 데이타 추가
insert into stu (name,idx,sugangday) values ('kim',200,now());
insert into stu (name,idx,sugangday) values ('lee',100,now());
insert into stu (name,idx,sugangday) values ('son',300,now());
insert into stu (name,idx,sugangday) values ('min',400,now());


-- inner join
select *
from bitclass b,stu s
where b.idx=s.idx;

-- inner join2
select *
from bitclass b
inner join stu s
on b.idx=s.idx;

-- s ub 테이블에 데이터가 추가된 상태에서 부모 테이블에 데이터를 삭제해 보자
delete from bitclass
where idx=100;-- 오류

-- sub 테이블의 데이타를 먼저 삭제 후 부모 테이블의 데이터 삭제
delete from stu
where idx=100;
delete from bitclass
where idx=100;

-- 연습용 join 모두 제거하기
drop table stu;
drop table bitclass;

drop table member;

