import com.firstcoding.fisrtapp.dept.Dept;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// 원하는 테스트는 모두 이곳에서 진행해보기
public class DeptTest {

    @Test
    public void DeptTest(){

        Dept dept = new Dept(10, "test", "LON");

        //dept.setDeptno(60);

        System.out.println(dept);

        Assertions.assertEquals(10, dept.getDeptno(), "부서 번호 테스트");


    }


}
