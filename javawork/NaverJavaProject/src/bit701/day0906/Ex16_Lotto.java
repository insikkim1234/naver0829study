package bit701.day0906;

import java.util.Random;

public class Ex16_Lotto {

	public static void main(String[] args) {
		/*
		 * 6개 할당된lotto 배열변수에 1~45사이의 난수를 발생하는데
		 * 중복된 경우 다시발생 
		 * 이후 오름차순 정렬로 출력하시오
		 * 
		 */
		Random r=new Random();
		int []lotto=new int[6];
		
		//중복되지 않은 난수 	발생
		for(int i=0;i<lotto.length;i++)
		{
			lotto[i]=(int)(Math.random()*45)+1;
			
			for(int j=0;j<i;j++)
			{
				if(lotto[i]==lotto[j])
				{
					i--;
					break;//현재 반복문을 빠져나간뒤 i++로 이동
				}
			}
		}
		//정렬
		for(int i=0;i<lotto.length-1;i++)
		{
			for(int j=i+1;j<lotto.length;j++)
			{
				if(lotto[i]>lotto[j])
				{
					int temp=lotto[i];
					lotto[i]=lotto[j];
					lotto[j]=temp;
				}
			}
		}
		
		//출력
		for(int n:lotto)
		{
			System.out.printf("%4d",n);
		}
		
		
	}

}
