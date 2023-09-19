package bit701.day0919;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ex3_Book828_Network {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		//inetaddress 자동완성
		//컨1로 throw
		//내컴퓨터의 아이피 주소와 컴이름을 알고자 하는 경우
		InetAddress local=InetAddress.getLocalHost();
		System.out.println("내 컴퓨터의 ip주소:"+local.getHostAddress());
		System.out.println("내 컴퓨터의 이름: "+local.getHostName());

		//naver 서버의 ip를 알고자 할경우
		InetAddress []naverArr=InetAddress.getAllByName("www.naver.com");
		for(InetAddress inet:naverArr)
			System.out.println("naver의 서버 IP:"+inet.getHostAddress());

		//google 서버의 ip를 알고자 할경우
		InetAddress []googleArr=InetAddress.getAllByName("www.google.com");
		for(InetAddress inet:googleArr)
			System.out.println("google의 서버 IP:"+inet.getHostAddress());

		//nate 서버의 ip를 알고자 할경우
		InetAddress []nateArr=InetAddress.getAllByName("www.nate.com");
		for(InetAddress inet:nateArr)
			System.out.println("nate의 서버 IP:"+inet.getHostAddress());

	}

}
