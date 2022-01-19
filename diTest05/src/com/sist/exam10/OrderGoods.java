package com.sist.exam10;

public class OrderGoods {
	private String customer;
	private GoodsVO goodsVO;
	
	public OrderGoods(String customer, GoodsVO goodsVO) {
		super();
		this.customer = customer;
		this.goodsVO = goodsVO;
	}
	
	public void order() {
		System.out.println(customer + "고객이 구매한 상품의 정보는 다음과 같습니다.");
		System.out.println(goodsVO);
	}
}
