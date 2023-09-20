package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex4_ServerChat extends JFrame implements Runnable {
	JTextArea area;

	Vector<ClientMember> listMember=new Vector<ClientMember>();

	public Ex4_ServerChat() {
		super("채팅서버");
		this.setBounds(700, 100, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign();
		this.setVisible(true);

	}
	
	

	class ClientMember extends Thread
	{
		Socket mySocket;
		BufferedReader br;
		PrintWriter pw;
		String nickName;

		public ClientMember(Socket socket) {
			mySocket=socket;
			InputStream is=null;

			try {
				is=mySocket.getInputStream();
				br=new BufferedReader(new InputStreamReader(is));
				pw=new PrintWriter(mySocket.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}


		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true)
			{

				try {
					String message=br.readLine();
					String []arr=message.split("\\|");

					switch(arr[0])
					{
					case "1":
						this.nickName=arr[1];

						for(ClientMember mem:listMember)
						{
							mem.pw.println(this.nickName+">>님이 입장하셨습니다\n");
							mem.pw.flush();
						}
						break;
					case "2":


						for(ClientMember mem:listMember)
						{
							mem.pw.println(this.nickName+">>"+arr[1]+"\n");
							mem.pw.flush();
						}
						break;	
					}
				}catch(IOException|ArrayIndexOutOfBoundsException e) {

				}
			}



		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ServerSocket serverScoket=null;
		
		
			try {
				serverScoket=new ServerSocket(6000);
				area.append("서버 소켓 생성 성공\n");
				
				while(true)
				{
					Socket socket=serverScoket.accept();
					ClientMember clientMember=new ClientMember(socket);
					listMember.add(clientMember);
					clientMember.start();
					
					area.append("접속 허용 ip"+socket.getInetAddress().getHostAddress()+"\n");
					this.autoScroll();
				}
			} catch (IOException e) {
				area.append("서버 소켓 생성 실패:"+e.getMessage());
			}
		
	}

	public void autoScroll()
	{
		int n=area.getDocument().getLength();
		area.setCaretPosition(n);
	}
	
	private void setDesign() {
		area=new JTextArea();
		this.add(new JScrollPane(area));
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex4_ServerChat serverChat=new Ex4_ServerChat();
		
		Thread th=new Thread(serverChat);
		th.start();

	}

	



}
