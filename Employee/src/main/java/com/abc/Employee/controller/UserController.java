package com.abc.Employee.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.Employee.dao.DaoImpl;
import com.abc.Employee.dao.DaoInterface;
import com.abc.Employee.model.Employee;
@WebServlet(urlPatterns= {"/viewall","/reqSearch"})
public class UserController extends HttpServlet {

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		String path=req.getServletPath();
		if(path.equals("/viewall"))
		{
			PrintWriter out=res.getWriter();
			 DaoInterface dao=new DaoImpl();
		List<Employee> emp=dao.viewAllEmployees();
			
		  for (Employee e : emp) {
		  
			  out.println("Employee ID : " + e.getEmp_id());
		      out.println("Employee name : "+e.getEmp_name());
		      out.println("Employee salary :"+e.getEmp_salary());
		      out.println("Employee city :"+e.getEmp_salary());
		
		  }
		}
		
		else if(path.equals("/reqSearch")) {
			PrintWriter out=res.getWriter();
			int emp_id=Integer.parseInt(req.getParameter("emp_id"));

	        DaoInterface dao=new DaoImpl();

	        Employee emp=dao.getEmployeebyID(emp_id);

	        

	        out.println("Emp id: "+emp.getEmp_id());

	        out.println("Emp name: "+emp.getEmp_name());

	        out.println("Emp salary: "+emp.getEmp_salary());

	        out.println("Emp city: "+emp.getEmp_city());

		}
			
			
		}
		}
	
