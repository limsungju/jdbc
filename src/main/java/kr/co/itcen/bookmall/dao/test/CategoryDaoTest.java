package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.CategoryDao;
import kr.co.itcen.bookmall.vo.CategoryVo;


public class CategoryDaoTest {
	public static void main(String[] args) {
		insertTest();
		selectTest();
		//deleteAllTest();
	}
	
	private static void deleteAllTest() {
		new CategoryDao().delete();
	}
	
	private static void insertTest() {
		//System.out.println("-----insert test-----");
		CategoryDao dao = new CategoryDao();
		
		CategoryVo vo1 = new CategoryVo();
		vo1.setGenre("IT서적");
		dao.insert(vo1);
		//System.out.println(vo1);
		
		CategoryVo vo2 = new CategoryVo();
		vo2.setGenre("자기개발");
		dao.insert(vo2);
		//System.out.println(vo2);
		
		CategoryVo vo3 = new CategoryVo();
		vo3.setGenre("웹 서비스");
		dao.insert(vo3);
		//System.out.println(vo3);
		
	}
	
	private static void selectTest() {
		System.out.println("-----카테고리 리스트-----");
		CategoryDao dao = new CategoryDao();
		List<CategoryVo> list = dao.getList();
		for(CategoryVo vo:list) {
			System.out.println(vo);
		}
	}
}
