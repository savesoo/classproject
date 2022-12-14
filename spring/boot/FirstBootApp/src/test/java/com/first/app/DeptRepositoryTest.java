package com.first.app;

import com.first.app.entitly.Dept;
import com.first.app.entitly.DeptRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
            log.info(dept);

        }
    }

}
