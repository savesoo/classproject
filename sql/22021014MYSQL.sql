-- cross join
select *
from emp cross join dept;

-- 테이블 별칭을 이용한 컬럼 구별
select *
from emp e inner join dept d
on e.deptno = d.deptno;

select e1.ename, e2.ename
from emp e1 left outer join emp e2 -- 표시할 대상 개체: 왼쪽을 다 출력할 것이다
on e1.mgr=e2.empno;

select e1.ename, e2.ename
from emp e1 right outer join emp e2 -- 오른쪽을 다 출력할 것이다
on e1.empno=e2.mgr;

select empno, ename, job, dname, loc
from emp e join dept d -- 콤마는 cross join과 같다
on e.deptno=d.deptno
where ename='SCOTT'
;

select empno, ename, job, dname, loc
from emp e cross join dept d
;

select empno, ename, losal, sal, hisal, grade
from emp e join salgrade s
on e.sal between s.losal and s.hisal
;

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