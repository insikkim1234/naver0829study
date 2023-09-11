package bit701.day0911;

import java.util.Scanner;

public class Ex9_SawonInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Sawon []sa=new Sawon[3];
		
		
		//3명의 사원에 대한 정보 입력후 배열 생성
		for(int i=0;i<sa.length;i++)
		{
			
			System.out.println("이름"+i);
			String name=sc.nextLine();
			System.out.println("기본급"+i);
			int gibon=Integer.parseInt(sc.nextLine());
			System.out.println("수당"+i);
			int sudang=Integer.parseInt(sc.nextLine());
			System.out.println("가족수"+i);
			int familySu=Integer.parseInt(sc.nextLine());
			
			//객체생성
			sa[i]=new Sawon(name,gibon,sudang,familySu);
			
		}
		
		//출력
		System.out.println("이름\t기본급\t수당\t가족수\t가족수당\t가족수당세금\t실수령액");
		System.out.println("=".repeat(30));
		
		for(Sawon s:sa)
			System.out.println(s.getName()+"\t"+s.getGibon()+"\t"+s.getSudang()+"\t"+s.getFamilySu()+"\t"
					+s.getFamilySudang()+"\t"+s.getTax()+"\t"+s.getNetPay());

	}

}
