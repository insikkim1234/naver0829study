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
import javax.swing.table.TableModel;

import db.DBConnect;

public class Ex2_SawonSwingCRUD extends JFrame{
	JTextField tfName, tfScore;
	JComboBox<String> cbGender;
	JComboBox<String> cbBuseo;
	JTable table;
	DefaultTableModel tableModel;
	JButton btnAdd,btnDel,btnSearch,btnAll;
	//상단 tfName,tfScore,cbGender,cbBuseo
	//테이블
	//하단
	//추가 :데이터추가
	//삭제 : 데이터 클릭시 데이터 삭제
	//조회 : 부서명 입력받아 해당 부서만 출력
	//전체조회: 다시 전체 데이터 조회
	
	DBConnect db=new DBConnect();
	
	public Ex2_SawonSwingCRUD()  {
		super("사원관리");
		this.setBounds(1000, 100, 550, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign();
		this.setVisible(true);
	}
	
	
	private void setDesign() {
		// TODO Auto-generated method stub
		//상단
		tfName=new JTextField(4);
		tfScore=new JTextField(3);
		String []cbGenderSelection= {"남자","여자"};
		cbGender= new JComboBox<String>(cbGenderSelection);
		String []cbBuseoSelection= {"홍보부","인사부","교육부","축구부"};
		cbBuseo=new JComboBox<String>(cbBuseoSelection);
		
		JPanel pTop=new JPanel();
		pTop.add(new JLabel("이름"));
		pTop.add(tfName);
		pTop.add(new JLabel("점수"));
		pTop.add(tfScore);
		pTop.add(new JLabel("성별"));
		pTop.add(cbGender);
		pTop.add(new JLabel("부서"));
		pTop.add(cbBuseo);
		
		this.add("North",pTop);
		
		//하단
		btnAdd=new JButton("추가");
		btnDel=new JButton("삭제");
		btnSearch=new JButton("부서명 검색");
		btnAll=new JButton("전체조회");
		
		JPanel pBottom=new JPanel();
		pBottom.add(btnAdd);
		pBottom.add(btnDel);
		pBottom.add(btnSearch);
		pBottom.add(btnAll);
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String name=tfName.getText();
				
				String score=tfScore.getText();
				String gender=(String)cbGender.getSelectedItem();
				String buseo=(String)cbGender.getSelectedItem();
				
				if(name.length()==0||score.length()==0)
					return;
				
				insertSawon(name,score,gender,buseo);
				
				sawonSelectAll();
				
				tfName.setText("");
				tfScore.setText("");
				
				
				
			}
		});
		
		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row=table.getSelectedRow();
				System.out.println(row);
				if(row==-1)
				{
					JOptionPane.showMessageDialog(Ex2_SawonSwingCRUD.this, "삭제할 행을 선택");
					
				}
				else
				{
					String num=table.getValueAt(row, 0).toString();
					deleteSawon(num);
					sawonSelectAll();	
				}
			}
		});
		
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String searchBuseo=JOptionPane.showInputDialog("검색할 이름 입력");
				System.out.println(searchBuseo);
				if(searchBuseo==null)
					return;
				else
					searchSawon(searchBuseo);
				
			}
		});
		
		btnAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sawonSelectAll();
				
			}
		});
		
		this.add("South",pBottom);
		
		String []title= {"번호","이름","점수","성별","부서"};
		tableModel=new DefaultTableModel(title , 0);
		table=new JTable(tableModel);
		this.add("Center",new JScrollPane(table));
		
		sawonSelectAll();
		
		
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2_SawonSwingCRUD ex=new Ex2_SawonSwingCRUD();
	}
	
	public void sawonSelectAll()
	{
		tableModel.setRowCount(0);
		
		Connection conn=db.getMysqlConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select *\n"
				+ "from sawon\n"
				+ "order by num desc";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();


			while(rs.next())
			{
				Vector<String> data=new Vector<String>();
				
				String num=rs.getString("num");
				String name=rs.getString("name");
				String score=rs.getString("score");
				String gender=rs.getString("gender");
				String buseo=rs.getString("buseo");
				

				//vector에 순서대로 추가
				data.add(num);
				data.add(name);
				data.add(score);
				data.add(gender);
				data.add(buseo);

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
	
	public void insertSawon(String name,String score,String gender,String buseo)
	{
		Connection conn=db.getMysqlConnection();
		PreparedStatement pstmt=null;
		
		String sql="insert into sawon\n"
				+ "values(null,?,?,?,?)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1, name);
			pstmt.setString(2, score);
			pstmt.setString(3, gender);
			pstmt.setString(4, buseo);
			
			//실행
			pstmt.execute();

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
			
		}
		
	}
	
	public void deleteSawon(String num)
	{
		Connection conn=db.getMysqlConnection();
		PreparedStatement pstmt=null;
		
		String sql="delete from sawon\n"
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
	public void searchSawon(String searchBuseo)
	{
		//기존 테이블의 데이터를 모두 지운다
		tableModel.setRowCount(0);

		Connection conn=db.getMysqlConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select *\n"
				+ "from sawon\n"
				+ "where buseo=?";

		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, searchBuseo);
			rs=pstmt.executeQuery();


			while(rs.next())
			{
				Vector<String> data=new Vector<String>();
				
				String num=rs.getString("num");
				String name=rs.getString("name");
				String score=rs.getString("score");
				String gender=rs.getString("gender");
				String buseo=rs.getString("buseo");
				

				//vector에 순서대로 추가
				data.add(num);
				data.add(name);
				data.add(score);
				data.add(gender);
				data.add(buseo);

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
