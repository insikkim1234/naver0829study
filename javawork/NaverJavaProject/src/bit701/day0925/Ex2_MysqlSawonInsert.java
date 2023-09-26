package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DBConnect;

public class Ex2_MysqlSawonInsert {
	DBConnect db=new DBConnect();
	
	public void sawonInsert()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("이름");
		String name=sc.nextLine();
		System.out.println("1~100사이 점수");
		int score=Integer.parseInt(sc.nextLine());
		System.out.println("성별");
		String gender=sc.nextLine();
		System.out.println("부서");
		String buseo=sc.nextLine();
		
		String sql="insert into sawon\n"
				+"values(null,'"+name+"',"+score
				+",'"+gender+"','"+buseo+"')";
		System.out.println(sql);
		
		Connection conn=null;
		Statement stmt=null;
		
		conn=db.getMysqlConnection();
		
		try {
			stmt=conn.createStatement();
			stmt.execute(sql);
			System.out.println("sawon에 데이터 추가");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
		
		
		
		
	}
	public static void main(String[] args) {
		
		Ex2_MysqlSawonInsert ex=new Ex2_MysqlSawonInsert();
		ex.sawonInsert();
	}

}
