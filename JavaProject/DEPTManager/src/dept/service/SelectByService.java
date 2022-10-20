package dept.service;

import java.sql.Connection;
import java.sql.SQLException;

import dept.dao.Dao;
import dept.dao.MysqlDao;
import dept.domain.Dept;
import dept.util.ConnectionProvider;

public class SelectByService {

	//Dao dao = new MysqlDao();

	Dao dao;

	public SelectByService(Dao dao) {
		this.dao = dao;
	}
	
	public Dept selectByDeptno(int deptno) {

		Dept dept = null;
		Connection conn = null;

		try {

			try {
				
				conn = ConnectionProvider.getConnection();
				dept = dao.selectByDeptno(conn, deptno);

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return dept;

	}

}
