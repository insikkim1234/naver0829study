package data;

public class ShopDto {
	private String sangpum;
	private String photo;
	private int price;
	private String color;
	
	//src main java에 data 패키지 만들고 ShopDtojava클래스만들기
	//genearte consturctor using field disselectall
	public ShopDto() {
		super();
	}
	//generate consructor using field selectall
	public ShopDto(String sangpum, String photo, int price, String color) {
		super();
		this.sangpum = sangpum;
		this.photo = photo;
		this.price = price;
		this.color = color;
	}
	///generate getter and setter selectall
	public String getSangpum() {
		return sangpum;
	}
	public void setSangpum(String sangpum) {
		this.sangpum = sangpum;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
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
