package bit701.day0918;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Ex1_ComboBox extends JFrame{

	JPanel p=new JPanel();
	JComboBox<String> combo;//콤보박스 생성시 입력
	JRadioButton rbYellow,rbMagenta,rbGray,rbBlue;
	JLabel lblMessage;


	public Ex1_ComboBox(String title) {
		super(title);
		this.setBounds(1000, 100, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료메서드
		this.setDesign();
		this.setVisible(true);
	}
	//셋디자인 만들어놓고 컨스페로 함수 만들기
	private void setDesign() {
		Vector<String> list=new Vector<String>();
		list.add("빨강");
		list.add("초록");
		list.add("분홍");	
		list.add("오렌지");

		//콤보박스 생성
		combo=new JComboBox<String>(list);

		//상단에 추가
		//this.add("North",combo);//상단 전체에 추가
		JPanel pTop=new JPanel();
		pTop.add(combo);
		this.add("North",pTop);

		//p 패널에 라벨 추가
		lblMessage=new JLabel("Have a dniceday");
		//글자크기 글꼴 조절
		lblMessage.setFont(new Font("Comic sans MS",Font.BOLD,30));
		p.add(lblMessage);

		//center에는 jpannal p추가( 색바꿈)
		p.setBackground(Color.red);
		this.add("Center",p);

		//ㅂ콤보박스 이벤트
		//new it에서 컨스페
		combo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				//선택한 문자열을 얻어보자

				String selectColor=(String)combo.getSelectedItem();//타이비 오브젝트이므로 스트링으로 디모션하여 셀ㄺ트칼라에 저장
				System.out.println(selectColor);
				//jdk8부터 스위치에서 스트링 가능
				//switch문 이용해서 배경색 바꾸기
				switch(selectColor)
				{
				case "빨강":
					p.setBackground(Color.red);
					break;
				case "분홍":
					p.setBackground(Color.pink);
					break;	
				case "오렌지":
					p.setBackground(Color.orange);
					break;	
				case "초록":
					p.setBackground(Color.green);
					break;		
				}

			}
		});

		//하단에 4개의 라디오버튼 추가
		ButtonGroup bg=new ButtonGroup();
		rbYellow=new JRadioButton("노랑");
		rbBlue=new JRadioButton("파랑");
		rbMagenta=new JRadioButton("핫핑크");
		rbGray=new JRadioButton("회색");
		//라디오 버튼을 그룹별로 묶기 이거 안하면 중복선택이 가능할것임
		bg.add(rbYellow);
		bg.add(rbBlue);
		bg.add(rbMagenta);
		bg.add(rbGray);
		//4개의 라디오 버튼을패널에 묶어서 넣은후 프레임에 추가
		JPanel pBottom=new JPanel();
		pBottom.add(rbYellow);
		pBottom.add(rbBlue);
		pBottom.add(rbGray);
		pBottom.add(rbMagenta);

		//위치
		this.add("South",pBottom);

		//글자색 변경 이벤트(배열이 아니므로 각각 이벤트 추가) 4개 각각 추가
		rbYellow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lblMessage.setForeground(Color.yellow);
			}
		});

		rbBlue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lblMessage.setForeground(Color.blue);
			}
		});

		rbGray.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lblMessage.setForeground(Color.gray);
			}
		});

		rbMagenta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lblMessage.setForeground(Color.magenta);
			}
		});



	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1_ComboBox ex=new Ex1_ComboBox("ComboBox");

	}

}
