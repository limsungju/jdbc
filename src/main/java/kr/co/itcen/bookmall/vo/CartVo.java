package kr.co.itcen.bookmall.vo;

public class CartVo {
	private Long no;
	private Long userNo;
	private String name;
	private String phone;
	private Long bookNo;
	private String title;
	private Integer count;
	private Integer price;

	
	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getBookNo() {
		return bookNo;
	}

	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CartVo [no=" + no + ", userNo=" + userNo + ", name=" + name + ", phone=" + phone + ", bookNo=" + bookNo
				+ ", title=" + title + ", count=" + count + ", price=" + price + "]";
	}

}
