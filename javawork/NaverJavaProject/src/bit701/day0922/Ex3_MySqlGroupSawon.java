package bit701.day0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Ex3_MySqlGroupSawon {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";

	Ex3_MySqlGroupSawon(){
		try {
			Class.forName(MYSQL_DRIVER);
			//System.out.println("Mysql 드라이버 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("Mysql 드라이버 실패:"+e.getMessage());
		}
	}
	
	public void sawonBunseok()
	{
		String sql="select buseo,count(*) count,max(score) maxscore,"
				+ "min(score) minscore,avg(score) avgscore "
				+ "from sawon group by buseo";
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		
		try {
			conn=DriverManager.getConnection(MYSQL_URL, "root", "1234");
			stmt= conn.createStatement();
			rs=stmt.executeQuery(sql);
			System.out.println("부서  인원수  최고점수  최저점수  평균");
			System.out.println("=".repeat(30));
			while(rs.next())
			{
				String buseo=rs.getString("buseo");
				int count=rs.getInt("count");
				int maxscore=rs.getInt("maxscore");
				int minscore=rs.getInt("minscore");
				double avgscore=rs.getDouble("avgscore");
				
				System.out.println(buseo+"\t"+count+"\t"+maxscore+"\t"+minscore+"\t"+avgscore);
			}
		} catch (SQLException e) {
			System.out.println("mysql연결실패"+e.getMessage());
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException|NullPointerException e) {
				
			}
			
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex3_MySqlGroupSawon ex=new Ex3_MySqlGroupSawon();
		ex.sawonBunseok();
	}

}