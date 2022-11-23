package com.mytodolist.springtodo.service;


import com.mytodolist.springtodo.dao.TodoDao;
import com.mytodolist.springtodo.domain.TodoDTO;

import com.mytodolist.springtodo.util.ConnectionUtil;
import lombok.Cleanup;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Service
public class TodoService implements ITodo {

    private final TodoDao dao;

    public TodoService(TodoDao dao) {
        this.dao = dao;
    }

    // List
    public List<TodoDTO> getAllList(String userID) throws SQLException {

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        List<TodoDTO> list = dao.selectAll(conn, userID);

        return list;
    }


    // register
    public int registToList(TodoDTO todo, String userID) throws SQLException {

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        int result = dao.insertTodoList(conn, todo, userID);

        return result;
    }


    // modify
    public int updateTodo(TodoDTO todo, String userID) throws SQLException {

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        int result = dao.updateTodo(conn, todo, userID);

        return result;
    }


    // remove
    public int removeTodo(long tno, String userID) throws SQLException {

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        int result = dao.deleteTodoList(conn, tno, userID);

        return  result;
    }


    // read
    public TodoDTO getTodoByTno(long tno, String userID) throws  SQLException {

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        TodoDTO todo = dao.getTodoByTno(conn, tno, userID);

        return todo;

    }

}
