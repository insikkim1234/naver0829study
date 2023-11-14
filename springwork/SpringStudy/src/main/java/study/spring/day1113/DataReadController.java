package study.spring.day1113;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DataReadController {
	
	@GetMapping("/process1")
	public String process1(Model model,
			@RequestParam("name") String irum,
			@RequestParam String addr,
			@RequestParam int age)
	{
		
		model.addAttribute("irum", irum);
		model.addAttribute("addr", addr);
		model.addAttribute("age", age+"���� "+(age>20?"����":"����")+"�Դϴ�");
		
		
		return "result1";
	}
	//(14)form2.jsp���� ���۹�ư ������ ���μ���
	@PostMapping("/process2")
	public String process1(Model model,
			//�Է¹��� �޽���,�������� �ޱ�
			//name�� ������(required=false) �ٴϿ��� �ϰڴ�(���� �ȵ�� ������ �������� ����)
			@RequestParam String message,
			@RequestParam String animal,
			@RequestParam(defaultValue="�ٴϿ�",required=false) String name)
	{
		//(15)message,animal,name �ް� ���� �𵨿� ����
		System.out.println(name);
		
		model.addAttribute("name", name);
		model.addAttribute("message", message);
		model.addAttribute("animal", animal);
		
		//(16)result2��ȯ
		return "result2";
	}
	
	//(20)form3.jsp���� ���۹�ư�� ������ ���μ���
	//�Է°����� �� �ޱ�
	//ShopDto�� �Է¹����� dto�� �ޱ�
	//���ó�¥�� �Է¹����� today�� �ޱ�
	@PostMapping("/process3")
	public String process3(Model model,@ModelAttribute ShopDto dto,
			@RequestParam String today)
	{
		//(21)today�� �𵨿� ����(���������� dto�� ó���Ұ���)
		model.addAttribute("today", today);
		//(22) result3��ȯ
		return "result3";
	}
	
	//(25)form4.jsp���� ���۹�ư ������ ���μ���
	//�Է°����� �� �ޱ�
	//������ ������ �Է¹����� Map������� map���� �ޱ�  
	@PostMapping("/process4")
	public String process4(Model model,@RequestParam Map<String,String> map)
	{
		//(26) map�� ��ǰ,��,�ܰ�,����,����,���ó�¥�� Ű:�����·� �����ϱ�
		model.addAttribute("sang", map.get("sang"));
		model.addAttribute("su", map.get("su"));
		model.addAttribute("dan", map.get("dan"));
		model.addAttribute("color", map.get("color"));
		model.addAttribute("photo", map.get("photo"));
		model.addAttribute("today", map.get("today"));
		//(27)result4��ȯ
		
		return "result4";
	}
	

}
