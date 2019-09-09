package kr.co.itcen.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {
	public static void main(String[] args) {
		insert("경영지원팀1");
		insert("경영지원팀2");
		insert("경영지원팀3");
	}
	
	public static Boolean insert(String name) {
		Boolean result = false;
		
		Connection connection = null;
		Statement stmt = null;

		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			// 2. 연결하기
			String url = "jdbc:mariadb://192.168.1.84:3306/webdb?characterEncoding=utf8";
			// url, db계정, db비밀번호
			connection = DriverManager.getConnection(url, "webdb", "webdb");
			
			// 3. Statment 객체 생성(받아오기)
			stmt = connection.createStatement();
			
			// 4. SQL문 실행
			String sql = "insert into department values(null, '" + name + "')";
			int count = stmt.executeUpdate(sql);
			
			result = (count == 1); 
			
		} catch (ClassNotFoundException e) {
			System.out.println("Fail to Loading Driver:" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
