package com.first.app;

import com.first.app.domain.ListItemDTO;
import com.first.app.entity.Dept;
import com.first.app.entity.Emp;
import com.first.app.entity.EmpRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@Log4j2
public class EmpRepositoryTest {

    @Autowired
    private EmpRepository empRepository;

    @Test
    public void empRepositorySaveTest(){

        Dept dept = Dept.builder().deptno(30).build();

        Emp emp = empRepository.save(Emp.builder().
                        ename("RYU")
                        .job("MANAGER")
                        .mgr(null)
                        .hiredate(LocalDate.now())
                        .sal(4000d)
                        .comm(null)
                        /*.deptno(30)*/
                        .dept(dept)
                        .build());

        log.info("emp entity insert >>>>>>" + emp);
    };

    @Test
    public void empListTest(){

        List<Emp> list = empRepository.findAll();

        log.info("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

        for(Emp emp : list){
            log.info(emp);
        }
    }

    @Test
    public void empPagingTest(){

        Pageable pageable = PageRequest.of(3, 5, Sort.by("hiredate").descending());
        // PageRequest.of(int page요청할 페이지, int size페이지 개수)
        Page<Emp> result = empRepository.findAll(pageable); // page 타입 반환(안에 List 존재)

        log.info("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        log.info("result >>>>>>> 조회항목 리스트 " + result.getContent());
        log.info("result >>>>>>> 전체 게시물의 개수 " + result.getTotalElements());
        log.info("result >>>>>>> 전체 페이지 개수 " + result.getTotalPages());
        log.info("result >>>>>>> 현재 요청 페이지 번호 " + result.getNumber());
        log.info("result >>>>>>> 페이지당 표현할 항목 개수 " + result.getSize()); // ex) 페이지당 5개
        log.info("result >>>>>>> 현재 페이지에 출력된 항목의 개수 " + result.getNumberOfElements());

    }

    @Test
    public void empJoinDeptTest(){

        List<Emp> list1 = empRepository.findEmpDept();
        for(Emp emp : list1){
            log.info("join : " + emp);
        }

        log.info("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

        List<Emp> list2 = empRepository.findEmpWithDept();
        for(Emp emp : list2){
            log.info("join : " + emp);
        }
    }

    @Test
    public void deptWithCntTest(){

        // 출력되는 건 Dept -> 3개씩 출력
        Page<Object[]> result = empRepository.listWithCnt(PageRequest.of(0, 3));

        log.info("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        log.info("result >>>>>>> 조회항목 리스트 " + result.getContent());
        log.info("result >>>>>>> 전체 게시물의 개수 " + result.getTotalElements());
        log.info("result >>>>>>> 전체 페이지 개수 " + result.getTotalPages());
        log.info("result >>>>>>> 현재 요청 페이지 번호 " + result.getNumber());
        log.info("result >>>>>>> 페이지당 표현할 항목 개수 " + result.getSize()); // ex) 페이지당 5개
        log.info("result >>>>>>> 현재 페이지에 출력된 항목의 개수 " + result.getNumberOfElements());

        for(Object[] arr : result.getContent()){
            log.info(Arrays.toString(arr)); // 배열 안의 요소가 배열
        }
    }


    @Test
    public void dtoListTest(){

        List<ListItemDTO> list = empRepository.findListItem();

        for(ListItemDTO itemDTO : list){
            log.info(itemDTO);
        }

    }


}
