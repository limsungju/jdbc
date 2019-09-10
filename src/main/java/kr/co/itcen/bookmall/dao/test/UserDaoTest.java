package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.UserDao;
import kr.co.itcen.bookmall.vo.UserVo;


public class UserDaoTest {
	public static void main(String[] args) {
		insertTest();
		selectTest();
		deleteAllTest();
	}
	
	private static void deleteAllTest() {
		new UserDao().delete();
	}
	
	private static void insertTest() {
		//System.out.println("-----insert test-----");
		UserDao dao = new UserDao();
		
		UserVo vo1 = new UserVo();
		vo1.setName("임성주");
		vo1.setPhone("010-9981-5715");
		vo1.setEmail("fullmoon4860@gmail.com");
		vo1.setPasswd("1234");
		dao.insert(vo1);
		//System.out.println(vo1);
		
		UserVo vo2 = new UserVo();
		vo2.setName("이종윤");
		vo2.setPhone("010-5464-1513");
		vo2.setEmail("leejy3653@naver.com");
		vo2.setPasswd("1234");
		dao.insert(vo2);
		//System.out.println(vo2);
		
	}
	
	private static void selectTest() {
		System.out.println("-----회원 리스트-----");
		UserDao dao = new UserDao();
		List<UserVo> list = dao.getList();
		for(UserVo vo:list) {
			System.out.println(vo);
		}
	}
}
