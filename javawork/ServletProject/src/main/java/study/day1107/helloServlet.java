package study.day1107;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hello.do")

public class helloServlet extends HttpServlet {
	//doget,dopost모두 남기고 삭제
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//url 주소 실행
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//request에 각종 정보 저장
		
		//result1.jsp로 포워딩(url 주소유지,request response그대로 유지
		
		List<String> list=new ArrayList<String>();
		list.add("red");
		list.add("green");
		list.add("magenta");
		list.add("orange");
		list.add("blue");
		
		request.setAttribute("list", list);
		request.setAttribute("today", new Date());
		request.setAttribute("message","have a good day!!!");
		
		//result1.jsp로 포워드
		RequestDispatcher rd=request.getRequestDispatcher("./day1107/result1.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
