package bit701.day0912;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex2_FileReader {
	static final String FILENAME="D:\\naver0829/memo1.txt";

	public static void main(String[] args) throws IOException {
		FileReader fr=null;//자동완성
		BufferedReader br=null;//자동완성 한줄씩 읽는 내용을 구현하기 위해 생성
		
		try {
			fr=new FileReader(FILENAME);//줄단위로 읽는 맴버메서드가 없다 그래서 2차 생성을 하겠다
			br=new BufferedReader(fr);
			
			//br.readLine()이 한줄씩 읽는다 그런데 더이상 읽을 내용이 없을경우 null값을 반환
			//대부분 두줄 이상이고 몇줄이 저장되어 있는지 모르므로 while문으로 처리한다
			while(true)
			{
				//파일의 내용을 한줄씩 읽는다
				String line=br.readLine();//이때 예외때문에 오류뜨므로 컨1눌러서 처리
				//더이상 읽을 내용이 없을 경우 while문 종료 그렇지 않으면 출려
				if (line==null)
				{
					break;
				}
				System.out.println(line);
			}
			
			
		} 
		catch (FileNotFoundException e) {
			//해당 파일이 없을 경우 예외가 발생하며 캐치영역이 실행된다
			System.out.println("해당 파일을 찾을수 없어요"+e.getMessage());
		}//파일리더 친후 트라이캣치
		
		//열려있는 자원을 닫는다 fr br 닫는순서는 br fr
		br.close();
		fr.close();

	}

}
