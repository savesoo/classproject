-- 20221013


-- 함수 : 단일행 함수, 집합 함수

select ename, sal, nvl(comm, 0) as comm
from emp 
where comm >= 0 ;

-- 문자 함수

select lower('SCOTT') from dual ;
select ename, lower(ename) from emp ;

select Upper('scott') from dual;

select initcap('scott') from dual;

-- substr(문자열 원본, 시작 포인트, 반환할 개수) -> 이 문자열의 몇번째부터 몇 개를 출력
-- 특정 위치의 데이터를 출력할 때 사용
select substr('안녕하세요. 유재석입니다.', 2, 8) from dual;
select substr('안녕하세요. 유재석입니다.', 5) from dual; -- 이 위치부터 나머지 모두 반환

select length('안녕하세요. 유재석입니다.') from dual; -- 문자열의 개수 반환

-- lpad, rpad 특정 자리수 지정하고 그 자리에 데이터가 없는 경우 특정 패턴으로 채우는 함수
-- 00010, 00020, 00030, 00040, ....
select dname, deptno, lpad(deptno, 5, '0'), rpad(deptno, 5, 'A')
from dept; -- 총 5자리로 없으면 왼쪽을 0으로 채움, 총 5자리로 없으면 오른쪽을 A로 채움

select '     ABC', trim('     ABC'), 'ABC          ', trim('ABC          '), '     ABC     ', trim('     ABC     ')
from dual;

select replace('Harry Potter', 'Harry', 'H.'), replace('Harry Potter', 'Harry ', '')
from dual;

-- 숫자 함수

select -10, abs(-10)
from dual;

select 2.1, 2.9, floor(2.9)
from dual;

select 1234.567, round(1234.567, 1), round(1234.567, -1), round(1234.567)
from dual;

select 1234.567, trunc(1234.567, 1), trunc(1234.567, -1), trunc(1234.567) 
from dual;

select mod(1, 3), mod(2, 3), mod(3, 3), mod(0, 3), mod(3, 0)
from dual;

-- 날짜 함수

-- 현재 날짜
select sysdate
from dual;

select months_between(sysdate, '21/12/13') from dual;
select add_months(sysdate, -2) from dual;
select next_day(sysdate, 2) from dual;
select last_day(sysdate) from dual;
select round(sysdate) from dual;
select trunc(sysdate) from dual;

-- 변환 함수

-- to_char(원본, 'format')    2022.10.13 14:39
-- date -> varchar2
select sysdate, 
        to_char(sysdate, 'YYYY-MM-DD'), 
        to_char(sysdate, 'YYYY.MM.DD'),
        to_char(sysdate, 'YYYY.MM.DD. HH24:MI:SS')
from dual;

-- number -> varchar2
select to_char(123456789, '000000000000' ), 
       to_char(123456789, '999,999,999,999'),
       to_char(123456789, 'L999,999,999,999')
from dual;

select ename, sal, to_char(sal*1400, 'L999,999,999,999') as wonSal
from emp;


-- varchar2 -> date
-- to_date(문자열, '포맷=날짜형식')
-- 1999-12-24
select '1999-12-24', to_date('1999-12-24', 'YYYY-MM-DD')
from dual;


-- 참고
desc emp;

insert into emp values(9998, 'KKK', 'CLERK', 7782, '1982-12-12', 1300, null, 10 ); -- 형식에 맞게만 들어온다면 자동 형변환됨
select * from emp;

rollback; 
-- transaction 과정: 커밋 전까지는 추가, 수정, 삭제한 것이 저장되지 않음. rollback으로 원상복구 가능!

-- varchar2 -> number
-- to_date와 같은 형식
select
    to_number('20,000', '999,999') - to_number('10,000', '999,999')
from dual;

-- decode 함수 -> 여러가지 비교를 통해 결과 출력 switch-case 유사
select
    ename,
    deptno,
    decode( deptno, 10, 'ACCOUNTING'
                  , 20, 'RESEARCH'
                  , 30, 'SALES'
                  , 40, 'OPERATIONS'

    ) as dname
from emp;

-- 확인. job만 알고 싶으므로 distinct 사용
select distinct job from emp; 
-- 직급에 따라 급여를 인상하도록 하자. 
-- 직급이 'ANALYST'인 사원은 5%, 
-- 'SALESMAN'인 사원은 10%,
-- 'MANAGER'인 사원은 15%, 
-- 'CLERK'인 사원은 20% 인상한다. 

select 
    ename, job, sal,
    nvl(decode ( job, 'ANALYST', sal*1.05
                    , 'SALESMAN', sal*1.1
                    , 'MANAGER', sal*1.15
                    , 'CLERK', sal*1.2    
    ), sal) as upSal
from emp;
-- KING은 인상의 대상이 아니므로 null 출력


-- case ~ when ~ then
select ename, deptno,

    case when deptno=10 then 'ACCOUNTING'
         when deptno=20 then 'RESEARCH'
         when deptno=30 then 'SALES'
         when deptno=40 then 'OPERATIONS'
    end as dname
    
from emp;


-----------------------------------------
-- 그룹함수, 집합함수, 집계함수, 다중행 함수
-- sum, avg, count, max, min



-- 회사의 모든 사원의 급여 총액 : 월 지출액
select sum(sal)
from emp;

-- 커미션 총액 (null은 대상이 아님을 확인)
select sum(comm), count(comm), avg(comm)
from emp;

-- 급여 평균
select round(avg(sal), 2) 
from emp;

-- 최고 급여 구하기
select max(sal) from emp;

-- 최저 급여 구하기
select min(sal) from emp;

-- 전체 사원의 수
select count(*) from emp;

-- 부서의 개수
select count(*) from dept;

-- 보유한 책의 개수, 고객 수, 판매 횟수 등등


-- 직급의 수
select count(distinct job) from emp;

select distinct job from emp;


-- group by -> 특정 컬럼 값을 기준으로 그룹핑
select * from emp;

select sum(sal), count(*) from emp where deptno=10;
select sum(sal), count(*) from emp where deptno=20;
select sum(sal), count(*) from emp where deptno=30;
select sum(sal), count(*) from emp where deptno=40; -- 비효율적

select deptno, count(*), sum(sal), trunc(avg(sal)), max(sal), min(sal), count(comm)
from emp
group by deptno
-- 부서별 평균 급여가 2000 이상인 부서의 데이터만 출력
-- (select의 결과를 제한하는 조건은 where를 사용하나 그룹의 결과를 제한하는 조건은 having 사용!)
having avg(sal)>=2000
;

-- 직급별
select job, count(*)
from emp
group by job
-- having max(sal) >= 2900
;

