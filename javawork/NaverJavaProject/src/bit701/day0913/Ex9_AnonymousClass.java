package bit701.day0913;
//익명 내부 클래스(Annonymous Inner Class)

abstract class AnonySuper
{
	abstract public void show();
	abstract public void play();
}

interface BitInter
{
	public void study();
	public void draw();
}


class AnonyClass
{
	//익명 내부 클래스 형태
	//탐색기에서 보면 외부클래스면$1이런식으로 클래스 이름이 만들어져 있다
	AnonySuper anony=new AnonySuper()/*이거 치는 도중에 컨스 엔터 치면 오버라이드 함수 나옴*/ {
		
		@Override
		public void show() {
			// TODO Auto-generated method stub
			System.out.println("오늘은 ntime 날");
		}
		
		@Override
		public void play() {
			// TODO Auto-generated method stub
			System.out.println("노는날 아님");
		}
	};
	
	//interface BitInter 을 익명 내부 클래스 형태로 구현하여 메인에서 호출해보세요
	BitInter bit=new BitInter()/* 여기까지 치고 컨스엔터*/ {
		
		@Override
		public void study() {
			// TODO Auto-generated method stub
			System.out.println("자바 공부를 하고있어요");
		}
		
		@Override
		public void draw() {
			// TODO Auto-generated method stub
			System.out.println("그림도 그리고있어요");
			
		}
	};
}
public class Ex9_AnonymousClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnonyClass a=new AnonyClass();
		a.anony.show();
		a.anony.play();
		
		a.bit.study();
		a.bit.draw();

	}

}
