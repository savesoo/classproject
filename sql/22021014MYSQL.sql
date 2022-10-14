-- cross join
select *
from emp cross join dept;

-- 테이블 별칭을 이용한 컬럼 구별
select *
from emp e inner join dept d
on e.deptno = d.deptno;

-- outer join : 다른 테이블에 없는 데이터 출력
select e1.ename, e2.ename
from emp e1 left outer join emp e2 
on e1.mgr=e2.empno;

select e1.ename, e2.ename
from emp e1 right outer join emp e2 
on e1.empno=e2.mgr;


select empno, ename, job, dname, loc
from emp e join dept d 
on e.deptno=d.deptno
where ename='SCOTT'
;

select empno, ename, job, dname, loc
from emp e, dept d -- 콤마는 cross join과 같다
where e.deptno=d.deptno
    and e.ename='SCOTT' 
;

select empno, ename, job, dname, loc
from emp e cross join dept d
;

-- salgrade 테이블을 참조해서 사원들의 사번, 이름, 급여, 급여 등급을 출력
select empno, ename, losal, sal, hisal, grade
from emp e join salgrade s
on e.sal between s.losal and s.hisal
;

-- 판매 내역: 판매 정보, 판매 서적의 정보, 고객의 정보, 주문 이력
select o.orderdate, c.name, b.bookname, b.price, o.saleprice
from orders o join customer c 
on o.custid=c.custid
join book b
on o.bookid=b.bookid
where name='박지성'
;

select c.name, count(*) as "구매횟수"
from orders o join customer c 
on o.custid=c.custid
join book b
on o.bookid=b.bookid
group by c.name
;