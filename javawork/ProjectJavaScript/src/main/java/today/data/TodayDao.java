package today.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import mysql.db.DBConnect;

public class TodayDao {
	DBConnect db=new DBConnect();
	
	
	public List<TodayDto>  getAllToday()
	{
		List<TodayDto> list=new Vector<TodayDto>();
		Connection conn= db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from today order by num  ";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				TodayDto dto=new TodayDto();
				
				dto.setNum(rs.getInt("num"));
				dto.setLogin(rs.getString("login"));
				dto.setGithub(rs.getString("github"));
				dto.setNaver(rs.getString("naver"));
				dto.setSlack(rs.getString("slack"));
				dto.setGooglenote(rs.getString("googlenote"));
				dto.setCommit(rs.getString("commit"));
				dto.setLogout(rs.getString("logout"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				list.add(dto);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		return list;
	}
	
	public void insertToday(TodayDto dto)
	{
		String sql="insert into today(login,github,naver,slack,googlenote,commit,logout,writeday) values(?,?,?,?,?,?,?,now())";
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getLogin());
			pstmt.setString(2, dto.getGithub());
			pstmt.setString(3, dto.getNaver());
			pstmt.setString(4, dto.getSlack());
			pstmt.setString(5, dto.getGooglenote());
			pstmt.setString(6, dto.getCommit());
			pstmt.setString(7, dto.getLogout());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
		
	}
	public void deleteToday(String num)
	{
		String sql="delete from today where num=?";
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	

}
