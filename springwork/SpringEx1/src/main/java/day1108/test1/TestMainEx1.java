package day1108.test1;

public class TestMainEx1 {

	public static void main(String[] args) {
		//(1)dto 불러오기
		TestDto dto=new TestDto();
		//(2)setter을 이용해서 이름 주소 나이 저장
		dto.setName("이상아");
		dto.setAddr("강남");
		dto.setAge(23);
		
		//(3)getter을 이용해서 출력
		System.out.println("이름:"+dto.getName());
		System.out.println("주소:"+dto.getAddr());
		System.out.println("나이:"+dto.getAge());
		
		//(4)toString 이용하여 출력
		System.out.println("toString()호출");
		System.out.println(dto);
		
		TestDto dto2=new TestDto("강호동","제주도",45);
		System.out.println(dto2);
		
		TestDto dto3=new TestDto("윤현수");
		System.out.println(dto3);
	}

}
