package myshop.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import mysql.db.DBConnect;

public class MyShopDao {
	DBConnect db=new DBConnect();
	
	
	//전체 출력하는 메서드
		public List<MyShopDto> getAllSangpums()
		{
			List<MyShopDto> list=new Vector<MyShopDto>();
			Connection conn= db.getConnection();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String sql="select * from myshop order by num";
			//트캣
			try {
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				while(rs.next())//rs.next 가 false가 되는 순간이 마지막 튜플
				{
					MyShopDto dto=new MyShopDto();//반드시 while안에 선언
					dto.setNum(rs.getInt("num"));
					dto.setSangpum(rs.getString("sangpum"));
					dto.setPrice(rs.getInt("price"));
					dto.setPhoto(rs.getString("photo"));
					dto.setColor(rs.getString("color"));
					dto.setWriteday(rs.getTimestamp("writeday"));
					
					//list에 추가
					list.add(dto);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				db.dbClose(rs,pstmt, conn);
			} 
			
			
			return list;
		}
		
		//insert
		public void insertShop(MyShopDto dto)
		{
			String sql="insert into myshop (sangpum,color,price,photo,writeday) "
					+ "values (?,?,?,?,now())";
			
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			
			try {
				pstmt=conn.prepareStatement(sql);
				//바인딩
				pstmt.setString(1, dto.getSangpum());
				pstmt.setString(2, dto.getColor());
				pstmt.setInt(3, dto.getPrice());
				pstmt.setString(4, dto.getPhoto());
				//실행 (이거 없으면 결과가 안나온다)
				pstmt.execute();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				db.dbClose(pstmt, conn);
			}
			
		}
		
		//delete
		public void deleteShop(String num)
		{
			String sql="delete from myshop where num=?";
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			
			try {
				pstmt=conn.prepareStatement(sql);
				//바인딩
				pstmt.setString(1, num);
				
				//실행
				pstmt.execute();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				db.dbClose(pstmt, conn);
			}
		}
		
		//num 에 해당하는 dto반환
				public MyShopDto getSangpum(String num)
				{
					MyShopDto dto=new MyShopDto();
					Connection conn= db.getConnection();
					PreparedStatement pstmt=null;
					ResultSet rs=null;
					String sql="select * from myshop where num=?";
					//트캣
					try {
						pstmt=conn.prepareStatement(sql);
						//바인딩
						pstmt.setString(1, num);
						//실행
						rs=pstmt.executeQuery();
						
						if(rs.next())
						{
							//반드시 while안에 선언
							dto.setNum(rs.getInt("num"));
							dto.setSangpum(rs.getString("sangpum"));
							dto.setPrice(rs.getInt("price"));
							dto.setPhoto(rs.getString("photo"));
							dto.setColor(rs.getString("color"));
							dto.setWriteday(rs.getTimestamp("writeday"));
							
							
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						db.dbClose(rs,pstmt, conn);
					} 
					
					
					return dto;
				}
				
				//update
				public void updateShop(MyShopDto dto)
				{
					String sql="update myshop set sangpum=?,color=?,price=?,photo=? where num=?";
					
					Connection conn=db.getConnection();
					PreparedStatement pstmt=null;
					
					try {
						pstmt=conn.prepareStatement(sql);
						//바인딩
						pstmt.setString(1, dto.getSangpum());
						pstmt.setString(2, dto.getColor());
						pstmt.setInt(3, dto.getPrice());
						pstmt.setString(4, dto.getPhoto());
						pstmt.setInt(5, dto.getNum());
						//실행 (이거 없으면 결과가 안나온다)
						pstmt.execute();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						db.dbClose(pstmt, conn);
					}
					
				}
}
















































