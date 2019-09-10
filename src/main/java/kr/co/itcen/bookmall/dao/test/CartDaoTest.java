package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.dao.UserDao;
import kr.co.itcen.bookmall.vo.BookVo;
import kr.co.itcen.bookmall.vo.CartVo;
import kr.co.itcen.bookmall.vo.UserVo;

public class CartDaoTest {
	public static void main(String[] args) {
		insertTest();
		selectTest();
		//deleteAllTest();
	}
	
	private static void deleteAllTest() {
		new CartDao().delete();
	}
	
	private static void insertTest() {
		//System.out.println("-----insert test-----");
		CartDao cartDao = new CartDao();
		
		UserDao userDao = new UserDao();
		BookDao bookDao = new BookDao();
		
		List<UserVo> userList = userDao.getList();
		List<BookVo> bookList = bookDao.getList();
		
		if(userList.size() == 0) {
			System.out.println("고객이 없습니다.");
			return;
		}
		if(bookList.size() == 0) {
			System.out.println("도서리스트가 없습니다.");
			return;
		}
		
		
		CartVo cartVo = new CartVo();
		cartVo.setCount(5);
		cartVo.setUserNo(userList.get(0).getNo());
		cartVo.setBookNo(bookList.get(0).getNo());
		
		cartDao.insert(cartVo);
		//System.out.println(cartVo);
		
	}
	
	private static void selectTest() {
		System.out.println("-----상품 리스트-----");
		CartDao cartDao = new CartDao();
		List cartList = cartDao.getList();
		for(int i = 0; i < cartList.size(); i++) {
			System.out.println(cartList.get(i));
		}
	}
}
