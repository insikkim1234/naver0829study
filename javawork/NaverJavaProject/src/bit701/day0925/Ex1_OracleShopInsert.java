package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DBConnect;

public class Ex1_OracleShopInsert {
	DBConnect db=new DBConnect();
	
	public void shopInsert()
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("상품명 입력");
		String sang=sc.nextLine();
		
		System.out.println("가격입력");
		int price=Integer.parseInt(sc.nextLine());
		
		System.out.println("색상 입력");
		String color=sc.nextLine();
		
		String sql="insert into shop\r\n"
				+ "values(seq_shop.nextval,'"+sang+"',"+price+",'"+color+"')";
		System.out.println(sql);
		
		//연결
		Connection conn=null;
		Statement stmt=null;
		
		//db연결
		conn=db.getOracleConnection();
		
		//statement trycatch
		try {
			stmt=conn.createStatement();
			//실행
//			boolean b=stmt.execute(sql);false는 실행결과가 없을경우
//			int n=stmt.executeUpdate(sql);//sql문이 성공한 갯수
//			System.out.println(b+","+n);
//			System.out.println("데이터 두번 insert됨");
			
			stmt.execute(sql);
			System.out.println("shop에 데이터 추가됨");
		} catch (SQLException e) {
			System.out.println("insert문 sql오류"+e.getMessage());
		} finally {
			db.dbClose(stmt, conn);
		}
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1_OracleShopInsert ex=new Ex1_OracleShopInsert();
		ex.shopInsert();

	}

}
