package Study;

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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import db.DBConnect;

public class Ex1_StudentSwingCRUD extends JFrame{
	JTextField tfName,tfPhone;
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

		//생성
		tfName=new JTextField(4);
		tfPhone=new JTextField(10);
		String []cbTitle= {"A","B","O","AB"};
		cbBlood=new JComboBox<String>(cbTitle);
		//패널로 묶기
		JPanel pTop=new JPanel();
		pTop.add(new JLabel("이름"));
		pTop.add(tfName);
		pTop.add(new JLabel("전화"));
		pTop.add(tfPhone);
		pTop.add(new JLabel("혈액형"));
		pTop.add(cbBlood);
		//추가하기
		this.add("North",pTop);


		//하단

		//생성
		btnAdd=new JButton("추가");
		btnDel=new JButton("삭제");
		btnSearch=new JButton("검색");
		btnAll=new JButton("전체조회");
		//패널로 묵기
		JPanel pBottom=new JPanel();
		pBottom.add(btnAdd);
		pBottom.add(btnDel);
		pBottom.add(btnSearch);
		pBottom.add(btnAll);
		//추가하기
		this.add("South",pBottom);



		//이벤트
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub


				String name=tfName.getText();
				String phone=tfPhone.getText();
				String blood=(String)cbBlood.getSelectedItem();

				if(name.length()==0||phone.length()==0)
					return;

				insertStudent(name,phone,blood);

				studentSelectAll();

				tfName.setText("");
				tfPhone.setText("");

			}
		});

		btnDel.addActionListener(new  ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row=table.getSelectedRow();

				if(row==-1)
				{
					JOptionPane.showMessageDialog(Ex1_StudentSwingCRUD.this, "삭제할 행을 선택");
				}
				else {
					String num=table.getValueAt(row, 0).toString();
					deleteStudent(num);

					studentSelectAll();
				}
			}
		});

		btnSearch.addActionListener(new  ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String searchName=JOptionPane.showInputDialog("검색할 이름 입력");

				if(searchName==null)
				{
					return;
				}
				else {
					searchStudent(searchName);
				}
			}
		});

		btnAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				studentSelectAll();

			}
		});

		//센터
		String []title= {"번호","이름","혈액형","전화","작성일"};
		tableModel=new DefaultTableModel(title,0);
		table=new JTable(tableModel);
		this.add("Center",new JScrollPane(table));
		
		studentSelectAll();

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1_StudentSwingCRUD ex=new Ex1_StudentSwingCRUD();
	}

	public void studentSelectAll()
	{
		tableModel.setRowCount(0);
		
		Connection conn=db.getMysqlConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select *\n"
				+ "from student\n"
				+ "order by num desc";
		try {
			pstmt=conn.prepareStatement(sql);
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
				
				data.add(num);
				data.add(name);
				data.add(blood);
				data.add(phone);
				data.add(Writeday);
				
				tableModel.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
	}
	public void insertStudent(String name,String phone,String blood)
	{
		Connection conn=db.getMysqlConnection();
		PreparedStatement pstmt=null;
		
		String sql="insert into student\n"
				+ "values(null,?,?,?,now())";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, blood);
			pstmt.setString(3, phone);
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	public void deleteStudent(String num)
	{
		Connection conn=db.getMysqlConnection();
		PreparedStatement pstmt=null;
		
		String sql="delete from student\n"
				+ "where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose( pstmt, conn);
		}
	}
	public void searchStudent(String searchName)
	{
		tableModel.setRowCount(0);
		
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
				
				Timestamp ts=rs.getTimestamp("Writeday");
				String Writeday=sdf.format(ts);
				
				data.add(num);
				data.add(name);
				data.add(blood);
				data.add(phone);
				data.add(Writeday);
				
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
