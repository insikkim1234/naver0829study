package Study;

import java.io.FileWriter;
import java.io.IOException;

public class Ex1_FileWriter {
	static final String FILENAME="D:\\naver0829/memostudy1.txt";

	public static void main(String[] args) throws IOException {
		FileWriter fw=null;
		
		fw=new FileWriter(FILENAME,true);
		
		fw.write("이름: 김인식\n");
		fw.write("폰:010-2323-4545\n");
		fw.write("--------------\n");
		
		fw.close();
		System.out.println("탐색기를 열고 memo2.txt파일 확인");
		

	}

}
