package kr.co.itcen.hr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

	public List<EmployeeVo> getList(String keyword) {
		List<EmployeeVo> result = new ArrayList<EmployeeVo>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mariadb://192.168.1.84:3306/employees?characterEncoding=utf8";
			// url, db계정, db비밀번호
			connection = DriverManager.getConnection(url, "hr", "hr");

			// 3. Statment 객체 생성(받아오기)
			String sql = "  select emp_no, first_name, last_name, gender, date_format(hire_date, '%Y년 %m월 %d일')" +
					"         from employees" +
					"        where first_name like ?" +
					"          and last_name like ?" +
					"     order by hire_date desc";
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");

			// 4. SQL문 실행
			rs = pstmt.executeQuery();

			// 5. 결과 가져오기
			while (rs.next()) {
				Long no = rs.getLong(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String gender = rs.getString(4);
				String hireDate = rs.getString(5);

				EmployeeVo vo = new EmployeeVo();
				vo.setNo(no);
				vo.setFirstName(firstName);
				vo.setLastName(lastName);
				vo.setGender(gender);
				vo.setHireDate(hireDate);

				result.add(vo);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Fail to Loading Driver:" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public List<EmployeeVo> getList() {
		List<EmployeeVo> result = new ArrayList<EmployeeVo>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mariadb://192.168.1.84:3306/employees?characterEncoding=utf8";
			// url, db계정, db비밀번호
			connection = DriverManager.getConnection(url, "hr", "hr");

			// 3. Statment 객체 생성(받아오기)
			String sql = "  select emp_no, first_name, last_name, gender, date_format(hire_date, '%Y년 %m월 %d일')" +
					"         from employees" +
					"     order by hire_date desc";
			pstmt = connection.prepareStatement(sql);

			// 4. SQL문 실행
			rs = pstmt.executeQuery();

			// 5. 결과 가져오기
			while (rs.next()) {
				Long no = rs.getLong(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String gender = rs.getString(4);
				String hireDate = rs.getString(5);

				EmployeeVo vo = new EmployeeVo();
				vo.setNo(no);
				vo.setFirstName(firstName);
				vo.setLastName(lastName);
				vo.setGender(gender);
				vo.setHireDate(hireDate);

				result.add(vo);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Fail to Loading Driver:" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

}
