package mysql.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class DBConnect {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	//local mysql url
	//static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	
	//원격 연결
	static final String MYSQL_URL="jdbc:mysql://db-jbnjj-kr.vpc-pub-cdb.ntruss.com:3306/studydb?serverTimezone=Asia/Seoul";
	
	public DBConnect() {
		try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("mysql드라이버 오류:"+e.getMessage());
		}
	}
	
	//connection,getconnection,drivemanager에 컨스페(sql관련된걸 고름), 컨1로 트캣 
	public Connection getConnection()
	{
		Connection conn=null;
		try {
			//local 원격
			//conn=DriverManager.getConnection(MYSQL_URL, "root", "1234");
			
			//원격 연결
			conn=DriverManager.getConnection(MYSQL_URL, "study", "bitcamp123!@#");
		} catch (SQLException e) {
			System.out.println("my sql 연결실패:"+e.getMessage());
		}
		return conn;
	}
	
	public void dbClose(PreparedStatement pstmt,Connection conn)
	{
		try {
			pstmt.close();
			conn.close();
		}catch(SQLException |NullPointerException e) {
			e.printStackTrace();
		}
		
	}
	
	public void dbClose( ResultSet rs, PreparedStatement pstmt,Connection conn)
	{
		try {
			rs.close();
			pstmt.close();
			conn.close();
		}catch(SQLException | NullPointerException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
