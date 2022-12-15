package com.first.app;

import com.first.app.entity.Dept;
import com.first.app.entity.DeptRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Log4j2
@SpringBootTest
public class DeptRepositoryTest {

    @Autowired // 구현체를 주입 받기!!!
    private DeptRepository deptRepository;

    @Test
    public void jpaMethodTest(){

        // 전체 리스트 반환 findAll() -> sql 작성 없이 동작함
        List<Dept> list1 = deptRepository.findAll();
        for(Dept dept : list1){
            log.info("list1 : " + dept);
        }

        log.info("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

        // 정렬 기준 설정 -> 결과 가져옴
        Sort sort = Sort.by(Sort.Direction.DESC, "dname"); // 컬럼 이름이 기준
        List<Dept> list2 = deptRepository.findAll(sort);
        for(Dept dept : list2){
            log.info("list2 : " + dept);
        }

        log.info("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

        // 검색
        // findById : Entitly의 ID로 지정해놓은 컬럼
        Optional<Dept> dept1 = deptRepository.findById(10); //Optional : null 값을 처리해주기 위한 class
        Dept deptData = dept1.orElse(null); // null 반환하여 처리. orElseThrow: null일시 throw

        log.info(" Dept >>>>> " + deptData);

        log.info("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

        // findAllById : 여러 개의 데이터로 검색
        List<Integer> nos = Arrays.asList(10, 20, 30, 40);
        List<Dept> list3 = deptRepository.findAllById(nos); // where in 연산자
        for(Dept dept : list3){
            log.info("list3 : " + dept);
        }

        log.info("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

        // insert -> save() 이용
        Dept insertData = Dept.builder().dname("PURCHASE").loc("SEOUL").build();
        log.info("insert 전 데이터 >>>>>     " + insertData); // deptno = null

       // Dept resultData = deptRepository.save(insertData); // save 후 Entity 타입으로 반환
       // log.info("insert 후 데이터 >>>>>     " + resultData); // deptno 적용

        log.info("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");


        // update -> save(S) 이용
        Dept editData = Dept.builder().deptno(401).dname("CS").loc("JEJU").build();
        log.info("update 전 데이터 >>>>>     " + editData);

        Dept editResult = deptRepository.save(editData);
        log.info("update 후 데이터 >>>>>     " + editResult); // 같은 결과

        log.info("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");


        // delete
        //deptRepository.deleteById(402); // 반환 타입 X, but id 없으면 Optional 오류(=not exist!)

        log.info("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

        // 개수 구하기
        long cnt = deptRepository.count(); // long 타입
        log.info( "전체 부서의 수 >>>>>> " + cnt);

        log.info("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");


    }


    @Test
    public void jpqlMethodTest(){

        Dept dept1 = deptRepository.findByDeptno(30);

        log.info(">>>>>>>>>>>>>" + dept1);

        log.info("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

        List<Dept> list1 = deptRepository.findByDnameLikeOrderByLocAsc("%A%");

        for (Dept dept : list1){
            log.info(dept);
        }

        log.info("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

        List<Dept> list2 = deptRepository.findByLocLike("%E%");

        for(Dept dept : list2){
            log.info(dept);
        }

        log.info("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

        List<Dept> list3 = deptRepository.findByDeptnoBetween(100,300);

        for(Dept dept : list3){
            log.info(dept);
        }


    }

}
