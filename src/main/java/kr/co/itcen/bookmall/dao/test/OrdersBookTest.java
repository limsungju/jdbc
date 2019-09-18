package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.dao.OrdersBookDao;
import kr.co.itcen.bookmall.vo.BookVo;
import kr.co.itcen.bookmall.vo.OrdersBookVo;

public class OrdersBookTest {
	public static void main(String[] args) {
		insertTest();
		selectTest();
		// deleteAllTest();
	}

	private static void deleteAllTest() {
		new CartDao().delete();
	}

	private static void insertTest() {
		OrdersBookDao ordersBookDao = new OrdersBookDao();

		BookDao bookDao = new BookDao();

		List<BookVo> bookList = bookDao.getList();

		if (bookList.size() == 0) {
			System.out.println("도서리스트가 없습니다.");
			return;
		}

		OrdersBookVo ordersBookVo = new OrdersBookVo();
		ordersBookVo.setCount(5);
		ordersBookVo.setBookNo(bookList.get(0).getNo());

		ordersBookDao.insert(ordersBookVo);
		
		OrdersBookVo ordersBookVo1 = new OrdersBookVo();
		ordersBookVo1.setCount(10);
		ordersBookVo1.setBookNo(bookList.get(1).getNo());

		ordersBookDao.insert(ordersBookVo1);
	}

	private static void selectTest() {
		System.out.println("-----상품 리스트-----");
		OrdersBookDao ordersBookDao = new OrdersBookDao();
		List ordersBookList = ordersBookDao.getList();
		for (int i = 0; i < ordersBookList.size(); i++) {
			System.out.println(ordersBookList.get(i));
		}
	}
}
