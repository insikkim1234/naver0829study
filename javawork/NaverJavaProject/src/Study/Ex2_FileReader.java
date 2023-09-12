package Study;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex2_FileReader {
	static final String FILENAME="D:\\naver0829/memostudy1.txt";


	public static void main(String[] args) throws IOException {
		FileReader fr=null;
		BufferedReader br=null;
		
		try {
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);
			
			while(true)
			{
				String line=br.readLine();
				
				if(line==null)
				{
					break;
				}
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("해당 파일을 찾을수 없어요"+e.getMessage());
		}
		
		br.close();
		fr.close();
		

	}

}
