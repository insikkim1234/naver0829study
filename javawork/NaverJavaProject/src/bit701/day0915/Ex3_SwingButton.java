package bit701.day0915;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
//ex3은 J프레임이자 액션리스너
public class Ex3_SwingButton  extends JFrame implements ActionListener {
	
	JButton btn1,btn2;
	//액션리스너는 actionperformed를 오버라이딩 해줘야함
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn1) {
			System.out.println("버튼1클릭");
			this.getContentPane().setBackground(Color.red);
		}
		else {
			System.out.println("버튼2클릭");
			this.getContentPane().setBackground(Color.blue);
		}
		
	}

	
	
	public Ex3_SwingButton (String title)
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

	private void setDesign() {
		// TODO Auto-generated method stub
		btn1=new JButton("버튼 #1");//버튼 생성
		//프레임에 버튼1추가
		this.add(btn1,"South");//BorderLayout(기본)인 경우는 위치를 지정해야함North South East West Center
		//버튼2추가
		btn2=new JButton("버튼#2");
		this.add(btn2,"North");
		
		//버튼12에 이벤트가 발생되도록 추가해보자
		btn1.addActionListener(this);//()안의 this는 이벤트 메서드가 구현된 클래스의 인스턴스//누르면 버튼1클릭 출력
		btn2.addActionListener(this);//둘다 같은 이벤트 메서드가 호출//누르면 버튼2출력
		
	}

	public static void main(String[] args) {
		Ex3_SwingButton s=new Ex3_SwingButton("버튼");//괄호안에 입력시 제목 입력가능
		//근데 여기 이대로면 에러뜸 public SwingGibon에 String title 써줘야함
		

	}

}
