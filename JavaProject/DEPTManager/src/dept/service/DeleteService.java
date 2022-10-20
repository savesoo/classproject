package dept.service;

import java.sql.Connection;
import java.sql.SQLException;

import dept.dao.Dao;
import dept.dao.MysqlDao;
import dept.util.ConnectionProvider;

public class DeleteService {
	
	//Dao dao = new MysqlDao();

	Dao dao;

	public DeleteService(Dao dao) {
		this.dao = dao;
	}
	
	public int delete(int deptno) {
		
		int result = 0;
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			result = dao.delete(conn, deptno);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
		
	}

}
