package bit701.day0915;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

//Jframe 의 모든 메서드 이용가능
public class SwingGibon extends JFrame {
	public SwingGibon(String title)
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
		
	}

	public static void main(String[] args) {
		SwingGibon s=new SwingGibon("안녕");//괄호안에 입력시 제목 입력가능
		//근데 여기 이대로면 에러뜸 public SwingGibon에 String title 써줘야함
		

	}

}
