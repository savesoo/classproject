package com.mytodolist.springtodo.service;

import com.mytodolist.springtodo.domain.LoginInfo;
import com.mytodolist.springtodo.domain.TodoDTO;
import com.mytodolist.springtodo.mapper.TodoListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TodoService {
    @Autowired(required = false)
    private TodoListMapper todoListMapper;

    // List
    public List<TodoDTO> getAllList(String userID){
        return todoListMapper.selectAll(userID);
    }


    // register
    public int registToList(TodoDTO todo, String userID) throws SQLException {

        //HashMap<String, Object> map = new HashMap<String, Object>();
        todo.setUserID(userID);
        return todoListMapper.insertTodoList(todo);
    }


    // modify
    public int updateTodo(TodoDTO todo, String userID) throws SQLException {

        todo.setUserID(userID);
        return todoListMapper.updateTodo(todo);
    }


    // remove
    public int removeTodo(TodoDTO todo) throws SQLException {

        return  todoListMapper.deleteTodoList(todo);
    }


    // read
    public TodoDTO getTodoByTno(TodoDTO todo) throws  SQLException {

        return todoListMapper.getTodoByTno(todo);

    }

}
