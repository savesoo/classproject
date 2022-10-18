
-- 정렬 후 상위 3개 뽑기
-- limit 인덱스, 개수 = 어느 위치에서 이만큼 출력할 것 = Oracle rownum 개념
select * from emp order by hiredate limit 0, 3; 