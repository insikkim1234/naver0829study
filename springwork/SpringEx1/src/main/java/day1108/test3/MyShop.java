package day1108.test3;

public class MyShop {
	//(1) ����� ���� ����
	private String sangpum;
	private int price;
	private String color;
	
	
	//(2) ��ǰ�� �����ڷ� ����
	public MyShop(String sangpum) {
		super();
		this.sangpum = sangpum;
	}

	// (3) setter/getter ����
	public String getSangpum() {
		return sangpum;
	}


	public void setSangpum(String sangpum) {
		this.sangpum = sangpum;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	
	
}
