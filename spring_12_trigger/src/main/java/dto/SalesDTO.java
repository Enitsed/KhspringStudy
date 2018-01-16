package dto;

import java.util.Date;

//판매
public class SalesDTO {
	private int num;
	private String code;
	private Date sadate;
	private int sacnt;
	private int saprice;

	public SalesDTO() {

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

	public Date getSadate() {
		return sadate;
	}

	public void setSadate(Date sadate) {
		this.sadate = sadate;
	}

	public int getSacnt() {
		return sacnt;
	}

	public void setSacnt(int sacnt) {
		this.sacnt = sacnt;
	}

	public int getSaprice() {
		return saprice;
	}

	public void setSaprice(int saprice) {
		this.saprice = saprice;
	}

}// end class
