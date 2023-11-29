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
//(159)guestcontroller.java에
	//1)*기본세팅*
@Controller
public class GuestController {
	
	@Autowired
	private GuestService guestService;
	@Autowired
	private NcpObjectStorageService storageService;
	//ncp연결
	private String bucketName="bitcamp-kis";
	private String folderName="guest";
	
	//(176)GuestController.java에 번역 후 반환하는 메서드 네클에서  복붙
	public String translate(String text1,String nara)
	{
		//1)클라아이디,시크릿 위에서 얻어온것 그대로 작성
        String clientId = "5ljkq2jdwb";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "ctx7MYzaZvlM6ue2r8lgqgIVWmZDgc7CnN2kNFdt";//애플리케이션 클라이언트 시크릿값";
        //2)String returnValue="";생성
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
            if(responseCode==200) { // 정상 호출
            	br = new BufferedReader(new InputStreamReader(con.getInputStream(),StandardCharsets.UTF_8));
            } else {  // 오류 발생
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
        return returnValue;//번역된 내용

	}
	
	//(9)GuestController에 @GetMapping("/guest/list")매핑 후 guest/guestlist반환
	@GetMapping("/guest/list")
	public String login(Model model, @RequestParam(defaultValue = "en") String nara)//nara는 기본 번역언어는 영어
	{
		//1)모든 게스트의 인원수를 구함
		int totalCount=guestService.getAllGuest().size();
		//2)모든 게스트를 리스트로 만듬
		List<GuestDto> glist=guestService.getAllGuest();
		//3)dto에 반복문을 이용하여 번역내용 저장
		for(GuestDto dto:glist)
		{
			//해당 나라 언어로 번역해서 반환
			String trans=translate(dto.getGuest_content(),nara);
			dto.setTrans_lang(trans);
		}
		//4)totalCount,glist를 모델에 추가
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("glist", glist);
		
		//5)guest/guestlist반환
		return "guest/guestlist";
	}
	//(159)2)@GetMapping("/guest/insert") 매핑하고 작성
	@PostMapping("/guest/insert")
		//1.dto와 upload를 인자로 받기
	public String insertGuest(@ModelAttribute GuestDto dto,
			@RequestParam MultipartFile upload,
			@RequestParam String nara)
	{
		//2.네이버 스토리지에 업로드 후 랜덤 파일명 변환
		String guest_photo=storageService.uploadFile(bucketName, folderName, upload);
		//3.dto에 사진 파일명 저장
		dto.setGuest_photo(guest_photo);
		
		//4.db에 insert
		guestService.insertGuest(dto);
		
		//5./guest/list로 리다이렉트
		return "redirect:./list?nara="+nara;
	}
	
	//목소리 반환하는 메서드
	@GetMapping("/guest/voice")
	@ResponseBody public String getVoice(String message,
			String lang,
			HttpServletRequest request)
	{
		//목소리 파일을 업로드할 경로 구하기
		String path=request.getSession().getServletContext().getRealPath("/resources/voice");
		System.out.println(path);
		
		
		 String clientId = "aqjvq3ve06";//내 애플리케이션 클라이언트 아이디값";
	        String clientSecret = "lKKumzuWC4iWXR4GgMNyFJxdsXTQxLjmTtqMUtwE";//내 애플리케이션 클라이언트 시크릿값";
	        try {
	            String text = URLEncoder.encode(message, "UTF-8"); // 13자
	            String apiURL = "https://naveropenapi.apigw.ntruss.com/tts-premium/v1/tts";
	            URL url = new URL(apiURL);
	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            con.setRequestMethod("POST");
	            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
	            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
	            // post request
	            //나라별 목소리 지정
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
	            if(responseCode==200) { // 정상 호출
	                InputStream is = con.getInputStream();
	                int read = 0;
	                byte[] bytes = new byte[1024];
	                // 랜덤한 이름으로 mp3 파일 생성
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
	            } else {  // 오류 발생
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


