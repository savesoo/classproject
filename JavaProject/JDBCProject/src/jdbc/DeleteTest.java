package jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DeleteTest {

	public static void main(String[] args) {

		// 1. 드라이버 로드(생략 가능)
		try {
			
			// 2. Connection 객체 생성
			String dbUrl = "jdbc:mysql://localhost:3306/project";
			Connection conn = DriverManager.getConnection(dbUrl, "scott", "test1111*");


			// 3. Statement / PreparedStatement
			// Delete
			String sql = "delete from dept where deptno=?"; // 완성된 건 아니지만 구문완성 취급

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 50);
			
			int result = pstmt.executeUpdate();
			
			if(result>0) { // 반환값을 int, 따라서 입력한 값이 반영이 되거나=1 안되거나=0 
				System.out.println("삭제되었습니다.");
			}

			pstmt.close();
			conn.close();

			
			
			
			
			// 4. ResultSet
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
