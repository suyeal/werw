package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Data;
import model.domain.People;


public class Success extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Success doGet()");
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Success doPost()");
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String no = request.getParameter("no");
		
	
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		if(no.equals("1")){
			ArrayList<People> all=(ArrayList<People>)request.getAttribute("allData");
			for(People p: all)
				out.println(p+"<br>");
		}
		else if(no.equals("2")){
			HashMap<String, String> one=(HashMap<String, String>)request.getAttribute("oneData");
			Iterator<String> keys=one.keySet().iterator();
			for(String key: one.keySet())
				out.println(key + " "+one.get(key));
		
			//out.println("m1" + " "+one.get("m1"));
			out.println("");
			
			}
		else{
			String not=(String)request.getAttribute("nullData");
			out.println(not);
		}
		
		
		out.println("<b>"+id+"<b>");
		out.println("æ»≥Á«œººø‰<br>");
		

		out.close();
	}

}
