package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DBConnect;

public class Ex6_MySqlSawonUpdate {
	DBConnect db=new DBConnect();
	
	public void sawonUpdate()
	{
		Scanner sc=new Scanner(System.in);
		//sang_no 값으로 가격 색상 수정
		System.out.println("수정할  번호는");
		String num=sc.nextLine();
		System.out.println("수정할 이름은");
		String name=sc.nextLine();
		System.out.println("수정할 점수은");
		int score=Integer.parseInt(sc.nextLine());
		System.out.println("수정할  성별은?");
		String gender=sc.nextLine();
		System.out.println("수정할 부서는");
		String buseo=sc.nextLine();
		
		
		String sql="update sawon\n"
				+"set name='"+name+"',score='"+score+"',gender='"+gender+"',buseo='"+buseo+"'\n"
				+"where num="+num;
		System.out.println(sql);
		
		Connection conn=null;
		Statement stmt=null;
		conn=db.getMysqlConnection();
		try {
			stmt=conn.createStatement();
			int n=stmt.executeUpdate(sql);
			if(n==0)
				System.out.println("해당 상품이 없어요");
			else
				System.out.println("사원정보를 수정했어요");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex6_MySqlSawonUpdate ex=new Ex6_MySqlSawonUpdate();
		ex.sawonUpdate();

	}

}
