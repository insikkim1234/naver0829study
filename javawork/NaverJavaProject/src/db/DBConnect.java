package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";

	static final String ORACLE_DRIVER="oracle.jdbc.driver.OracleDriver";
	static final String ORACLE_URL="jdbc:oracle:thin:@localhost:1521:xe";

	public DBConnect() {
		// TODO Auto-generated constructor stub
		//forname 트캣
		try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("mysql드라이버 오류:"+e.getMessage());
		}
		//forname트캣
		try {
			Class.forName(ORACLE_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("oracle드라이버 오류:"+e.getMessage());
		}
	}

	//oracle연결
	public Connection getOracleConnection()
	{
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(ORACLE_URL, "angel", "a1234");
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패:"+e.getMessage());
		}
		return conn;
	}

	//mysql연결
	public Connection getMysqlConnection()
	{
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(MYSQL_URL, "root", "1234");
		} catch (SQLException e) {
			System.out.println("mysql 연결 실패:"+e.getMessage());
		}
		return conn;
	}

	//close1
	public void dbClose(Statement stmt,Connection conn)
	{
		try {
			stmt.close();
			conn.close();

		}catch(SQLException|NullPointerException e) {
			System.out.println("close하다ㅏ 오류"+e.getMessage());
		}
	}

	//close2
	public void dbClose(ResultSet rs,Statement stmt,Connection conn)
	{
		try {
			rs.close();
			stmt.close();
			conn.close();

		}catch(SQLException|NullPointerException e) {
			System.out.println("close하다ㅏ 오류"+e.getMessage());
		}
	}

	//close3
	public void dbClose(PreparedStatement pstmt,Connection conn)
	{
		try {
			pstmt.close();
			conn.close();

		}catch(SQLException|NullPointerException e) {
			System.out.println("close하다ㅏ 오류"+e.getMessage());
		}
	}

	//close4
	public void dbClose(ResultSet rs,PreparedStatement pstmt,Connection conn)
	{
		try {
			rs.close();
			pstmt.close();
			conn.close();

		}catch(SQLException|NullPointerException e) {
			System.out.println("close하다ㅏ 오류"+e.getMessage());
		}
	}

}
