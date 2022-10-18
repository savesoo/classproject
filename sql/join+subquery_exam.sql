-- join & sub query

-- 1 마당서점의 고객이 요구하는 다음 질문에 대해 SQL 문을 작성하시오.

-- (5) 박지성이 구매한 도서의 출판사 수
select count(distinct publisher)
from book b, orders o
where b.bookid=o.bookid and custid = (select custid
                                    from customer c
                                    where name='박지성')
;

select bookid
from orders o
where custid=1;

select custid
from customer c
where name='박지성'
;

-- ex
select count(distinct publisher)
from book
;

select count(distinct publisher)
from orders o, book b, customer c
where o.bookid=b.bookid and o.custid=c.custid
and c.name='박지성'
;

select count(distinct publisher)
from orders o, book b
where o.bookid=b.bookid and custid = (select custid from customer c where name='박지성')
;

-- (6) 박지성이 구매한 도서의 이름, 가격, 정가와 판매가격의 차이
select bookname, price, b.price-o.saleprice as pricegap
from book b, orders o
where o.bookid=b.bookid and custid = (select custid
                                    from customer c
                                    where name='박지성')
;

-- ex
select bookname, price, b.price-o.saleprice as pricegap
from orders o, book b, customer c
where o.bookid=b.bookid and o.custid=c.custid
and c.name='박지성'
;

-- (7) 박지성이 구매하지 않은 도서의 이름
select bookname
from book b
where bookid not in (select distinct bookid
                    from orders o, customer c
                    where o.custid=c.custid and name='박지성')
;

select bookid
from orders o, customer c
where o.custid=c.custid and name='박지성'
;


-- 2 마당서점의 운영자와 경영자가 요구하는 다음 질문에 대해 SQL 문을 작성하시오.

-- (8) 주문하지 않은 고객의 이름(부속질의사용)
select name
from customer c
where not exists (select custid from orders o where c.custid=o.custid)
;

-- 주문한 고객
select (select name from customer c where c.custid=o.custid )
from orders o
group by custid
;

-- ex
-- 구매 고객
select distinct custid from orders;

select *
from customer
where custid not in(select distinct custid from orders)
;

select *
from customer c
where not exists (select * from orders o where c.custid=o.custid)
;

select name
from orders o, customer c
where o.custid = c.custid
;

select *
from customer c, orders o
where c.custid = o.custid(+) and o.orderid is null
;

-- my sql
select *
from customer c left outer join orders o
on c.custid = o.custid
where o.orderid is null
;

-- (9) 주문금액의 총액과 주문의 평균 금액
select sum(saleprice), avg(saleprice)
from orders o
;

-- (10) 고객의 이름과 고객별 구매액
select c.name, sum(o.saleprice)
from orders o, customer c
where o.custid = c.custid
group by c.name
;

select sum(saleprice)
from orders o
group by custid
;

-- ex
select c.custid, c.name, sum(saleprice) as total
from orders o, customer c
where o.custid=c.custid
group by c.custid, c.name
order by c.custid
;

-- (11) 고객의 이름과 고객이 구매한 도서 목록
select (select distinct name from customer c where c.custid=o.custid), (select bookname from book b where b.bookid=o.bookid)
from orders o
order by custid
;

-- ex
select name, bookname
from orders o, customer c, book b
where o.custid=c.custid and o.bookid=b.bookid
;

-- (12) 도서의 가격(Book 테이블)과 판매가격(Orders 테이블)의 차이가 가장 많은 주문
select *
from orders o, book b
where b.bookid=o.bookid and b.price-o.saleprice = (select max(b.price-o.saleprice) as pricegap
                                                    from orders o, book b
                                                    where b.bookid=o.bookid)
;

-- 가장 큰 차이
select max(b.price-o.saleprice) as pricegap
from orders o, book b
where b.bookid=o.bookid
order by pricegap desc
;


-- ex
select orderid, price, saleprice, price-saleprice
from orders o, book b
where o.bookid=b.bookid and price-saleprice = (select max(price-saleprice)
from orders o, book b
where o.bookid=b.bookid)
;

select max(price-saleprice)
from orders o, book b
where o.bookid=b.bookid
;


-- (select price from book b where b.bookid=o.bookid), (select saleprice from orders o where b.bookid=o.bookid)

-- (13) 도서의 판매액 평균보다 
--      자신의 구매액 평균이 더 높은 고객의 이름
select c.name
from customer c, 
    (select custid, avg(saleprice) as avg_SP
            from orders
            group by custid) cusA
where c.custid = cusA.custid
and cusA.avg_SP > (select avg(saleprice)
                   from orders)
;

-- 도서의 판매액 평균
select avg(saleprice)
from orders
;

-- 고객별 자신의 구매액 평균
select custid, avg(saleprice) as avg_SP
from orders o
group by custid
;

-- ex
select c.custid, name, avg(saleprice)
from orders o, customer c
where o.custid=c.custid
group by c.custid, name
having avg(saleprice) > (select avg(saleprice) from orders)
order by c.custid
;

-- 전체 판매액 평균
select avg(saleprice) from orders;


-- 3. 마당서점에서 다음의 심화된 질문에 대해 SQL 문을 작성하시오.
-- (1) 박지성이 구매한 도서의 출판사와 같은 
--     출판사에서 도서를 구매한 고객의 이름
select c.name
from orders o, book b, customer c 
where o.custid=c.custid and b.bookid=o.bookid 
and publisher in (select publisher
                from book b
                where bookid in(select bookid from orders o, customer c where o.custid=c.custid and name='박지성'))
and name<>'박지성'
;

select bookname, publisher from book b, orders o where b.bookid=o.bookid;

-- 박지성이 구매한 도서의 출판사
select publisher
from book b
where bookid in(select bookid from orders o, customer c where o.custid=c.custid and name='박지성')
order by publisher;

-- 박지성이 구매한 도서 id
select bookid
from orders o, customer c 
where o.custid=c.custid and name='박지성';


-- ex
select publisher
from orders o, customer c, book b
where o.custid=c.custid and o.bookid=b.bookid
and name='박지성'
;

select name
from orders o, customer c, book b
where o.custid=c.custid and o.bookid=b.bookid 
and publisher in(select publisher
                from orders o, customer c, book b
                where o.custid=c.custid and o.bookid=b.bookid
                and name='박지성')
and name<>'박지성'
;

-- (2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름
select name
from customer c, orders o, book b
where o.custid=c.custid and o.bookid=b.bookid 
group by name
having count(distinct publisher) > 1
;

-- ex
select o.custid, name, count(distinct publisher)
from orders o, customer c, book b
where o.custid=c.custid and o.bookid=b.bookid 
group by o.custid, name
having count(distinct publisher) > 1
;
