package data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import naver.storage.NcpObjectStorageService;

//(55)StorageRestController�� PhotoStorageController �� �⺻���� ����
//@Autowired
//private NcpObjectStorageService storageService;
//
//private String bucketName="bitcamp-lmh";//���� �ڱ� ���� �̸�(����԰�)
//private String bucketFolder="photo";//���� ���� ����
@RestController
public class StorageRestController {
	@Autowired
	private NcpObjectStorageService storageService;
	
	private String bucketName="bitcamp-lmh";//���� �ڱ� ���� �̸�(����԰�)
	private String bucketFolder="photo";//���� ���� ����
	
	String fileName;
	//(68)StorageRestController�� @PostMapping("/storage/addphoto")�� �����ϰ�
	//���丮���� ���ε� �� photo80����ȯ �� �ִ� �Լ� �ۼ�
	@PostMapping("/storage/addphoto")
		//1)upload�� ���ڷ� �ޱ�
	public String addPhoto(@RequestParam MultipartFile upload)
	{
		//2)���丮���� ���ε�
		fileName=storageService.uploadFile(bucketName, bucketFolder, upload);
		//3)photo80�� 80X80���� ������ִ� ���̹�Ŭ���忡�� ���� ������ ����
		String photo80="https://fr2k01411649.edge.naverncp.com/82uyvvqSQa/photo/"+fileName+"?type=f&w=80&h=80&faceopt=true&ttype=jpg";
		//4)photo80�� ��ȯ�Ͽ� �����̹��� ���
		return photo80;
	}
	//(69)�� �Ѱ� ���� �����ؼ� ���ε� �ƴ� �� Ȯ���ϱ�(������ ����� ��� ���������� ����ȴ�)
}
