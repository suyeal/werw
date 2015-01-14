package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Data;
import model.domain.People;


public class LoginCheck extends HttpServlet { 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginCheck doGet()");
		process(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginCheck doPost()");
		process(request, response);
	}
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//id<input type = "text" name = "id">
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		/* Success 서블릿으로 실행 이동
		 * 1. get방식? post방식으로 이동?
		 * 	- 
		 * 2. servlet 간의 소스 즉 실행 이동은 어떤 방식으로 이동?
		 * 	- 지금까지의 기본 자바 문법과 달리 단순 메소드 호출 의미하는게 아님
		 * 	- ***
		 * 		소스 실행이동 = page이동으로 간주
		 * 		page이동 API 학습 - Servlet API
		 * 3. 이동된 servlet으로 새로운 데이터 전송
		 */
		if(id.equals("tester") && pw.equals("11")){
			String no = request.getParameter("no");
			
			//성공 메시지 출력 화면으로 이동
			//Servlet API를 활용한 소스 실행 이동
			//이동된 servlet 지정
			RequestDispatcher pageMoveAPI = request.getRequestDispatcher("succ");
			//실제 이동 수행
			if(no.equals("1")){
				request.setAttribute("allData",Data.getPeopleDTO());
			}else if(no.equals("2")){
				request.setAttribute("oneData",Data.getMapDatas());
			}else{
				request.setAttribute("nullData", "데이터가 없습니다.");
			}
			pageMoveAPI.forward(request, response);
			
		}else{
			//Servlet ALI를 활용한 소스 실행 이동
			//이동된 servlet 지정 & 실제 이동 수행
			//실패 메시지 출력 화면으로 이동
			response.sendRedirect("fa");	//http://ip:port/step02_ServletAPI/fa
		}
	}
}