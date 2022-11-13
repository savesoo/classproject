package dao;


import domain.TodoDTO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoDao {

    // todoList 전체 출력
    public List<TodoDTO> selectAll(Connection conn) throws SQLException {

        String sql = "select * from todo_list";

        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        List<TodoDTO> list = null;

        list = new ArrayList<>();

        while (rs.next()){
            list.add(new TodoDTO(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getBoolean(4)));
        }

        return list;

    }


    // todoList에 추가
    public int insertTodoList(Connection conn, TodoDTO todo) throws SQLException {

        int result = 0;

        String sql = "insert into todo_list(tno, todo, dueDate, finished) values(?, ?, ?, ?) ";

        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setLong(1, todo.getTno());
        pstmt.setString(2, todo.getTodo());
        pstmt.setString(3, todo.getDueDate());
        pstmt.setBoolean(4, todo.isFinished());

        result = pstmt.executeUpdate();

        return  result;

    }


    // todoList 수정
    public int updateByTno(Connection conn, TodoDTO todo) throws SQLException{

        int result = 0;

        String sql = "update todo_list set todo=?, dueDate=?, finished=? where tno=?";

        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, todo.getTodo());
        pstmt.setString(2, todo.getDueDate());
        pstmt.setBoolean(3, todo.isFinished());
        pstmt.setLong(4, todo.getTno());

        result = pstmt.executeUpdate();

        return result;

    }


    // todoList에서 삭제
    public int deleteTodoList(Connection conn, TodoDTO todo) throws SQLException{

        int result = 0;

        String sql = "delete from todo_list where tno=?";

        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setLong(1,todo.getTno());

        result = pstmt.executeUpdate();

        return  result;

    }


}
