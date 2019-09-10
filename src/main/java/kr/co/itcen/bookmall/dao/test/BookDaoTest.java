package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.dao.CategoryDao;
import kr.co.itcen.bookmall.vo.BookVo;
import kr.co.itcen.bookmall.vo.CategoryVo;

public class BookDaoTest {
	public static void main(String[] args) {
		insertTest();
		selectTest();
		//deleteAllTest();
	}
	
	private static void deleteAllTest() {
		new BookDao().delete();
	}
	
	private static void insertTest() {
		//System.out.println("-----insert test-----");
		BookDao dao = new BookDao();
		
		CategoryDao categoryDao = new CategoryDao();
		
		List<CategoryVo> list = categoryDao.getList();
		
		if(list.size() == 0) {
			System.out.println("카테고리가 없습니다.");
			return;
		}
		
		String gr = list.get(0).getGenre();
		
		BookVo vo1 = new BookVo();
		vo1.setTitle("자바 프로그래밍 기초");
		vo1.setPrice(22000);
		vo1.setCategoryNo(list.get(0).getNo());
		dao.insert(vo1);
		//System.out.println(vo1);
		
		BookVo vo2 = new BookVo();
		vo2.setTitle("웹 서비스 기초");
		vo2.setPrice(32000);
		vo2.setCategoryNo(list.get(1).getNo());
		dao.insert(vo2);
		//System.out.println(vo2);
		
		BookVo vo3 = new BookVo();
		vo3.setTitle("자바의 정석");
		vo3.setPrice(21000);
		vo3.setCategoryNo(list.get(2).getNo());
		dao.insert(vo3);
		//System.out.println(vo3);
		
	}
	
	private static void selectTest() {
		System.out.println("-----상품 리스트-----");
		BookDao dao = new BookDao();
		List<BookVo> list = dao.getList();
		for(BookVo vo:list) {
			System.out.println(vo);
		}
	}
}
