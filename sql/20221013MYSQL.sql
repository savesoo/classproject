-- 문자함수
select upper('scott') from dual;
select lower('SCOTT') from dual;
select concat('Steven', ' King') from dual;

select replace('Steven King', 'Steven', 'S.') from dual;

-- 포맷 -> 숫자의 자리수에 맞게 콤마 출력
select format('123456789', '000,000,000,000') from dual;

select lpad(40, 5, '0'), rpad(40, 5, 'A') from dual;

select substr('안녕하세요. 손흥민입니다.', 2) from dual;
select substr('안녕하세요. 손흥민입니다.', 2, 8) from dual;
select substring('안녕하세요. 손흥민입니다.', 2) from dual;
select substring('안녕하세요. 손흥민입니다.', 2,8) from dual;

select '     ABC', trim('     ABC'), 'ABC          ', trim('ABC          '), '          ABC          ', trim('          ABC          ')
from dual;


select now() from dual;

-- 숫자 함수

select -10, abs(-10) from dual;

select 2.1, 2.9, floor(2.9)  from dual;

select 1234.567, round(1234.527, 1), round(1235.527, -1), round(1235.527) from dual;

-- 오라클 => trunc
select 1234.567, truncate(1234.567, 0), truncate(1234.567, 1), truncate(1234.567, -1) from dual;

-- mysql에서 0나누기 결과 값은 null!!
select mod(1,3), mod(2,3), mod(3,3), mod(0,3), mod(3,0) from dual;




-- 날짜 시간 함수
-- 현재 시간
select CURDATE(), CURTIME(), NOW(), SYSDATE(), current_timestamp() from dual;
-- sql 실행 시점에 가져오게 됨

select year('2022-12-24'), -- sql에선 날짜 타입 하이픈으로 표시 
	   month(now()), 
	   day(now()), 
	   hour(now()), 
	   minute(now()), 
	   second(now()) 
from dual;

select date(now()), time(now()) from dual;
select ADDDATE(now(), 10), SUBDATE(now(), 10)  from dual;
select ADDTIME(CURTIME(), 10), SUBTIME(CURTIME(), 10)  from dual;


select DATEDIFF(now(), '2022-01-01'), TIMEDIFF(CURTIME(), '00:00:00')  from dual;
select last_day(now()) from dual;





-- 변환
-- to_char to_date
-- %Y -> YYYY
-- %y -> YY
-- %m -> MM
-- %d -> DD
-- %i -> minute
select str_to_date('20220517', '%Y%m%d') from dual;
select date_format(now(), '%Y. %m. %d. %H:%i:%s') from dual;
