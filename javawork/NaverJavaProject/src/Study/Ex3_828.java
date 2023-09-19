package Study;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ex3_828 {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		InetAddress local=InetAddress.getLocalHost();
		System.out.println("내 컴퓨터의 아이피주소:"+local.getHostAddress()+","+local.getHostName());
		System.out.println("내 컴퓨터의 이름: "+local.getHostName());
		
		InetAddress []naverArr=InetAddress.getAllByName("www.naver.com");
		for(InetAddress inet:naverArr)
			System.out.println("naver의 서버아이피"+inet.getHostAddress());
		
		InetAddress []googleArr=InetAddress.getAllByName("www.google.com");
		for(InetAddress inet:googleArr)
			System.out.println("google의 서버아이피"+inet.getHostAddress());
		
		InetAddress []nateArr=InetAddress.getAllByName("www.nate.com");
		for(InetAddress inet:nateArr)
			System.out.println("nate의 서버아이피"+inet.getHostAddress());

	}

}
