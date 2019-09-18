package kr.co.itcen.bookmall.vo;

public class OrdersBookVo {
	private Long no;
	private Integer count;
	private Long bookNo;
	private Long ordersNo;
	private String title;
	private int price;
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

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

	public Long getBookNo() {
		return bookNo;
	}

	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}

	public Long getOrdersNo() {
		return ordersNo;
	}

	public void setOrdersNo(Long ordersNo) {
		this.ordersNo = ordersNo;
	}

	@Override
	public String toString() {
		return "OrdersBookVo [no=" + no + ", count=" + count + ", bookNo=" + bookNo + ", ordersNo=" + ordersNo
				+ ", title=" + title + ", price=" + price + "]";
	}

	

}
