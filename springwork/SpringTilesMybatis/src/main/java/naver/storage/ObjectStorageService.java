package naver.storage;

import org.springframework.web.multipart.MultipartFile;

//(44)�������̽� ���� �⺻Ʋ ������� 
//import org.springframework.web.multipart.MultipartFile;
//
//public interface ObjectStorageService {
//	public String uploadFile(String bucketName,String directoryPath,MultipartFile file);
//	public void deleteFile(String bucketName,String directoryPath,String fileName);	
//}
//����
public interface ObjectStorageService {
	public String uploadFile(String bucketName,String directoryPath,MultipartFile file);
	public void deleteFile(String bucketName,String directoryPath,String fileName);	
	
}
