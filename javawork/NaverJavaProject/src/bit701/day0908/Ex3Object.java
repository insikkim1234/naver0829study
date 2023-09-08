package bit701.day0908;

public class Ex3Object {

	public static void main(String[] args) {
		//객체 배열을 ㅣ용해서 데이타를 출력해보자
		Bitcamp []bit=new Bitcamp[3];//3개의 데이터가 들어갈 변수로 할당(초기NULL)
		//배열갯수만큼 Bitcamp객체 생ㅇ성
		for(int i=0;i<bit.length;i++)
		{
			bit[i]=new Bitcamp();
		}
		//0번 데이터
		bit[0].name="캔디";
		bit[0].address="대구";

		//1번 데이터
		bit[1].name="안쏘니";
		bit[1].address="서울";

		//2번 데이터
		bit[2].name="테리우스";
		bit[2].address="부산";
		
		//출력
		for(int i=0;i<bit.length;i++)
		{
			System.out.println("학생정보 "+(i+1)+"**");
			System.out.println("이름 "+bit[i].name);
			System.out.println("주소 "+bit[i].address);
			System.out.println("스터디반 "+Bitcamp.STUDYNAME);
			System.out.println();
		
		}
		//출력2
		for(Bitcamp b:bit)
		{
			System.out.println("학생정보 ");
			System.out.println("이름 "+b.name);
			System.out.println("주소 "+b.address);
			System.out.println("스터디반 "+Bitcamp.STUDYNAME);
			System.out.println();
		}
			

	}

}
