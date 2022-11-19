package com.mytodolist.springtodo.service;

import com.mytodolist.springtodo.dao.TodoDao;
import com.mytodolist.springtodo.dao.UserDao;

public interface ITodo {

    TodoDao dao = new TodoDao();

    UserDao ud = new UserDao();


}
