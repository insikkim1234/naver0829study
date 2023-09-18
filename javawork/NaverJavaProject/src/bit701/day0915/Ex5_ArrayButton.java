package bit701.day0915;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex5_ArrayButton extends JFrame{
	JButton []btn=new JButton[6];
	String []buttonTitle= {"노랑","오렌지","분홍","핫핑크","초록","빨강"};
	Color []buttonColor= {Color.yellow,Color.orange,Color.pink,Color.magenta,Color.GREEN,Color.red};
	
	
	public Ex5_ArrayButton(String title)
	{
		super(title);
		this.setLocation(300, 100);//프레임의 시작위치를 잡겠다
		this.setSize(300, 300);//프레임의 너비 높이
		
		//this.getContentPane().setBackground(Color.GREEN);//color상수 이용 변경
		this.getContentPane().setBackground(new Color(200,255,180));//rgb값 이용 변경
		
		//디자인이나 ㄴ이벤트를 구현할 메서드 호출
		this.setDesign();
		
		
		this.setVisible(true);//true 보이게하기 false 프레임 숨기기
		
		//윈도우 이벤트 발생-익명 내부 클래스 형태로 이벤트 구현
		this.addWindowListener(new WindowAdapter() {
			
			//윈도우의 x버튼 클릭시 호출되는 메서드
			//이렇게 되면 콘솔창에서 빨간 네모 안뜨고 종료 가능하다
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				//JOptionPane.showMessageDialog(SwingGibon.this, "프레임을 종료합니다");
				//실제 종료
				System.exit(0);//정상 종료시
				super.windowClosing(e);
			}
		});
	}
	
	//배열 버튼 이벤트ㅡㄹ 위한 내부클래스
	//액션리스너에 컨스페
	//mybutton 누르고 컨1
	class MyButton implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			for(int i=0;i<btn.length;i++)
			{
				if(e.getSource()==btn[i])
				{
					Ex5_ArrayButton.this.getContentPane().setBackground(buttonColor[i]);
				}
			}
			
		}
		
	}

	private void setDesign() {
		// TODO Auto-generated method stub
		//레이아웃 변경
		//순서대로 나열(flowlayout에 컨스페)
		this.setLayout(new FlowLayout());
		//for문으로 버튼을 갯수만큼 생성하여 이름 배경색 주고 버튼 추가하기
		for(int i=0;i<btn.length;i++)
		{
			btn[i]=new JButton(buttonTitle[i]);
			btn[i].setBackground(buttonColor[i]);
			this.add(btn[i]);
			
			//버튼 이벤트 발생
			btn[i].addActionListener(new MyButton());
		}
		
	}

	public static void main(String[] args) {
		Ex5_ArrayButton s=new Ex5_ArrayButton("배열버튼");//괄호안에 입력시 제목 입력가능
		//근데 여기 이대로면 에러뜸 public SwingGibon에 String title 써줘야함
		

	}

}
