package bit701.day0915;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Paint;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ex7_Canvas extends JFrame {
	//캠버스를 멤버변수로 사용
	MyCanvas myCanvas=new MyCanvas();
	//스윙기본 만드는 생성자(인자로 지우는바 위에 있는 이름을 받음
	public Ex7_Canvas(String title)
	{
		//제이프레임의 title 입력하고 출력
		super(title);
		//프레임의 시작위치를 잡겠다
		this.setLocation(300, 100);
		//프레임의 너비 높이
		this.setSize(500,500);
		
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
				// TODO Auto-generated method stub
				//JOptionPane.showMessageDialog(SwingGibon.this, "프레임을 종료합니다");
				//실제 종료
				System.exit(0);//정상 종료시
				super.windowClosing(e);
			}
		});
	}
	
	//캔바스 내부 클래스
	class MyCanvas extends Canvas
	{
		String imageIcon1="D:\\naver0829\\workstudy\\webwork\\이쁜동물이미지\\C7.png";
		public void paint(Graphics g) {
			super.paint(g);
			//원그리기
			g.setColor(new Color(255,100,255));//선색
			g.drawOval(50, 50, 100, 100);//테두리선만 있는 원
			
			//채워진원
			g.setColor(Color.orange);
			g.fillOval(200, 50, 100, 100);
			
			//테두리만 있는 사각형
			g.setColor(Color.GREEN);
			g.drawRect(50, 200, 100, 100);
			
			//채워진 사각형
			g.setColor(Color.pink);
			g.fillRect(200, 200, 100, 100);
			
			//이미지
			Image image1=new ImageIcon(imageIcon1).getImage();
			//이미지 그리기
			g.drawImage(image1, 300, 200, this);
			//크기변경해서 출력
			g.drawImage(image1,300,30,100,100,this);
			
			
		}
	}

	private void setDesign() {
		// TODO Auto-generated method stub
		this.add("Center",myCanvas);
		
	}

	public static void main(String[] args) {
		Ex7_Canvas s=new Ex7_Canvas("캔버스");
		

	}

}
