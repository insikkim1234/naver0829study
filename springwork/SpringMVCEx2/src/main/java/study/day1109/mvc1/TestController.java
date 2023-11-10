package study.day1109.mvc1;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//(1)@Controller �̿��� �ڵ����� �������Ͽ� bean�� ��ϵǵ��� �Ѵ�
@Controller 
public class TestController {
	
	//(2)@GetMapping ����� �̿��Ͽ� ������ �޽���,���� �ð� ���� (������ ����5���� ������ ������̼�)
	//�̶� home�� ���� ���� �ƹ��̸��̳� �ᵵ ������� 
	@GetMapping("/") 
	public String home(Model model)
	{
		model.addAttribute("message","have a good time");//request�� ����
		model.addAttribute("today",new Date());
		return "result1";
	}
	
	//(3)���� ��θ� ���� �����ϴµ� {}�� �̿��Ͽ� path1�� �Ѿ�� url���� �д´�
	//�̶� go�� ���� ���� �ƹ� �̸��̳� �ᵵ �������
	//@GetMapping("/shop/list.do") //  /shop/list.* ��� ȣ�Ⱑ��
	//@GetMapping("/shop/list.do") //shop/list.do�� ȣ�Ⱑ��
	@GetMapping("/shop/{path1}")	
	public String go(Model model,@PathVariable("path1") String p1)
	{
		System.out.println(p1);
		model.addAttribute("path","/shop/"+p1);
		return "list";
	}
	
	
	//(4)�ΰ��� ������ ���������� �������ǵ��� �Ѵ�
	//hello�� ���� ���� �ƹ� �̸��̳� �������
	@GetMapping({"/board/update","/stu/form/test1"}) 
	public ModelAndView hello(HttpServletRequest request)
	{
		//(5)������Ʈ ������� ��θ� ��´�
		String root=request.getContextPath();
		System.out.println(root);
		
		//(6)mview�� �������� ������ �����ϰ� ����
		ModelAndView mview=new ModelAndView();
		mview.addObject("message","�����ּҷ� ������ ��Ÿ������");
		mview.addObject("root",root);
		mview.setViewName("result2");
		return mview;
	}
	//(7)servlet-context.xml�� 
	/*
	 * <resources mapping="/res/**" location="/resources/" /> <resources
	 * mapping="/photo/**" location="/WEB-INF/photo/" />
	 */ 
	//�����ϱ�
	//���� (8)���� list.jsp�� �̵�
}	

















