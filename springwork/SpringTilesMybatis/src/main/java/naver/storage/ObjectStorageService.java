package naver.storage;

import org.springframework.web.multipart.MultipartFile;

//(44)인터페이스 관련 기본틀 다지우고 
//import org.springframework.web.multipart.MultipartFile;
//
//public interface ObjectStorageService {
//	public String uploadFile(String bucketName,String directoryPath,MultipartFile file);
//	public void deleteFile(String bucketName,String directoryPath,String fileName);	
//}
//복붙
public interface ObjectStorageService {
	public String uploadFile(String bucketName,String directoryPath,MultipartFile file);
	public void deleteFile(String bucketName,String directoryPath,String fileName);	
	
}
