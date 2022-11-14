package service;

import dao.TodoDao;
import dao.UserDao;

public interface ITodo {

    TodoDao dao = new TodoDao();

    UserDao ud = new UserDao();


}
