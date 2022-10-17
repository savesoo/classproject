-- join & sub query

-- 1 마당서점의 고객이 요구하는 다음 질문에 대해 SQL 문을 작성하시오.

-- (5) 박지성이 구매한 도서의 출판사 수
select count(publisher)
from book b, orders o
where b.bookid=o.bookid and custid=1
;


-- (6) 박지성이 구매한 도서의 이름, 가격, 정가와 판매가격의 차이
select bookname, price, b.price-o.saleprice as pricegap
from book b, orders o
where o.bookid=b.bookid and custid=1
;

-- (7) 박지성이 구매하지 않은 도서의 이름 ??????????
select distinct bookname
from book b, orders o
where  b.bookid=o.bookid and o.custid!=1
;

select distinct bookname
from book b, (select bookid from orders o where b.bookid=o.bookid)
where o.custid!=1
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

-- (9) 주문금액의 총액과 주문의 평균 금액
select sum(saleprice), avg(saleprice)
from orders o
;

-- (10) 고객의 이름과 고객별 구매액 ???????????????
select (select name from customer c where c.custid=o.custid), saleprice
from orders o
where c.custid=o.custid
;

-- (11) 고객의 이름과 고객이 구매한 도서 목록
select (select distinct name from customer c where c.custid=o.custid), (select bookname from book b where b.bookid=o.bookid)
from orders o
order by custid
;

-- (12) 도서의 가격(Book 테이블)과 판매가격(Orders 테이블)의 차이가 가장 많은 주문
select *
from orders o, book b
where in(b.bookid=o.bookid
;

-- (select price from book b where b.bookid=o.bookid), (select saleprice from orders o where b.bookid=o.bookid)

-- (13) 도서의 판매액 평균보다 자신의 구매액 평균이 더 높은 고객의 이름
select (select name from customer c where avg(saleprice
from orders o
where avg(select saleprice from orders o where c.custid=o.custid) > avg(select saleprice from orders o where o.bookid=b.bookid)
;

-- 3. 마당서점에서 다음의 심화된 질문에 대해 SQL 문을 작성하시오.

-- (1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
select (select name from customer c where custid=1)
from orders o
where bookid = any (select publisher from book b where b.bookid=o.bookid)
;

-- (2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름
