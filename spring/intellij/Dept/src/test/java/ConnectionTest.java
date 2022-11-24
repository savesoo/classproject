import com.app.manager.domain.DeptDTO;
import com.app.manager.mapper.DeptMapper;
import com.app.manager.mapper.TimeMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Autowired(required = false)
    private TimeMapper timeMapper;

    @Autowired(required = false)
    private DeptMapper deptMapper;

    @Test
    public void getDeptListTest(){
        //log.info("List >>>>>>> " + deptMapper.selectAll()); // sql 실행
        DeptDTO deptDTO = new DeptDTO(50, "DEV", "SEOUL");
        //log.info("Dept insert >>>>>>> " + deptMapper.insertDept(deptDTO));
        //log.info("Dept 정보 >>>>>>> " + deptMapper.selectBydeptno(10));
        //log.info("Dept 수정 >>>>>>> " + deptMapper.updateDept(deptDTO));
        log.info("Dept 삭제 >>>>>>> " + deptMapper.deletBydeptno(50));
    }

    @Test
    public void getTimeTest(){
        log.info(timeMapper.getTime()); // sql 실행
    }

    @Test
    public void connectionTest() throws SQLException {

        Connection connection = dataSource.getConnection();

        log.info(connection);

        Assertions.assertNotNull(connection);

        connection.close();

    }
}
