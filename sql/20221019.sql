-- 22021019

-- Transaction : 일의 단위 -> 여러 DML 들을 묶어둔 것 
-- Commit : 작업의 완료 -> 데이터의 물리적 저장
-- Rollback : 작업 실패 -> 마지막 물리적 저장 상태로 회귀

drop table dept02;
create table dept02
as
select * from dept;

-- DDL 작업 후 자동 Commit

select * from dept02;
-- 트랜잭션 시작
insert into dept02 values (50, 'DEVELOPMENT', 'SEOUL');
insert into dept02 values (60, 'PLANNING', 'BUSAN');
update dept02 set loc='JEJU' where deptno=60;

rollback; -- 이전 상태로 돌아감
commit; -- 물리적 저장



---------------------------------------------------
-- 가상 테이블 : view 
-- 데이터를 제한할 수 있고, 복잡한 SQL을 단순하게 처리할 수 있다 

-- 자주 사용되는 30번 부서에 소속된 사원들의 사번과 이름과 부서번호를 출력하기 위한 SELECT문을 하나의 뷰로 정의해 봅시다. 
select empno, ename, deptno from emp where deptno=30;

-- View 생성
create or replace view emp_view30
as
select empno, ename, deptno from emp where deptno=30;

select * from emp_view30 where ename='JAMES';


select view_name, text
from user_views;

drop view emp_view30;


---------------------------------
-- Sequence : 자동 숫자 생성기
create sequence seq_dept_deptno
start with 10
increment by 10
;

create sequence seq_emp_empno;
select seq_emp_empno.nextval from dual;

-- 새로운 값을 생성 : nextval -> 다음 값을 생성해서 반환
select seq_dept_deptno.nextval from dual;
select seq_dept_deptno.currval from dual; -- 가장 마지막에 생성해서 현재 가진 값

-- sequence 삭제
drop sequence seq_dept_deptno;

drop table dept04;
create table dept04
as
select * from dept where 1=0;
select * from dept04;

insert into dept04 values (seq_dept_deptno.nextval, 'DEVELOPMENT', 'SEOUL'); -- 시퀀스를 통해 데이터 저장



-------------------------------
-- index : 검색의 성능을 향상시킬 때 사용

drop table emp01;

create table emp01
as
select * from emp;

select * from emp01;

insert into emp01 select * from emp01;
insert into emp01(empno, ename) values (1111, 'LEE');

select * from emp01 where ename='LEE';
delete from emp01 where ename='SON';

-- index 생성
create index index_emp01_ename on emp01(ename);

drop index index_emp01_ename;


select * from emp01 where empno=1111 and ename like '%LEE%';
select * from emp01 where ename like '%LEE%';
select * from emp01 where ename='%LEE%';

commit;

select * from emp where empno=1111;


select * from dept;
desc dept;
commit;

insert into dept values ('50', 'DEVELOPMENT', 'SEOUL');

update dept set dname='PLANNING', loc='JEJU' where deptno=50;

delete from dept where deptno=50;

rollback;