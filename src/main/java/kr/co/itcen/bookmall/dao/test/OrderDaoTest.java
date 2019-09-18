package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.dao.OrderDao;
import kr.co.itcen.bookmall.dao.OrdersBookDao;
import kr.co.itcen.bookmall.dao.UserDao;
import kr.co.itcen.bookmall.vo.BookVo;
import kr.co.itcen.bookmall.vo.OrdersBookVo;
import kr.co.itcen.bookmall.vo.OrdersVo;
import kr.co.itcen.bookmall.vo.UserVo;

public class OrderDaoTest {
	public static void main(String[] args) {
		insertTest();
		selectTest();
		// deleteAllTest();
	}

	private static void deleteAllTest() {
		new CartDao().delete();
	}

	private static void insertTest() {
		UserDao userDao = new UserDao();
		BookDao bookDao = new BookDao();
		OrdersBookDao orderBookDao = new OrdersBookDao();
		OrderDao orderDao = new OrderDao();

		List<UserVo> userList = userDao.getList();
		List<BookVo> bookList = bookDao.getList();
		List<OrdersBookVo> ordersBookList = orderBookDao.getList();

		if (userList.size() == 0) {
			System.out.println("고객이 없습니다.");
			return;
		}
		
		if (ordersBookList.size() == 0) {
			System.out.println("주문 도서 목록이 없습니다.");
			return;
		}
		
		int a = bookList.get(0).getPrice();
		int b = ordersBookList.get(0).getCount();
		
		OrdersVo orderVo = new OrdersVo();
		orderVo.setPrice(a*b);
		orderVo.setAddress("서울시 어딘가");
		orderVo.setUserNo(userList.get(0).getNo());

		orderDao.insert(orderVo);
		// System.out.println(cartVo);

	}

	private static void selectTest() {
		System.out.println("-----주문 리스트-----");
		OrderDao orderDao = new OrderDao();
		List orderList = orderDao.getList();
		for (int i = 0; i < orderList.size(); i++) {
			System.out.println(orderList.get(i));
		}
	}
}
