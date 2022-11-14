package service;



import dao.TodoDao;
import domain.TodoDTO;
import lombok.Cleanup;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoService implements ITodo {


    // List
    public List<TodoDTO> getAllList() throws SQLException {

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        List<TodoDTO> list = dao.selectAll(conn);

        return list;
    }


    // register
    public int registToList(TodoDTO todo) throws SQLException {

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        int result = dao.insertTodoList(conn, todo);

        return result;
    }


    // modify
    public int updateTodo(TodoDTO todo) throws SQLException {

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        int result = dao.updateTodo(conn, todo);

        return result;
    }


    // remove
    public int removeTodo(long tno) throws SQLException {

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        int result = dao.deleteTodoList(conn, tno);

        return  result;
    }


    // read
    public TodoDTO getTodoByTno(long tno) throws  SQLException {

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        TodoDTO todo = dao.getTodoByTno(conn, tno);

        return todo;

    }

}
