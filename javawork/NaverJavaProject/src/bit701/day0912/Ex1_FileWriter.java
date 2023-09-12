package bit701.day0912;

import java.io.FileWriter;
import java.io.IOException;

public class Ex1_FileWriter {
	static final String FILENAME="D:\\naver0829/memo1.txt";//D:/naver0829와 동일

	public static void main(String[] args) throws IOException {
		//파일에 개인정보 저장하기(자동완성 포함)
		FileWriter fw=null;
		
		//생성
		fw=new FileWriter(FILENAME,true);//파일이 없으면 새로 생성하고 있으면 덮어쓰기
		//filewriter 부분에서 커서대고 컨트롤 1눌러서 메인함수에 익셉션 추가하기
		//true 있으면 실행시마다 기존파일에 추가
		//true 없으면 실행시마다 덮어쓰기
		
		
		//파일에 내용저장하기
		fw.write("이름:이효리\n");
		
		fw.write("폰:010-2323-4545\n");
		fw.write("--------------\n");
		
		//파일 닫기
		fw.close();
		System.out.println("탐색기를 열고 memo1.txt 파일을 확인하세요");
		
		//해당 위치에 가보면 확인가능하다

	}

}
