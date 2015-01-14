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
		
		/* Success �������� ���� �̵�
		 * 1. get���? post������� �̵�?
		 * 	- 
		 * 2. servlet ���� �ҽ� �� ���� �̵��� � ������� �̵�?
		 * 	- ���ݱ����� �⺻ �ڹ� ������ �޸� �ܼ� �޼ҵ� ȣ�� �ǹ��ϴ°� �ƴ�
		 * 	- ***
		 * 		�ҽ� �����̵� = page�̵����� ����
		 * 		page�̵� API �н� - Servlet API
		 * 3. �̵��� servlet���� ���ο� ������ ����
		 */
		if(id.equals("tester") && pw.equals("11")){
			String no = request.getParameter("no");
			
			//���� �޽��� ��� ȭ������ �̵�
			//Servlet API�� Ȱ���� �ҽ� ���� �̵�
			//�̵��� servlet ����
			RequestDispatcher pageMoveAPI = request.getRequestDispatcher("succ");
			//���� �̵� ����
			if(no.equals("1")){
				request.setAttribute("allData",Data.getPeopleDTO());
			}else if(no.equals("2")){
				request.setAttribute("oneData",Data.getMapDatas());
			}else{
				request.setAttribute("nullData", "�����Ͱ� �����ϴ�.");
			}
			pageMoveAPI.forward(request, response);
			
		}else{
			//Servlet ALI�� Ȱ���� �ҽ� ���� �̵�
			//�̵��� servlet ���� & ���� �̵� ����
			//���� �޽��� ��� ȭ������ �̵�
			response.sendRedirect("fa");	//http://ip:port/step02_ServletAPI/fa
		}
	}
}