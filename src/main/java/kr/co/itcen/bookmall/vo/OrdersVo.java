package kr.co.itcen.bookmall.vo;

public class OrdersVo {
	private Long no;
	private Integer price;
	private String address;
	private Long userNo;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

	@Override
	public String toString() {
		return "OrdersVo [no=" + no + ", price=" + price + ", address=" + address + ", userNo=" + userNo + "]";
	}

}
