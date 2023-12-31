package bit701.day0915;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

//Jframe 클래스의 모든 메서드 이용가능
public class SwingGibon extends JFrame {
	//스윙기본 만드는 생성자(인자로 지우는바 위에 있는 이름을 받음
	public SwingGibon(String title)
	{
		//제이프레임의 title 입력하고 출력
		super(title);
		//프레임의 시작위치를 잡겠다
		this.setLocation(300, 100);
		//프레임의 너비 높이
		this.setSize(300, 300);
		
		//this.getContentPane().setBackground(Color.GREEN);//color상수 이용 변경
		this.getContentPane().setBackground(new Color(200,255,180));//rgb값 이용 변경
		
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
