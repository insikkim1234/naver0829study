package bit701.day0918;

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



public class Ex3_TableFile  /*스윙기본 복붙*/extends JFrame {
	//앞에 이름치고 컨스페
	JTable table;
	DefaultTableModel model;
	JTextField tfName,tfAge,tfAddr;
	JButton btnAdd;
	//파일이름
	final static String FILENAME="D:\\naver0829\\member.txt";



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
			//종료전에 테이블의 내용을 멤버.txt에 추가하도록 코드 작성
			@Override
			public void windowClosing(WindowEvent e) {

				
				FileWriter fw=null;
				//컨1 이벤트에서는 기본적으로 THROW 안됨
				try {
					fw=new FileWriter(FILENAME,true);
					//행갯수 알아냄
					int row=table.getRowCount();
					for(int i=0;i<row;i++)
					{//형변환 필수
						String name=(String) model.getValueAt(i, 0);
						String age=(String) model.getValueAt(i, 1);
						String addr=(String) model.getValueAt(i, 2);
						
						fw.write(name+","+age+","+addr+"\n");//파일에 한줄단위로 저장
						
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally
				{
					//ctrl1
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
	//사용자 정의 함수인 셋디자인에 이름 나이 주소 추가 버튼 생성하기
	private void setDesign() {
		// TODO Auto-generated method stub
		//jpanel conspe
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
		//삽입 방향
		this.add("North",p);

		//테이블을 생성하는데 모델을 통해서 생성
		model=new DefaultTableModel(new String[] {"이름","나이","주소"},0);//행갯수는 일단 0개로 설정
		table=new JTable(model);
		this.add("Center",new JScrollPane(table));

		//버튼이벤트
		//addAction conspe actionlistner conspe
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//1.입력값을 벡터에 넣는다
				Vector<String> data=new Vector<String>();
				data.add(tfName.getText());
				data.add(tfAge.getText());
				data.add(tfAddr.getText());

				//2.addRow매서드로 행을 추가한다
				model.addRow(data);

				//3.입력한 값들을 지운다
				tfName.setText("");
				tfAge.setText("");
				tfAddr.setText("");

			}
		});

	}

	public static void main(String[] args) {
		Ex3_TableFile  s=new Ex3_TableFile ("Table file");//괄호안에 입력시 제목 입력가능
		//근데 여기 이대로면 에러뜸 public SwingGibon에 String title 써줘야함


	}



}
