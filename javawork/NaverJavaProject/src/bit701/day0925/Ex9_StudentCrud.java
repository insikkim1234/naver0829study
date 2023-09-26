package bit701.day0925;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import db.DBConnect;

public class Ex9_StudentCrud {
	DBConnect db=new DBConnect();
	Scanner sc=new Scanner(System.in);
	
	public int getMenu()
	{
		System.out.println("1.추가  2.삭제  3.수정 4.전체출력  5.검색  6.종료");
		int menu=Integer.parseInt(sc.nextLine());
		return menu;
	}
	
	//insert
	public void insertStudent()
	{
		System.out.println("이름");
		String name=sc.nextLine();
		System.out.println("혈액형");
		String blood=sc.nextLine();
		System.out.println("폰번호");
		String phone=sc.nextLine();
		
//		String sql="insert into sawon\n"
//				+"values(null,'"+name+"',"+score
//				+",'"+gender+"','"+buseo+"')";
		
		String sql="insert into student\n"
				+ "values(null,?,?,?,now())";
		
		Connection conn=db.getMysqlConnection();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, blood.toUpperCase());
			pstmt.setString(3, phone);
			
			pstmt.execute();
			
			System.out.println("학생정보 추가");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//delete 
	public void deleteStudent()
	{
		System.out.println("삭제할 이름 입력");
		String name=sc.nextLine();
		
		Connection conn=db.getMysqlConnection();
		PreparedStatement pstmt=null;
		
//		String sql="delete from sawon\n"
//				+"where name='"+sang+"'";
		
		String sql="delete from student\n"
				+ "where name=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, name);
			//실행
			int n=pstmt.executeUpdate();
			if(n==0)
				System.out.println("삭제할 사원 없음");
			else
				System.out.println(n+"명 삭제완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			db.dbClose(pstmt, conn);
		}
	}
	
	//update
	public void updateStudent()
	{
		System.out.println("수정할  번호는");
		String num=sc.nextLine();
		System.out.println("수정할 이름은");
		String name=sc.nextLine();
		System.out.println("수정할 혈액형은");
		String blood=sc.nextLine();
		System.out.println("수정할  폰번호은?");
		String phone=sc.nextLine();
		

//		String sql="update sawon\n"
//				+"set name='"+name+"',score='"+score+"',gender='"+gender+"',buseo='"+buseo+"'\n"
//				+"where num="+num;
		
		String sql="update student\n"
				+ "set name=?,blood=?,phone=?\n"
				+ "where num=?";
		Connection conn=db.getMysqlConnection();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, blood.toUpperCase());
			pstmt.setString(3, phone);
			pstmt.setString(4, num);
			
			int n =pstmt.executeUpdate();
			if(n==0)
				System.out.println("해당 데이터가 없어요");
			else
				System.out.println("사원 정보를 수정했어요");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally 
		{
			db.dbClose(pstmt, conn);
		}
	
	}
	//전체출력
	public void selectAllStudent()
	{
		String sql="select *\n"
				+ "from student\n"
				+ "order by num";
		
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		
		conn=db.getMysqlConnection();
		
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			System.out.println("번호\t사원명\t혈액형\t폰번\t날짜");
			System.out.println("=".repeat(50));
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd HH:mm");
			while(rs.next())
			{
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String blood=rs.getString("blood");
				String phone=rs.getString("phone");
				String writeday=rs.getString("writeday");
				//Timestamp ts=rs.getTimestamp("writeday");
				System.out.println(num+"\t"+name+"\t"+blood+"\t"+phone+"\t"+writeday);
				
						
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			db.dbClose(rs, pstmt, conn);
		}
	}
	
	//검색 번호 끝네자리로 검색
	public void searchPhone()
	{
		System.out.println("전화번호 끝네자리 입력");
		String searchPhone=sc.nextLine();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select *\n"
				+ "from student\n"
				+ "where phone like ?";
		
		conn=db.getMysqlConnection();
		
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchPhone);
			rs=pstmt.executeQuery();
			System.out.println("전화번호"+searchPhone+"검색결과");
			System.out.println("번호\t사원명\t혈액형\t폰번\t날짜");
			System.out.println("=".repeat(50));
			
			while(rs.next())
			{
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String blood=rs.getString("blood");
				String phone=rs.getString("phone");
				String writeday=rs.getString("writeday");
				//Timestamp ts=rs.getTimestamp("writeday");
				System.out.println(num+"\t"+name+"\t"+blood+"\t"+phone+"\t"+writeday);
				
						
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			db.dbClose(rs, pstmt, conn);
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex9_StudentCrud ex=new Ex9_StudentCrud();
		while(true)
		{
			System.out.println("-".repeat(40));
			int menu=ex.getMenu();
			System.out.println("-".repeat(40));
			
			switch(menu)
			{
			case 1:
				ex.insertStudent();
				break;
			case 2:
				ex.deleteStudent();
				break;
			case 3:
				ex.updateStudent();
				break;
			case 4:
				ex.selectAllStudent();
				break;
			case 5:
				ex.searchPhone();
				break;
			default:
				System.out.println("종료");
				System.exit(0);
			}
		}
	}

}
