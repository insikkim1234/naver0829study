package mini.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import mini.dto.GuestDto;
import mini.service.GuestService;
import naver.storage.NcpObjectStorageService;

import java.io.*;

import java.util.Date;
//(159)guestcontroller.java��
	//1)*�⺻����*
@Controller
public class GuestController {
	
	@Autowired
	private GuestService guestService;
	@Autowired
	private NcpObjectStorageService storageService;
	//ncp����
	private String bucketName="bitcamp-kis";
	private String folderName="guest";
	
	//(176)GuestController.java�� ���� �� ��ȯ�ϴ� �޼��� ��Ŭ����  ����
	public String translate(String text1,String nara)
	{
		//1)Ŭ����̵�,��ũ�� ������ ���°� �״�� �ۼ�
        String clientId = "5ljkq2jdwb";//���ø����̼� Ŭ���̾�Ʈ ���̵�";
        String clientSecret = "ctx7MYzaZvlM6ue2r8lgqgIVWmZDgc7CnN2kNFdt";//���ø����̼� Ŭ���̾�Ʈ ��ũ����";
        //2)String returnValue="";����
        String returnValue="";
        try {
        //3)text->text1    
        	String text = URLEncoder.encode("text1", "UTF-8");
            String apiURL = "https://naveropenapi.apigw.ntruss.com/nmt/v1/translation";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
        //4)String postParams = "source=ko&target="+nara+"&text=" + text;
            String postParams = "source=ko&target="+nara+"&text=" + text;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // ���� ȣ��
            	br = new BufferedReader(new InputStreamReader(con.getInputStream(),StandardCharsets.UTF_8));
            } else {  // ���� �߻�
            	br = new BufferedReader(new InputStreamReader(con.getErrorStream(),StandardCharsets.UTF_8));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            
            JSONObject ob=new JSONObject(response.toString());
            JSONObject result=ob.getJSONObject("message").getJSONObject("result");
        } catch (Exception e) {
            System.out.println(e);
        }
        return returnValue;//������ ����

	}
	
	//(9)GuestController�� @GetMapping("/guest/list")���� �� guest/guestlist��ȯ
	@GetMapping("/guest/list")
	public String login(Model model, @RequestParam(defaultValue = "en") String nara)//nara�� �⺻ �������� ����
	{
		//1)��� �Խ�Ʈ�� �ο����� ����
		int totalCount=guestService.getAllGuest().size();
		//2)��� �Խ�Ʈ�� ����Ʈ�� ����
		List<GuestDto> glist=guestService.getAllGuest();
		//3)dto�� �ݺ����� �̿��Ͽ� �������� ����
		for(GuestDto dto:glist)
		{
			//�ش� ���� ���� �����ؼ� ��ȯ
			String trans=translate(dto.getGuest_content(),nara);
			dto.setTrans_lang(trans);
		}
		//4)totalCount,glist�� �𵨿� �߰�
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("glist", glist);
		
		//5)guest/guestlist��ȯ
		return "guest/guestlist";
	}
	//(159)2)@GetMapping("/guest/insert") �����ϰ� �ۼ�
	@PostMapping("/guest/insert")
		//1.dto�� upload�� ���ڷ� �ޱ�
	public String insertGuest(@ModelAttribute GuestDto dto,
			@RequestParam MultipartFile upload,
			@RequestParam String nara)
	{
		//2.���̹� ���丮���� ���ε� �� ���� ���ϸ� ��ȯ
		String guest_photo=storageService.uploadFile(bucketName, folderName, upload);
		//3.dto�� ���� ���ϸ� ����
		dto.setGuest_photo(guest_photo);
		
		//4.db�� insert
		guestService.insertGuest(dto);
		
		//5./guest/list�� �����̷�Ʈ
		return "redirect:./list?nara="+nara;
	}
	
	//��Ҹ� ��ȯ�ϴ� �޼���
	@GetMapping("/guest/voice")
	@ResponseBody public String getVoice(String message,
			String lang,
			HttpServletRequest request)
	{
		//��Ҹ� ������ ���ε��� ��� ���ϱ�
		String path=request.getSession().getServletContext().getRealPath("/resources/voice");
		System.out.println(path);
		
		
		 String clientId = "aqjvq3ve06";//�� ���ø����̼� Ŭ���̾�Ʈ ���̵�";
	        String clientSecret = "lKKumzuWC4iWXR4GgMNyFJxdsXTQxLjmTtqMUtwE";//�� ���ø����̼� Ŭ���̾�Ʈ ��ũ����";
	        try {
	            String text = URLEncoder.encode(message, "UTF-8"); // 13��
	            String apiURL = "https://naveropenapi.apigw.ntruss.com/tts-premium/v1/tts";
	            URL url = new URL(apiURL);
	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            con.setRequestMethod("POST");
	            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
	            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
	            // post request
	            //���� ��Ҹ� ����
	            String naraVoice="";
	            if(lang.equals("ko"))
	            	naraVoice="nminsang";
	            else if(lang.equals("en"))
	            	naraVoice="matt";
	            else if(lang.equals("ja"))
	            	naraVoice="dtomoko";
	            else if(lang.equals("zh-CN"))
	            	naraVoice="liangliang";
	            else if(lang.equals("es"))
	            	naraVoice="jose";
	            
	            String postParams = "speaker="+naraVoice+"&volume=0&speed=0&pitch=0&format=mp3&text=" + text;
	            con.setDoOutput(true);
	            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	            wr.writeBytes(postParams);
	            wr.flush();
	            wr.close();
	            int responseCode = con.getResponseCode();
	            BufferedReader br;
	            if(responseCode==200) { // ���� ȣ��
	                InputStream is = con.getInputStream();
	                int read = 0;
	                byte[] bytes = new byte[1024];
	                // ������ �̸����� mp3 ���� ����
	               // String tempname = Long.valueOf(new Date().getTime()).toString();
	                String tempname=Long.valueOf(new Date().getTime()).toString();
	                File f = new File(path+"/newvoice.mp3");
	                f.createNewFile();
	                OutputStream outputStream = new FileOutputStream(f);
	                while ((read =is.read(bytes)) != -1) {
	                    outputStream.write(bytes, 0, read);
	                }
	                is.close();
	                return tempname+".mp3";
	            } else {  // ���� �߻�
	                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	                String inputLine;
	                StringBuffer response = new StringBuffer();
	                while ((inputLine = br.readLine()) != null) {
	                    response.append(inputLine);
	                }
	                br.close();
	                System.out.println(response.toString());
	            }
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        return "";
	    }
		
		
	}


