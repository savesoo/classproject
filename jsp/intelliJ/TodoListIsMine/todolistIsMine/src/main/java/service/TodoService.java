package service;



import dao.TodoDao;
import domain.TodoDTO;

import java.util.ArrayList;
import java.util.List;

public class TodoService {

    public List<TodoDTO> getTodoList() {

        List<TodoDTO> list = new ArrayList<>();

        TodoDao todo = new TodoDao();

        return list;
    }

}
