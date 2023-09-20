package Study;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex4_ClientChat extends JFrame implements Runnable,ActionListener{
	String nickName;
	JTextArea area;
	JTextField tfNickName,tfMessage,tfServerIp;
	JButton btnSend,btnConnect;
	Socket clientSocket;
	
	BufferedReader br;
	PrintWriter pw;
	
	public Ex4_ClientChat() {
		this.setBounds(1000,100,400,400);
		this.setDesign();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		
		if(ob==tfMessage||ob==btnSend)
		{
			pw.println("2|"+tfMessage.getText()+"\n");
			pw.flush();
			
			tfMessage.setText("");
			tfMessage.requestFocus();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			clientSocket=new Socket(tfServerIp.getText(),6000);
			InputStream is=null;
			
			
			is=clientSocket.getInputStream();
			br=new BufferedReader(new InputStreamReader(is));
			pw=new PrintWriter(clientSocket.getOutputStream());
			
			area.append("서버 접속 성공\n");
			
			pw.println("1|"+nickName+"\n");
			pw.flush();
			
			while(true)
			{
				String message=br.readLine();
				area.append(message+"\n");
				this.autoScroll();
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("서버 접속 실패:"+e.getMessage()+"\n");
		}
		
	}
	
	private void setDesign() {
		JPanel pTop=new JPanel();
		tfNickName=new JTextField("김인식",5);
		tfServerIp=new JTextField("192.168.0.235");
		btnConnect=new JButton("서버접속");
		
		pTop.add(new JLabel("닉네임:"));
		pTop.add(tfNickName);
		pTop.add(tfServerIp);
		pTop.add(btnConnect);
		
		this.add("North",pTop);
		
		JPanel pBottom=new JPanel();
		tfMessage=new JTextField(25);
		btnSend=new JButton("전송");
		
		pBottom.add(tfMessage);
		pBottom.add(btnSend);
		
		this.add("South",pBottom);
		
		area=new JTextArea();
		this.add("Center",new JScrollPane(area));
		
		btnConnect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				nickName=tfNickName.getText();
				
				Ex4_ClientChat.this.setTitle(nickName+"님채팅창");
				
				Thread th=new Thread(Ex4_ClientChat.this);
				th.start();
				
			}
		});
		
		tfMessage.addActionListener(this);
		btnSend.addActionListener(this);
		
	}
	
	public void autoScroll()
	{
		int n=area.getDocument().getLength();
		area.setCaretPosition(n);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex4_ClientChat client=new Ex4_ClientChat();
	}

}
