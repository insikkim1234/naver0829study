package Study;

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
		AnonySuper anony=new AnonySuper() {
			
			@Override
			public void show() {
				// TODO Auto-generated method stub
				System.out.println("오늘은 엔타임날");
				
			}
			
			@Override
			public void play() {
				// TODO Auto-generated method stub
				System.out.println("오늘은 노는날 아님");
				
			}
		};
		
		BitInter bit=new BitInter() {
			
			@Override
			public void study() {
				// TODO Auto-generated method stub
				System.out.println("자바 공부를 하고 있어요");
				
			}
			
			@Override
			public void draw() {
				// TODO Auto-generated method stub
				System.out.println("그림 그리는중");
				
			}
		};
}

public class Ex9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnonyClass a=new AnonyClass();
		a.anony.show();
		a.anony.play();
		
		a.bit.study();
		a.bit.draw();

	}

}
