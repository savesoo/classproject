package com.mytodolist.springtodo.dao;


import com.mytodolist.springtodo.domain.LoginInfo;
import com.mytodolist.springtodo.domain.TodoDTO;
import lombok.Cleanup;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class TodoDao {

    // todoList 전체 출력
    public List<TodoDTO> selectAll(Connection conn, String userID) throws SQLException {

        String sql = "select * from todo_list where userID=?";

        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, userID);

        @Cleanup ResultSet rs = pstmt.executeQuery();

        List<TodoDTO> list = null;

        list = new ArrayList<>();

        while (rs.next()){
            list.add(addRowToList(rs));
        }

        return list;

    }


    // todoList에 추가
    public int insertTodoList(Connection conn, TodoDTO todo, String userID) throws SQLException {

        int result = 0;

        String sql = "insert into todo_list(todo, dueDate, finished, userID) values(?, ?, ?, ?) ";

        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, todo.getTodo());
        pstmt.setString(2, todo.getDueDate());
        pstmt.setBoolean(3, todo.isFinished());
        pstmt.setString(4, userID);

        result = pstmt.executeUpdate();

        return  result;

    }


    // todoList 수정
    public int updateTodo(Connection conn, TodoDTO todo, String userID) throws SQLException{

        int result = 0;

        String sql = "update todo_list set todo=?, dueDate=?, finished=? where tno=? and userID=?";

        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, todo.getTodo());
        pstmt.setString(2, todo.getDueDate());
        pstmt.setBoolean(3, todo.isFinished());
        pstmt.setLong(4, todo.getTno());
        pstmt.setString(5, userID);

        result = pstmt.executeUpdate();

        return result;

    }


    // todoList에서 삭제
    public int deleteTodoList(Connection conn, long tno, String userID) throws SQLException{

        int result = 0;

        String sql = "delete from todo_list where tno=? and userID=?";

        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setLong(1, tno);
        pstmt.setString(2, userID);

        result = pstmt.executeUpdate();

        return  result;

    }

    // 조회 (read)
    public TodoDTO getTodoByTno(Connection conn, long tno, String userID) throws SQLException {

        TodoDTO todo = null;

        String sql = "select * from todo_list where tno=? and userID=?";

        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setLong(1, tno);
        pstmt.setString(2, userID);

        @Cleanup ResultSet rs = pstmt.executeQuery();

        if(rs.next()){
            todo = addRowToList(rs);
        }

        return todo;

    }

    public static TodoDTO addRowToList(ResultSet rs) throws SQLException{
        return new TodoDTO(rs.getLong(1),
                           rs.getString(2),
                           rs.getString(3),
                           rs.getBoolean(4));
    }


}
