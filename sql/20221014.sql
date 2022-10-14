-- 20221014

-- join : 관계 있는 테이블의 스키마를 붙이는 것
select *
from emp, dept
where emp.deptno = dept.deptno; -- 유효한 데이터만 남김

-- 14 * 4 -> cross join의 결과 행 (56개)
-- MySQL
select *
from emp cross join dept;


select emp.ename, dept.dname
from emp, dept
where emp.deptno = dept.deptno; -- 질의 시점에 데이터를 가져옴

-- 테이블 별칭을 이용해서 컬럼 구별
select e.ename, d.dname
from emp e, dept d
where e.deptno = d.deptno;


-- mysql, mssql에서도 사용 가능
-- 가장 많이 사용하는 형태
select e.deptno
from emp e inner join dept d
on e.deptno = d.deptno;

select *
from emp e inner join dept d
using(deptno)
;

select deptno
from emp e inner join dept d
using(deptno)
;


select *
from emp natural join dept
; 
-- using과 같은 결과, 더 코드가 간단함




-- inner 생략 가능, 별칭 사용 가능
select *
from emp join dept
on emp.deptno = dept.deptno
;


-- self join : 자기 자신의 테이블과 조인
-- emp -> mgr : 상사의 사원번호
-- 각 사원들의 이름과 상사의 이름을 출력

select ename, mgr from emp;
select ename from emp where empno=7839 -- 하나하나 다 처리하기엔 번거로움
;

select e1.ename as "사원 이름", e2.ename as "상사 이름" 
from emp e1, emp e2
where e1.mgr = e2.empno(+)
;
-- null은 비교대상이 아니므로 연산대상 X
-- (+) 조건이 맞지 않더라도 뒤에 출력해줌(mysql에서는 사용 불가)

select e1.ename, e2.ename
from emp e1 left outer join emp e2 -- 표시할 대상 개체: 왼쪽을 다 출력
on e1.mgr=e2.empno
;

select e1.ename, e2.ename
from emp e1 right outer join emp e2 -- 오른쪽을 다 출력
on e1.empno=e2.mgr
;


-- 'SCOTT' 사원의 사원번호와 이름 직급 부서이름 부서위치를 출력
-- emp -> 사원번호, 이름, 직급
-- dept -> 부서이름, 부서위치

select empno, ename, job, dname, loc
from emp e, dept d 
where e.deptno=d.deptno
    and e.ename='SCOTT' 
;


-- 같은 결과~mysql~
select empno, ename, job, dname, loc
from emp e join dept d
on e.deptno=d.deptno
where ename='SCOTT'
;



---

select *
from book join orders
on book.bookid=orders.bookid
join customer
on orders.custid=customer.custid
;

-- salgrade 테이블을 참조해서 사원들의 사번, 이름, 급여, 급여 등급을 출력
select * from salgrade;

select empno, ename, losal, sal, hisal, grade
from emp e, salgrade s
where e.sal between s.losal and s.hisal
;

-- mysql
select empno, ename, losal, sal, hisal, grade
from emp e join salgrade s
on e.sal between s.losal and s.hisal
;


-- 판매 내역: 판매 정보, 판매 서적의 정보, 고객의 정보, 주문 이력
desc orders;
desc customer;


select orders.orderdate, customer.name, book.bookname, book.price, orders.saleprice
from book, customer, orders
where orders.custid=customer.custid and orders.bookid=book.bookid

order by orders.orderdate desc
;

select * from orders;
-- 주문이력 10개에 책과 고객의 정보를 붙인 것

select o.orderdate, c.name, b.bookname, b.price, o.saleprice
from orders o join customer c 
on o.custid=c.custid
join book b
on o.bookid=b.bookid
where name='박지성'
;


--mysql
select * from customer;

select c.name, count(*) as "구매횟수"
from orders o join customer c 
on o.custid=c.custid
join book b
on o.bookid=b.bookid


group by c.name
;

