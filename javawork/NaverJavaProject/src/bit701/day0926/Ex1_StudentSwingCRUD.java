package bit701.day0926;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import db.DBConnect;

public class Ex1_StudentSwingCRUD extends JFrame{

	JTextField tfName, tfPhone;
	JComboBox<String> cbBlood;
	JTable table;
	DefaultTableModel tableModel;
	JButton btnAdd,btnDel,btnSearch,btnAll;

	DBConnect db=new DBConnect();

	public Ex1_StudentSwingCRUD() {
		// TODO Auto-generated constructor stub
		super("학생관리");
		this.setBounds(1000,100,550,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign();
		this.setVisible(true);
	}



	private void setDesign() {
		// TODO Auto-generated method stub
		//상단
		tfName=new JTextField(4);
		tfPhone=new JTextField(10);
		String []cbTitle= {"A","B","O","AB"};
		cbBlood=new JComboBox<String>(cbTitle);

		JPanel pTop=new JPanel();
		pTop.add(new JLabel("이름"));
		pTop.add(tfName);
		pTop.add(new JLabel("전화"));
		pTop.add(tfPhone);
		pTop.add(new JLabel("혈액형"));
		pTop.add(cbBlood);

		this.add("North", pTop);

		//하단
		btnAdd=new JButton("추가");
		btnDel=new JButton("삭제");
		btnSearch=new JButton("검색");
		btnAll=new JButton("전체조회");

		JPanel pBottom=new JPanel();
		pBottom.add(btnAdd);
		pBottom.add(btnDel);
		pBottom.add(btnSearch);
		pBottom.add(btnAll);
		
		this.add("South",pBottom);

		//button event 
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//입력된 데이터를 가져와서 
				String name=tfName.getText();
				String phone=tfPhone.getText();
				String blood=(String)cbBlood.getSelectedItem();
				//이름이나 전화번호 입력 안했을 경우 종료
				if(name.length()==0||phone.length()==0)
					return;
				
				//db에 insert하는 메서드 호출
				insertStudent(name,phone,blood);
				//db로부터 다시 데이터를 가져와서 출려
				studentSelectAll();
				
				//입력값 초기화
				tfName.setText("");
				tfPhone.setText("");

			}
		});

		btnDel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//선택한 행번호를 얻는다
				//튜플별로 0부터 시작선택 안했을 시 -1 
				//클릭한 튜플을 0부터 입력받는다
				int row=table.getSelectedRow();
				//System.out.println(row);
				if(row==-1)
				{
					JOptionPane.showMessageDialog(Ex1_StudentSwingCRUD.this, "삭제할 행을 선택");
				}
				else {
					//row 행의 0번열을 num에 저장
					String num=table.getValueAt(row, 0).toString();
					//반환타입이 오브젝트이므로 투스트링으로 맞춰줌
					deleteStudent(num);
					
					//삭제후 데이터 불러오기
					studentSelectAll();
				}

			}
		});
		//조회
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//검색할 이름 입력받기
				String searchName=JOptionPane.showInputDialog("검색할 이름 입력");
				//System.out.println(searchName);
				if(searchName==null)
					return;//취소누를경우 이벤트 종료
				else
					searchStudent(searchName);//이름이 포함된 모든 데이터 테이블에 출력

			}
		});
		
		//전체조회
		btnAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				studentSelectAll();
			}
		});

		

		//센터
		//테이블 모델 생성
		String []title= {"번호","이름","혈액형","전화","작성일"};
		tableModel=new DefaultTableModel(title, 0);
		//테이블 설정
		table=new JTable(tableModel);
		this.add("Center",new JScrollPane(table));

		//초기 db데이터 가져오기
		studentSelectAll();
	}



	public static void main(String[] args) {
		Ex1_StudentSwingCRUD ex=new Ex1_StudentSwingCRUD();

	}

	//db method
	//db에서 전체 데이터를 가져와서 테이블에 출력하는 메서드
	public void studentSelectAll()
	{
		//기존 테이블의 데이터를 모두 지운다
		tableModel.setRowCount(0);
		//컨채 프 리
		Connection conn=db.getMysqlConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		//sql
		String sql="select *\n"
				+ "from student\n"
				+ "order by num desc";

		try {
			//프채 리채
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();

			//while문으로 다음 튜플이 있을때까지 반복
			while(rs.next())
			{
				//벡터 생성
				Vector<String> data=new Vector<String>();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
				//어트리뷰트 선언 생성
				String num=rs.getString("num");
				String name=rs.getString("name");
				String blood=rs.getString("blood");
				String phone=rs.getString("phone");

				Timestamp ts=rs.getTimestamp("writeday");
				String Writeday=sdf.format(ts);

				//vector에 순서대로 추가
				data.add(num);
				data.add(name);
				data.add(blood);
				data.add(phone);
				data.add(Writeday);

				//테이블에 추가
				tableModel.addRow(data);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
	}
	//db에 추가
	public void insertStudent(String name,String phone,String blood)
	{
//		System.out.println(name);
//		System.out.println(phone);
//		System.out.println(blood);
		//컨채 프
		Connection conn=db.getMysqlConnection();
		PreparedStatement pstmt=null;
		//sql
		String sql="insert into student\n"
				+ "values(null,?,?,?,now())";
		
		try {
			//채
			pstmt=conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1, name);
			pstmt.setString(2, blood);
			pstmt.setString(3, phone);
			
			//실행
			pstmt.execute();

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
			
		}
	}
	
	//db 삭제하는 메서드
	public void deleteStudent(String num)
	{
		//System.out.println(num);
		//컨채 프
		Connection conn=db.getMysqlConnection();
		PreparedStatement pstmt=null;
		///sql
		String sql="delete from student\n"
				+ "where num=?";
		
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
	
	//이름 검색하는 메서드
		public void searchStudent(String searchName)
		{
			//기존 테이블의 데이터를 모두 지운다
			tableModel.setRowCount(0);
			//컨채 프 리
			Connection conn=db.getMysqlConnection();
			PreparedStatement pstmt=null;
			ResultSet rs=null;

			String sql="select *\n"
					+ "from student\n"
					+ "where name like ?";

			try {
				pstmt=conn.prepareStatement(sql);
				
				pstmt.setString(1, "%"+searchName+"%");
				rs=pstmt.executeQuery();


				while(rs.next())
				{
					Vector<String> data=new Vector<String>();
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
					String num=rs.getString("num");
					String name=rs.getString("name");
					String blood=rs.getString("blood");
					String phone=rs.getString("phone");

					Timestamp ts=rs.getTimestamp("writeday");
					String Writeday=sdf.format(ts);

					//vector에 순서대로 추가
					data.add(num);
					data.add(name);
					data.add(blood);
					data.add(phone);
					data.add(Writeday);

					//테이블에 추가
					tableModel.addRow(data);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				db.dbClose(rs, pstmt, conn);
			}
		}


}
