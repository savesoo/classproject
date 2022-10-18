-- sub query exam

-- 43. 사원 번호가 7788인 사원과 
-- 담당 업무가 같은  : where job=''
-- 사원을 표시(사원 이름과 담당업무)하시오.

select e.ename, e.job
from emp e
where e.job = (select job from emp j where e.job=j.job and j.empno=7788)
;

select job from emp where empno=7788;

-- join 
select e1.ename, e1.job
from emp e1, emp e2
where e2.empno=7788 and e1.job=e2.job
;

-- 44. 사원번호가 7499인 사원보다 급여가 많은 사원을 표시하시오. 사원이름과 담당 업무

select e.ename, e.job
from emp e
where e.sal > (select sal from emp s where empno=7499)
;

select sal from emp where empno=7499;

​-- 45. 최소급여를 받는 사원의 이름, 담당업무 및 급여를 표시하시오. (그룹함수 사용)
select ename, job, sal
from emp
where sal = (select min(sal)
            from emp)
;

-- ex
select *
from emp
where sal = (select min(sal) from emp)
;

​-- 46. 평균급여가 가장 적은 직급의 직급 이름과 직급의 평균을 구하시오.
select job, avgSal
from (select job, avg(sal) as avgSal
        from emp
        group by job
        order by avgSal)
where rownum=1
;

select job, avg(sal) as avgSal
from emp
group by job
order by avgSal;

-- ex
select job, avg(sal)
from emp
group by job
having avg(sal) = (select min(avg(sal))
                    from emp
                    group by job)
;

select min(avg(sal))
from emp
group by job
;

-- 47. 각 부서의 최소 급여를 받는 사원의 이름, 급여, 부서번호를 표시하시오.
select ename, sal, deptno
from emp
where sal in(select min(sal)
             from emp
             group by deptno)
;

-- ex
select min(sal)
from emp
group by deptno;

select *
from emp e, (select deptno, min(sal) as minSal from emp group by deptno) m
where e.deptno=m.deptno and e.sal=m.minSal
;

-- 48. 담당업무가 ANALYST 인 사원보다 급여가 적으면서 
--     업무가 ANALYST가 아닌 
--     사원들을 표시(사원번호, 이름, 담당 업무, 급여)하시오. -> all 연산자
select empno, ename, job, sal
from emp
where job <> 'ANALYST' and sal < any(select min(sal)
                                from emp
                                where job='ANALYST')
;

-- ex
select empno, ename, job, sal
from emp
where sal < all(select distinct sal from emp where job='ANALYST') -- 모두 다 비교했을 때 작은 월급
;

-- 49. 부하직원이 없는 사원의 이름을 표시하시오.
-- 나의 사원번호가 다른 사원의 mgr에 있다면 -> 관리자
-- 나의 사원번호가 다른 사원에 mgr에 없다면 -> 부하직원이 없다!

select ename
from emp
where empno not in ( select distinct mgr from emp where mgr is not null)
;

select distinct mgr
from emp;

-- 50. 부하직원이 있는 사원의 이름을 표시하시오.
select ename
from emp
where empno in (select distinct mgr from emp where mgr is not null)
;

-- 51. BLAKE와 동일한 부서에 속한 사원의 
--     이름과 입사일을 표시하는 질의를 작성하시오. ( 단 BLAKE는 제외 )
select ename, hiredate
from emp
where deptno = (select deptno
                from emp
                where ename='BLAKE') and ename<>'BLAKE'
;

-- 52. 급여가 평균 급여보다 많은 사원들의 
--     사원 번호와 이름을 표시하되 결과를 
--     급여에 대해서 오름차순으로 정렬하시오.

select empno, ename, sal
from emp
where sal > (select avg(sal)
            from emp)
order by sal
;

-- 53. 이름에 K가 포함된 사원과 같은 부서에서 일하는 
--     사원의 사원 번호와 이름을 표시하시오.
select empno, ename
from emp
where deptno in(select deptno
                from emp
                where ename like '%K%')
;

-- ex
select *
from emp
where deptno in(select distinct deptno from emp where ename like '%K%')
;

-- 54. 부서위치가 DALLAS인 사원의 이름과 부서번호 및 담당업무를 표시하시오.
select ename, deptno, job
from emp
where deptno = (select deptno
                from dept
                where loc='DALLAS')
;

-- 부서의 위치가 DALLAS인 부서 번호
select deptno from dept where loc='DALLAS';

-- 55. KING에게 보고하는 사원의 이름과 급여를 표시하시오.
--     mgr에 KING의 사원번호가 있는 사원들
select ename, sal
from emp
where mgr = (select empno
            from emp
            where ename='KING')
;

select empno from emp where ename='KING';

-- 56. RESEARCH 부서의 사원에 대한 부서번호, 사원이름 및 담당 업무를 표시하시오.
select deptno, ename, job
from emp
where deptno = (select deptno
                from dept
                where dname='RESEARCH')
;

select deptno from dept where dname='RESEARCH';

-- 57. 평균 월급보다 많은 급여를 받고 
--     이름에 M이 포함된 사원과 같은 부서에서 근무하는 사원의 
--     사원 번호, 이름, 급여를 표시하시오.
select empno, ename, sal
from emp
where sal > (select avg(sal) from emp)
and deptno in(select deptno
                from emp
                where ename like '%M%')
;

-- ex
select *
from emp
where sal > (select avg(sal) from emp) and deptno in(select distinct deptno
                                                    from emp
                                                    where ename like '%M%')
;

select avg(sal) from emp;
select distinct deptno from emp where ename like '%M%';

-- 58. 평균급여가 가장 적은 업무를 찾으시오. (= 46번)
select s.job
from (select job, avg(sal)as avgSal
        from emp
        group by job
        order by avgSal) s
where rownum = 1
;

select job, avg(sal)as avgSal
from emp
group by job
order by avgSal;

-- ex
select job, avg(sal)
from emp
group by job
having avg(sal) = (select min(avg(sal)) from emp group by job)
;

select min(avg(sal)) from emp group by job;

-- 59. 담당업무가 MANAGER 인 사원이 소속된 부서와 동일한 부서의 사원을 표시하시오.
select ename
from emp
where deptno in (select deptno
                from emp
                where job='MANAGER')
;

-- ex
select deptno from emp where job='MANAGER';

select *
from emp
where deptno in (select deptno from emp where job='MANAGER')
;
