package com.abc.Employee.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.Employee.dao.DaoImpl;
import com.abc.Employee.dao.DaoInterface;
import com.abc.Employee.model.Employee;
@WebServlet(urlPatterns= {"/reqAdd","/reqDelete","/update"})
public class AdminController extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		String path=req.getServletPath();
		if(path.equals("/reqAdd"))
		{
			PrintWriter out=res.getWriter();
			Employee emp = new Employee();
			emp.setEmp_id(Integer.parseInt(req.getParameter("emp_id")));

	        emp.setEmp_name(req.getParameter("emp_name"));

	        emp.setEmp_salary(Double.parseDouble(req.getParameter("emp_salary")));

	        emp.setEmp_city(req.getParameter("emp_city"));

	        DaoInterface dao=new DaoImpl();

	        boolean b=dao.addEmployee(emp);

	        if(b) {

	            out.print("<h1>success</h1>");

	        }

	        else {

	            out.print("<h1>Fail</h1>");

	        }

		}

		else if(path.equals("/reqDelete")) {
			PrintWriter out=res.getWriter();
			int emp_id = Integer.parseInt(req.getParameter("emp_id"));
			DaoInterface dao=new DaoImpl();
			
			boolean b=dao.deleteEmployee( emp_id);
			
			if(b) {

	            out.print("<h1>success</h1>");

	        }

	        else {

	            out.print("<h1>Fail</h1>");

	        }
			
	}
		
		else if(path.equals("/update"))
		{
				PrintWriter out=res.getWriter();
				Employee emp=new Employee();
				
				emp.setEmp_name(req.getParameter("emp_name"));

		        emp.setEmp_salary(Double.parseDouble(req.getParameter("emp_salary")));

		        emp.setEmp_city(req.getParameter("emp_city"));
				
		        DaoInterface dao=new DaoImpl();
		        
		        boolean b=dao.updateEmployee(emp);
		        if(b) {

			        System.out.println("Employee record Updated successfully");

			    }

			    else {

			        System.out.println("fail");
			    }
			    } 
		
		
	}

	}

