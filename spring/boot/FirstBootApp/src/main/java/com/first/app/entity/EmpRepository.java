package com.first.app.entity;

import com.first.app.domain.ListItemDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpRepository extends JpaRepository<Emp, Integer> {

    @Query(value = "select e from Emp e join fetch e.dept") // Emp = Entity 이름
    List<Emp> findEmpDept();

    @Query("select e from Emp e, Dept d where e.dept=d")
    List<Emp> findEmpWithDept();


    // 게시물 리스트 => 제목 [12] <= 댓글의 개수
    // 게시물[dept] , count 사원 수 -> 배열로 묶어서 반환
    // group by, outer join(조건 불만족시 결과에서 배제) 사용
    @Query(value = "select d, count(e)" +
            "from Emp e " +
            "left outer join Dept d " +
            "on e.dept=d " +
            "group by d"
            , countQuery = "select count(d) from Dept d")
    Page<Object[]> listWithCnt(Pageable pageable);


    // Entity 아닌 DTO 사용하여 응답 처리 가능!
    // 응답처리하고 싶은 객체롤 select 영역에 new~ 형태로 넣어줌
    // 애초에 원하는 형태로 객체를 만들어줄 수 있음(원하는 data만 넣어서 보여주기)
    @Query("select " +
            "new com.first.app.domain.ListItemDTO(e.empno, e.ename, e.job, d.dname, d.loc)" +
            "from Emp e, Dept d " +
            "where e.dept=d")
    List<ListItemDTO> findListItem();
}
