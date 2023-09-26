package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DBConnect;

public class Ex4_MysqlSawonDelete {
	DBConnect db=new DBConnect();
	
	public void sawonDelete()
	{
		//사원명 입력후 해당사원 삭제
		//결과값이 0이면 xxx사원은 없습니다
		//결과값이 n이면 총 n명의 xxx사원정보를 삭제했습니다.
		Scanner sc=new Scanner(System.in);
		System.out.println("삭제할 이름 입력");
		String sang=sc.nextLine();
		String sql="delete from sawon\n"
				+"where name='"+sang+"'";
		System.out.println(sql);
		
		Connection conn=null;
		Statement stmt=null;
		
		conn=db.getMysqlConnection();
		
		try {
			stmt=conn.createStatement();
			//실행 성공적으로 삭제된 레코드의 갯수를 알고싶다면excuteUpdate
			int n=stmt.executeUpdate(sql);
			
			if(n==0)
				System.out.println(sang+"인물은 없음");
			else
				System.out.println("총 "+n+"명의 "+sang+"인물을 삭제했습니다");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex4_MysqlSawonDelete ex=new Ex4_MysqlSawonDelete();
		ex.sawonDelete();

	}

}
