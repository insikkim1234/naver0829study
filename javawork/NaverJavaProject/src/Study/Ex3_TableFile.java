package Study;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import bit701.day0915.SwingGibon;

public class Ex3_TableFile extends JFrame {
	//스윙기본 만드는 생성자(인자로 지우는바 위에 있는 이름을 받음
	JTable table;
	DefaultTableModel model;
	JTextField tfName,tfAge,tfAddr;
	JButton btnAdd;
	final static String FILENAME="D:\\naver0829\\member2.txt";
	
	public Ex3_TableFile(String title)
	{
		//제이프레임의 title 입력하고 출력
		super(title);
		//프레임의 시작위치를 잡겠다
		this.setLocation(300, 100);
		//프레임의 너비 높이
		this.setSize(400, 300);
		
		//this.getContentPane().setBackground(Color.GREEN);//color상수 이용 변경
		//this.getContentPane().setBackground(new Color(200,255,180));//rgb값 이용 변경
		
		//디자인이나 이벤트를 구현할 메서드 호출
		this.setDesign();
		
		//true 보이게하기 false 프레임 숨기기
		this.setVisible(true);
		
		//윈도우 이벤트 발생-익명 내부 클래스 형태로 이벤트 구현
		//윈도우 어댑터에 컨스
		//윈도우 클로징에 오버라이딩
		
		
		
		
		this.addWindowListener(new WindowAdapter() {
			
			//윈도우의 x버튼 클릭시 호출되는 메서드
			//이렇게 되면 콘솔창에서 빨간 네모 안뜨고 종료 가능하다
			@Override
			public void windowClosing(WindowEvent e) {
				FileWriter fw=null;
				
				try {
					fw=new FileWriter(FILENAME,true);
					int row=table.getRowCount();
					for(int i=0;i<row;i++)
					{
						String name=(String) model.getValueAt(i, 0);
						String age=(String) model.getValueAt(i, 1);
						String addr=(String) model.getValueAt(i, 2);
						
						fw.write(name+","+age+","+addr+"\n");
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally
				{
					try {
						fw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				
				System.exit(0);//정상 종료시
				super.windowClosing(e);
			}
		});
	}

	private void setDesign() {
		// TODO Auto-generated method stub
		JPanel p=new JPanel();
		tfName=new JTextField(4);
		tfAge=new JTextField(3);
		tfAddr=new JTextField(5);
		btnAdd=new JButton("추가");
		p.add(new JLabel("이름"));
		p.add(tfName);
		p.add(new JLabel("나이"));
		p.add(tfAge);
		p.add(new JLabel("주소"));
		p.add(tfAddr);
		p.add(btnAdd);
		
		this.add("North",p);
		
		model=new DefaultTableModel(new String[] {"이름","나이","주소"},0);
		table=new JTable(model);
		this.add("Center",new JScrollPane(table));
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Vector<String> data=new Vector<String>();
				data.add(tfName.getText());
				data.add(tfAge.getText());
				data.add(tfAddr.getText());
				
				model.addRow(data);
				
				tfName.setText("");
				tfAge.setText("");
				tfAddr.setText("");
				
			}
		});
		
		
	}

	public static void main(String[] args) {
		Ex3_TableFile s=new Ex3_TableFile("tablefile");//괄호안에 입력시 제목 입력가능
		//근데 여기 이대로면 에러뜸 public SwingGibon에 String title 써줘야함
		

	}

	

}
