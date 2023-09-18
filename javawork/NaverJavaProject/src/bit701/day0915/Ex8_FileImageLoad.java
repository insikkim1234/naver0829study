package bit701.day0915;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex8_FileImageLoad extends JFrame {
	JButton btnImageFile;
	String initImage="D:\\naver0829\\workstudy\\webwork\\연예인사진\\20.jpg";
	Image image;
	
	MyCanvas myCanvas=new MyCanvas();
	
	public Ex8_FileImageLoad(String title)
	{
		//제이프레임의 title 입력하고 출력
		super(title);
		//프레임의 시작위치를 잡겠다
		this.setLocation(300, 100);
		//프레임의 너비 높이
		this.setSize(500, 600);
		
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
	
	//캔바스 내부클래스
	class MyCanvas extends Canvas
	{//패인트 오버라이드
		//패인트는 처음 시작시 자동호출,그리고 프레임 크기변경시에도 자동호출
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			//System.out.println(image.getWidth(this));
			if(image.getWidth(this)>=300)
				g.drawImage(image, 60, 10, 400, 450, this);
			else//300미만 너비를 가진 이미지는 원래 사이즈대로 출력
				g.drawImage(image, 60, 10, this);
		}
	}

	private void setDesign() {
		// TODO Auto-generated method stub
		
		//상단에는 패널안에 버튼 추가후 프레임에 패널 추가
		JPanel p=new JPanel();
		btnImageFile=new JButton("이미지파일 가져오기");
		p.add(btnImageFile);
		this.add("North",p);
		
		//tㅏ진을 이미지로 변화
		image=new ImageIcon(initImage).getImage();
		this.add("Center",myCanvas);
		
		//파일 버튼 이벤트
		btnImageFile.addActionListener(new ActionListener() {//액션리스너 오버라이드
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//이미지파일 가져오기
				FileDialog dlg=new FileDialog(Ex8_FileImageLoad.this,"이미지열기",FileDialog.LOAD);
				dlg.setVisible(true);
				//취소시 종료
				if(dlg.getDirectory()==null)
					return;
				
				//파일 경로와 파일명 가져요기
				initImage=dlg.getDirectory()+dlg.getFile();
				//image 생성
				image=new ImageIcon(initImage).getImage();
				
				//캔버스의 패인트 메서드는 버튼을 누른다고 자동호출되지않음
				//따라서 사진을 바꿔도 크기를 늘려야 변함
				//강제 호출해줘야함
				myCanvas.repaint();
				
			}
		});
	}

	public static void main(String[] args) {
		Ex8_FileImageLoad s=new Ex8_FileImageLoad("이미지뷰어");//괄호안에 입력시 제목 입력가능
		//근데 여기 이대로면 에러뜸 public SwingGibon에 String title 써줘야함
		

	}

}
