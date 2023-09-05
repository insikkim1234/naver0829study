package bit701.day0905;

public class P137 {

	public static void main(String[] args) {
		//55555
		/*for(int i=1;i<=5;i++)
		{
			for(int j=1;j<=5;j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}*/
		
		
		//12345
		/*for(int i=1;i<=5;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}*/
		
		
		
		//54321
		/*for(int i=1;i<=5;i++)
		{
			for(int j=i;j<=5;j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}*/
		
		//1****
		//*2***
		//**3**
		//***4*
		//****5
		
		for(int i=1;i<=5;i++)
		{
			for(int j=1;j<=5;j++)
			{
				if(i==j)
				{
					System.out.print(i);
				}
				else
					System.out.print("*");
			}
			System.out.println();
		}
		


	}

}
