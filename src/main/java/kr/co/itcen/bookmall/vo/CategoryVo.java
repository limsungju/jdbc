package kr.co.itcen.bookmall.vo;

public class CategoryVo {
	private Long no;
	private String genre;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", genre=" + genre + "]";
	}

}
