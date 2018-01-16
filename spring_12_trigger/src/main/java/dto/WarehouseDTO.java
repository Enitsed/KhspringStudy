package dto;

import java.util.Date;

//입고테이블
public class WarehouseDTO {
	private int num;
	private String code;
	private Date indate;
	private int incnt;
	private int inprice;

	public WarehouseDTO() {

	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getIndate() {
		return indate;
	}

	public void setIndate(Date indate) {
		this.indate = indate;
	}

	public int getIncnt() {
		return incnt;
	}

	public void setIncnt(int incnt) {
		this.incnt = incnt;
	}

	public int getInprice() {
		return inprice;
	}

	public void setInprice(int inprice) {
		this.inprice = inprice;
	}
}
