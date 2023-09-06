package bit701.day0906;

import java.util.Scanner;

public class Ex12_ArraySearchName {

	public static void main(String[] args) {
		String []names= {"강호동","유재석","한채영","이효리","이승기","강남길",
							"이민정","이서진","손미나","유미리"};
		/*
		 * 검색할 성은?
		 * 이
		 * 4:이효리
		 * 5:이승기
		 * 7:이민정
		 * 8:이서진
		 * 
		 * 검색할 성은?
		 * 박
		 * 박씨 성을 가진 맴버는 없습니다
		 * 
		 * 검색할 성은?끝
		 * 종료합니다
		 * 
		 * 변수:String searchSung
		 * int count;
		 * boolean bFind;
		 * 
		 * startsWith 이용해서 작성
		 * 
		 * 
		 */
		Scanner sc=new Scanner(System.in);
		
		
		String searchSung="";
		int count=0;
		boolean bFind=true;
		
		
		
		while(true)
		{
			count=0;
			bFind=false;
			System.out.println("검색할 성은?:");
			searchSung=sc.nextLine();
			
			if(searchSung.equals("끝"))
			{
				System.out.println("**종료**");
				break;
			}
			
			for(int i=0;i<names.length;i++)
			{
				if(names[i].startsWith(searchSung))
				{
					bFind=true;
					count++;
					System.out.println(i+1+":"+names[i]);
				}
			}
			
			if(bFind)
				System.out.println("**총"+count+"명**");
			else
				System.out.printf("\"%s\"씨성을 가진 멤버는 없습니다\n",searchSung);
			System.out.println();	
		}
	}

}
