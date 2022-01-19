package com.sist.exam08;

public class GoodsVO {
	private int no;
	private String name;
	private int price;
	private int qty;
	private String fname;
	
	public GoodsVO(int no, String name, int price, int qty, String fname) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.qty = qty;
		this.fname = fname;
	}

	@Override
	public String toString() {
		return "GoodsVO [no=" + no + ", name=" + name + ", price=" + price + ", qty=" + qty + ", fname=" + fname + "]";
	}
	
	
}
