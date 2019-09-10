package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.UserVo;


public class UserDao {
	public Boolean insert(UserVo vo) {
		Boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			connection = getConnection();
			
			String sql = "insert into user values(null, ?, ?, ?, password(?))";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getPasswd());
			int count = pstmt.executeUpdate();
			
			result = (count == 1); 
			
			stmt = connection.createStatement();
			// mysql에만 있는 함수
			rs = stmt.executeQuery("select last_insert_id()");
			if(rs.next()) {
				Long no = rs.getLong(1);
				vo.setNo(no);
			}
			
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(pstmt != null) {
					pstmt.close();
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

	public List<UserVo> getList() {
		List<UserVo> result = new ArrayList<UserVo>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = getConnection();
			
			String sql = "select no, name, phone, email, passwd from user order by no asc";
			pstmt = connection.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				String passwd = rs.getString(5);
				
				UserVo vo = new UserVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setPhone(phone);
				vo.setEmail(email);
				vo.setPasswd(passwd);
				
				result.add(vo);
			}
						
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
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
	
	public void delete() {
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = getConnection();
			
			String sql = "delete from user";
			pstmt = connection.prepareStatement(sql);
						
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			String url = "jdbc:mariadb://192.168.1.84:3306/bookmall?characterEncoding=utf8";
			connection = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch(ClassNotFoundException e) {
			System.out.println("Fail to Loading Driver:" + e);
		} 
		return connection;
	}
}
