package Study;

public class Ex2 {
//	public static void processPlay(SubA sub)
//	{
//		sub.process();
//	}
//	public static void processPlay(SubB sub)
//	{
//		sub.process();
//	}
//	public static void processPlay(SubC sub)
//	{
//		sub.process();
//	}
	
	public static void processPlay(SuperA sub)
	{
		sub.process();
	}

	public static void main(String[] args) {
		processPlay(new SubA());
		processPlay(new SubB());
		processPlay(new SubC());
	

	}

}
