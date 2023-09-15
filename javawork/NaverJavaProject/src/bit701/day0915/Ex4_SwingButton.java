package bit701.day0915;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex4_SwingButton extends JFrame implements ActionListener{
	JButton btn1,btn2,btn3;
	
	public  Ex4_SwingButton(String title)
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
	//버튼 이벤트를 이번에는 내부클래스로 만들어보자
	class MyColorButton implements ActionListener
	{
		//mycolorbutton 오버라이드 actionperformed
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==btn1)
				Ex4_SwingButton.this.getContentPane().setBackground(Color.orange);
			else
				Ex4_SwingButton.this.getContentPane().setBackground(Color.magenta);
			
		}
	}
	private void setDesign() {
		// TODO Auto-generated method stub
		//자바에서 제공하는 레이아웃을 안쓰고 
		this.setLayout(null);
		//직접 위치지정을 할 경우
		//btn1생성
		btn1=new JButton("오렌지색");
		btn1.setBounds(20, 50, 100, 50);//x y width height
		this.add(btn1);
		
		//btn2생성
		btn2=new JButton("핑크색");
		btn2.setBounds(130, 50, 100, 50);//x y width height
		this.add(btn2);
		
		//button 1,2는 내부 클래스  MyColorButton 의 이벤트를 호출해보자
		btn1.addActionListener(new MyColorButton());
		btn2.addActionListener(new MyColorButton());
		
		//btn3생성
		btn3=new JButton("버튼글자 배경색변경");
		btn3.setBounds(40, 130,130 , 50);
		this.add(btn3);
		
		//btn3은 익명내부클래스 형태로만들어보자
		btn3.addActionListener(new ActionListener() {//Ac치고 컨스페
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btn1.setBackground(Color.GREEN);
				btn1.setForeground(Color.red);
				
				btn2.setBackground(Color.pink);
				btn2.setForeground(Color.blue);
				

				btn3.setBackground(Color.black);
				btn3.setForeground(Color.yellow);
				
			}
		});
		
		
		
	}

	public static void main(String[] args) {
		Ex4_SwingButton s=new Ex4_SwingButton("안녕");//괄호안에 입력시 제목 입력가능
		//근데 여기 이대로면 에러뜸 public SwingGibon에 String title 써줘야함
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
