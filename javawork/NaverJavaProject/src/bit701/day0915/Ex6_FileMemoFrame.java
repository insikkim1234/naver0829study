package bit701.day0915;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex6_FileMemoFrame extends JFrame {
	JTextArea memoArea;
	JButton btnSave,btnOpen,btnClear;//1


	public Ex6_FileMemoFrame(String title)
	{
		super(title);
		this.setLocation(300, 100);//프레임의 시작위치를 잡겠다
		this.setSize(500, 600);//프레임의 너비 높이

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
		//2 버튼 묶기
		btnSave=new JButton("파일저장");
		btnOpen=new JButton("파일열기");
		btnClear=new JButton("파일지우기");

		//컨스페(판넬로 버튼 3개를한개로 묶기)
		JPanel p=new JPanel();
		p.add(btnSave);
		p.add(btnOpen);
		p.add(btnClear);

		//panel을 north에 추가
		this.add(p,"North");
		//메모 부분에 내용 입력해 보라고 기본 내용을 출력
		memoArea=new JTextArea("내용을 입력해 보세요");
		//this.add(memoArea,"Center");//데이터가 길경우 스크롤바가 안생김
		//스크롤바가 생김(내용이 넘칠때만) jscrollpane 컨스페 해주기
		this.add(new JScrollPane(memoArea),"Center");

		//버튼 :내용지우기
		//액션리스너에 컨스페 오버라이드
		//메모부분을 ""으로 초기화
		btnClear.addActionListener(new ActionListener() {//액션리스너에서 컨스

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				memoArea.setText("");

			}
		});

		//버튼:파일저장
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FileDialog dlg=new FileDialog(Ex6_FileMemoFrame.this, "메모장저장", FileDialog.SAVE);
				dlg.setVisible(true);
				System.out.println("디레토리:"+dlg.getDirectory());
				System.out.println("파일명:"+dlg.getFile());

				//취소시 메서드 종료
				if(dlg.getDirectory()==null)
					return;

				String fileName=dlg.getDirectory()+dlg.getFile()+".txt";
				String memoText=memoArea.getText();//저장할 내용

				FileWriter fw=null;
				try {
					fw=new FileWriter(fileName);
					//내용 저장
					fw.write(memoText);
					//메모장에 메시지 넣기
					memoArea.setText("저장되었습니다");
				} catch (IOException e1) {
					// TODO Auto-generated catch block

					System.out.println("메모장 저장하다가 오류가 났네요!"+e1.getMessage());
				}finally 
				{
					try {
						fw.close();

					}catch (NullPointerException|IOException e1) {
						// 클로즈시 나올만한 오류 두개

					}
				}



			}
		});

		//버튼:파일열기
		btnOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//파일 오픈하는 생성자
				FileDialog dlg=new FileDialog(Ex6_FileMemoFrame.this, "파일열기", FileDialog.LOAD);
				//파일을 보이게함
				dlg.setVisible(true);
				//디렉토리와 파일 이름을 출력
				System.out.println("디레토리:"+dlg.getDirectory());
				System.out.println("파일명:"+dlg.getFile());

				//취소시 메서드 종료
				if(dlg.getDirectory()==null)
					return;
				
				//디렉토리와 파일명을 조합하여 파일 이름으로 바꾸자
				String fileName=dlg.getDirectory()+dlg.getFile();

				//파일리더 실행
				FileReader fr=null;
				BufferedReader br=null;
				try {
					fr=new FileReader(fileName);
					br=new BufferedReader(fr);
					
					//메모장의 기본 내용 지우기
					memoArea.setText("");
					
					
					while(true)
					{
						String line=br.readLine();
						if(line==null)
							break;
						
						memoArea.append(line+"\n");
					}

				} catch (IOException e1) {
					// TODO Auto-generated catch block


				}finally 
				{
					try {
						br.close();
						fr.close();

					}catch (NullPointerException|IOException e1) {
						e1.printStackTrace();

					}
				}



			}
		});






	}

	public static void main(String[] args) {
		Ex6_FileMemoFrame s=new Ex6_FileMemoFrame("간단한 메모장");//괄호안에 입력시 제목 입력가능
		//근데 여기 이대로면 에러뜸 public SwingGibon에 String title 써줘야함


	}

}

