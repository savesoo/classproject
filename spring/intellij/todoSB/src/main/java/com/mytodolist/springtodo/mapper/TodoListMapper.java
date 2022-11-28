package com.mytodolist.springtodo.mapper;

import com.mytodolist.springtodo.domain.TodoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TodoListMapper {

    // todoList 전체 출력
    @Select("select * from todo_list")
    List<TodoDTO> selectAll(String userID);

    // todoList에 추가
    int insertTodoList(TodoDTO todo);

    // todoList 수정
    int updateTodo(TodoDTO todo);

    // todoList에서 삭제
    int deleteTodoList(TodoDTO todo);

    // tno값으로 조회
    TodoDTO getTodoByTno(TodoDTO todo);



}
