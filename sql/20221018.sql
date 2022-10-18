-- 20221018

-- inline view - rownum
-- from 절 뒤에 오는 서브 쿼리 -> inline view
-- select -> 결과도 테이블

select * from emp;

select rownum, emp.* from emp order by hiredate;

-- rownum : 시스템에서 제공하는 컬럼. 사용자가 생성하는 컬럼이 아니다!

select rownum, t.*
from (select * from emp order by hiredate) t -- 가상의 테이블로 사용하겠다
;

-- top3
-- 입사일이 가장 오래된 3명을 구하자!
select rownum, t.*
from (select * from emp order by hiredate) t
where rownum <=3
;

-----------------------------------------------------
-- DDL : 정의어 -> 객체를 정의하는 명령어

-- 데이터의 저장 공간 생성
-- create table 테이블 이름 (
--           컬럼이름 타입 [제약조건],
--           컬럼이름 타입 [제약조건],
--           ....
-- );

-- 테이블 생성과 제약조건
drop table emp01;

create table emp01 (
        empno number(4) constraint emp01_empno_pk primary key, -- 기본키(null, 중복 허용 X)
        ename varchar2(10) constraint emp01_ename_NN not null, -- null 허용X
        job varchar2(9)constraint emp01_job_UK unique, -- 유니크(중복X)
        sal number(7,2) constraint emp01_sal_CK check (sal between 500 and 5000), -- check
        gender char(1) constraint emp01_gender_CK check(gender in('M', 'F')) , -- check
        deptno number(2)constraint emp01_deptno_FK references dept(deptno), -- 외래키(참조한 테이블에 있는 데이터만 사용)
        hiredate date default sysdate -- 입력하지 않을시 디폴트 데이터 입력
);

-- 해당하는 데이터만 잘 들어가면 순서는 바뀌어도 상관 없음
insert into emp01 (empno, ename, sal, job, gender, deptno)
            values (1111, 'KING', 5000, '대표', 'M', 10);
            
insert into emp01 (empno, ename, sal, job, gender, deptno)
            values (1112, 'KING', 1500, '대리', 'F', 30);

select * from dept;     
select * from emp01;


create table emp02 (
        empno number(4),
        ename varchar2(10) constraint emp02_ename_NN not null,
        job varchar2(9),
        sal number(7,2),
        gender char(1), 
        deptno number(2),
        hiredate date default sysdate,
        constraint emp02_empno_pk primary key(empno),
        constraint emp02_job_uk unique(job),
        constraint emp02_sal_ck check(sal between 500 and 5000),
        constraint emp02_gender_ck check(gender in('M','F')),
        constraint emp_deptno_fk foreign key (deptno) references dept(deptno)
);

insert into emp02 (empno, ename, sal, job, gender, deptno)
            values (1111, 'KING', 5000, '대표', 'M', 10);

insert into emp02 (empno, ename, sal, job, gender, deptno)
            values (1112, 'KING', 1500, '대리', 'F', 90);
            
select * from emp02;
desc emp02;
insert into emp02 values (1113, 'SON', '주임', 1500, 'M', 40, '2022-10-17');
insert into emp02 (empno, ename) values(1114, 'SCOTT'); 
-- 지정 입력되지 않은 컬럼에는 null값이 등록 : 암묵적인 입력 방법

insert into emp02 values(1115, 'TOM', null, null, null, null, null);
insert into emp02 values(1116, 'CAT', '', '', '', '', '');


-------------------------------------
-- 데이터의 수정
-- update 테이블 이름 set 컬럼 이름=새로운 값, 컬럼이름=새로운 값 where 행 선택 조건

drop table emp03;
create table emp03 as select * from emp;

select * from emp03;

-- 모든 사원의 부서번호를 30으로 변경
update emp03 set deptno=30;

-- 모든 사원의 급여를 10% 인상
update emp03 set sal = sal*1.1;

-- 모든 사원의 입사일을 오늘로 수정
update emp03 set hiredate = sysdate;

-- 부서번호가 10번인 사원의 부서번호를 30번으로 변경
update emp03 set deptno=30 where deptno=10;

-- 급여가 3000 이상인 사원만 급여를 10% 인상
update emp03 set sal=sal*1.1 where sal>=3000;

-- 2개 이상의 칼럼 값 변경
-- SCOTT 사원의 부서번호는 20번으로, 직급은 MANAGER로 한꺼번에 수정
update emp03 set deptno=40, job='MANAGER' where ename='SCOTT';

-- 서브 쿼리를 이용한 데이터 수정
-- SMITH 사원을 SCOTT 사원의 부서로 이동
update emp03 set deptno = (select deptno from emp03 where ename='SCOTT') where ename='SMITH';



drop table dept01;
create table dept01 as select * from dept;
select * from dept01;

-- 부서 번호가 20번인 부서의 이름과 지역은 RESEARCH와 DALLAS
-- 부서 번호가 20인 부서의 부서명과 지역명을 부서 번호가 40번인 부서와 동일하게 변경
update dept01
set (dname, loc) = (select dname, loc from dept where deptno=40)
where deptno=20
;

select * from dept01;


-------------------------
-- 테이블의 행을 삭제
-- delete from 테이블 이름 where 행 선택 조건

-- DELETE 문으로 부서 테이블의 모든 행을 삭제
delete from dept01;

select * from dept01;

select * from emp03;

-- 대표 사퇴
delete from emp03 where empno=7839;

-- 40번 부서의 모든 사원 삭제
delete from emp03 where deptno=40;

select * from emp03;

-- 서브 쿼리 이용한 데이터 삭제
-- SALES 부서의 사원이 모두 퇴사 -> 삭제
delete from emp03 where deptno = (select deptno from dept where dname='SALES');
select deptno from dept where dname='SALES';
