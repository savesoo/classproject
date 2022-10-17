-- 20221017

-- 서브 쿼리
-- SCOTT이 소속된 부서 이름 출력
select dname
from emp e, dept d
where e.deptno=d.deptno
and ename='SCOTT'
;

select deptno from emp where ename='SCOTT';
select dname from dept where deptno=20;

-- 서브 쿼리 이용한 부서 찾기
select dname
from dept
where deptno = ( select deptno from emp where ename='SCOTT' ) -- 괄호 내부 먼저 실행 후 바깥 쿼리문 실행됨
;


-- 스칼라 부속 질의
select custid, (
                    select name from customer c where o.custid=c.custid
                ) as name
from orders o
group by custid
;

-- 마당서점의 고객별 판매액을 보이시오.
-- (결과는 고객 이름과 고객별 판매액을 출력)
select (
        select name from customer c where o.custid=c.custid
       ) as name, sum(saleprice) as total
from orders o
group by custid
;


-- 인라인 뷰 : from절 뒤에 쓰여지는 서브 쿼리 -> 가상 테이블
select o.custid, sum(saleprice)
from orders o, ( 
    select custid, name from customer where custid<=2
) c
where c.custid=o.custid
group by o.custid
;

select *
from (select empno, ename, job, hiredate from emp)
where ename='SCOTT'
;


-- 평균 급여보다
-- 더 많은 급여를 받는 사원을 검색하는
select *
from emp
where sal > ( select avg(sal) from emp )
;

select avg(sal) from emp ;

-- 평균 주문금액 이하의 주문에 대해서 주문번호와 금액을 보이시오.
select orderid, saleprice
from orders
where saleprice <= (select avg(saleprice) from orders)
;

-- 평균 구매액
select avg(saleprice) from orders ;

-- 각 고객의 평균 주문금액보다 큰 금액의 주문 내역에 대해서 주문번호, 고객번호, 금액을 보이시오.
select orderid, custid, saleprice
from orders
where saleprice >= (select avg(saleprice) from orders)
;

-- 주어진 문제가 3000 이상 받는 사원이 소속된 부서(10번, 20번)와 
-- 동일한 부서에서 근무하는 사원이기에 
-- 서브 쿼리의 결과 중에서 하나라도 일치하면 참인 결과를 구하는 IN 연산자와 함께 사용

select *
from emp
-- where deptno=? or deptno=? or ...
where deptno in (select distinct deptno from emp where sal>=3000) -- 3000 이상의 급여자가 있는 부서
-- where deptno not in (select distinct deptno from emp where sal>=3000) -- 3000 이상 급여자가 없는 부서
;

select distinct deptno from emp where sal>=3000;

-- 대한민국에 거주하는 고객에게 판매한 
-- 도서의 총 판매액을 구하시오

select sum(saleprice) total
from orders
-- where custid = 1 or custid = 2 or ...
where custid in(select custid from customer where address like '%대한민국%' ) -- 기본키는 중복 안되므로 distinct 필요X
;

select custid from customer where address like '%대한민국%';

-- 3번 고객이 주문한 도서의 최고 금액보다 더 비싼 도서를 구입한 주문의 
-- 주문번호와 금액

-- all 연산자는 모든 값이 true

select orderid, saleprice
from orders
where saleprice > all (select saleprice from orders where custid=3)
;

select saleprice from orders where custid=3;

select orderid, saleprice
from orders
where saleprice > (select max(saleprice) from orders where custid=3)
;

-- 3번 고객의 최고 구매액
select max(saleprice) from orders where custid=3;


-- EXISTS 연산자로 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오
select sum(saleprice)
from orders o
where exists (select * from customer c where c.custid=o.custid and address like '%대한민국%')
;
-- 존재하는지만 확인하므로 따로 컬럼을 출력할 필요가 없음

select * from customer;

