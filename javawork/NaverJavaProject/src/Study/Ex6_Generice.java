package Study;
class Box<T>
{
	private T content;
	
	public void setContent(T content)
	{
		this.content=content;
	}
	
	public T getContent()
	{
		return content;
	}
}

public class Ex6_Generice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box<String> box1=new Box<String>();
		box1.setContent("hello 반가워요");
		System.out.println(box1.getContent());
		
		Box<Double> box2=new Box();
		box2.setContent(23.8);
		System.out.println(box2.getContent());

	}

}
