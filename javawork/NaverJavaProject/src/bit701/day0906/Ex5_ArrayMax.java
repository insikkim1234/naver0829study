package bit701.day0906;

public class Ex5_ArrayMax {

	public static void main(String[] args) {
		int []data;
		data=new int[] {5,-100,133,89,45,-9,123,58,132};
		System.out.println(data.length);
		
		//최대값 최소값 구하기
		
		int max,min;
		
		//최대값 최소값
		max=data[0];//첫번째 데이터를 저장
		min=data[0];
		for(int i=1;i<data.length;i++)
		{
			if(max<data[i])
			{
				max=data[i];
			}
			if(min>data[i])
			{
				min=data[i];
			}
			
		}
		System.out.println(max);
		System.out.println(min);
		
	
		
		
	}

}
