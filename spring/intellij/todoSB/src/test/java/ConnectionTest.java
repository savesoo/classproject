
import com.mytodolist.springtodo.domain.TodoDTO;
import com.mytodolist.springtodo.domain.UserDTO;
import com.mytodolist.springtodo.formatter.LocalDateFormatter;
import com.mytodolist.springtodo.mapper.TodoListMapper;
import com.mytodolist.springtodo.mapper.UserMapper;
import com.mytodolist.springtodo.service.SingUpService;
import com.mytodolist.springtodo.service.TodoService;
import com.mytodolist.springtodo.service.UserLoginService;
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
import java.time.LocalDate;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spt/root-context.xml")
public class ConnectionTest {

    @Autowired(required = false)
    private DataSource dataSource;

    @Autowired(required = false)
    private TodoListMapper mapper;
    @Autowired(required = false)
    private UserMapper userMapper;


    @Autowired(required = false)
    private TodoService service;

    @Autowired(required = false)
    private UserLoginService userService;

    @Autowired(required = false)
    private SingUpService signService;


    @Test
    public void getUUIDTest() throws SQLException {
        log.info(userService.selectUUID("ddd"));
    }

    @Test
    public void deleteTodoTest(){

        TodoDTO todo = TodoDTO.builder().tno(11).userID("test").build();

        int result = mapper.deleteTodoList(todo);
        Assertions.assertEquals(1, result);

    }


    @Test
    public void updateTodoTest(){

        TodoDTO todo = TodoDTO.builder()
                .tno(11)
                .todo("JCS")
                .dueDate(LocalDate.parse("2022-12-25"))
                .finished(false)
                .userID("test")
                .build();

        int result = mapper.updateTodo(todo);

        Assertions.assertEquals(1, result);

    }


    @Test
    public void insertTodoTest(){
        TodoDTO todo = TodoDTO.builder()
                .todo("x-mas")
                .dueDate(LocalDate.now())
                .finished(true)
                .userID("test")
                .build();

        int result = mapper.insertTodoList(todo);

        Assertions.assertEquals(1, result);
    }


    @Test
    public void selectByTnoTest(){

        TodoDTO todo = TodoDTO.builder().tno(4).userID("test").build();
        log.info(mapper.getTodoByTno(todo));
        Assertions.assertNotNull(todo);

    }

    @Test
    public void insertUserTest(){
        UserDTO user = UserDTO.builder()
                .userID("tea")
                .userPW("1234")
                .userName("black")
                .build();

        int result = userMapper.insertUser(user);

        Assertions.assertEquals(1, result);
    }


    @Test
    public void getUser() throws SQLException {
        UserDTO user = UserDTO.builder().userID("test").userPW("test11").build();

        log.info(userMapper.selectCount());

        log.info(userService.loginByIDandPW(user.getUserID(), user.getUserPW()));
    }

    @Test
    public void selectAllTest(){

        log.info(mapper.selectAll("test"));
    }

    @Test
    public void getConnectionTest() throws SQLException {

        Connection connection = dataSource.getConnection();

        log.error("connection");

        Assertions.assertNotNull(connection);

        connection.close();

    }

    @Test
    public void serviceTest() {
        log.info(service.getAllList("test"));
    }

    @Test
    public void Test() {
        log.info("test");
    }
}
