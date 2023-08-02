package com.abc.Employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.abc.Employee.model.Employee;




public class DaoImpl implements DaoInterface {


    Connection con=null;

    public DaoImpl() {

        

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");

        }

        catch(Exception e) {

            System.out.println(e);

        }

    }

	
	public boolean addEmployee(Employee emp) {	
	
	//Add employee details
	boolean b=false;

    try {

    PreparedStatement pstmt=con.prepareStatement("insert into employee values(?,?,?,?)");

    
    pstmt.setInt(1, emp.getEmp_id());
    pstmt.setString(2, emp.getEmp_name());
    pstmt.setDouble(3,emp.getEmp_salary());
    pstmt.setString(4, emp.getEmp_city());

    int i=pstmt.executeUpdate();

    if(i>0) {

        b=true;

    }

    }

    catch(Exception e) {

        System.out.println(e);

    }

     return b;
	}

// Delete employee
	
	public boolean deleteEmployee(int emp_id) {
		boolean b=false;

	    try {

	    PreparedStatement pstmt=con.prepareStatement("delete from employee where emp_id=? ");

	    
	    pstmt.setInt(1, emp_id);
	    

	    int i=pstmt.executeUpdate();

	    if(i>0) {

	        b=true;

	    }

	    }

	    catch(Exception e) {

	        System.out.println(e);

	    }

	     return b;
	}


	//serach by employee_id
	public Employee getEmployeebyID(int emp_id) {
		Employee employee=null; 
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from employee where emp_id=? ");
			pstmt.setLong(1, emp_id);
		
			ResultSet rs=pstmt.executeQuery();
			employee=new Employee();
			while(rs.next()) {
				employee.setEmp_id(rs.getInt("emp_id"));
				employee.setEmp_name(rs.getString("emp_name"));
				employee.setEmp_salary(rs.getDouble("emp_salary"));
				employee.setEmp_city(rs.getString("emp_city"));
				
				
              }
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return employee;
	}


	//view all employee details
	public List<Employee> viewAllEmployees() {
		ArrayList<Employee> emp = new ArrayList<Employee>();
		Employee employee=null;
		try {
    		PreparedStatement pstmt=con.prepareStatement("select * from employee");
    		ResultSet rs=pstmt.executeQuery();
    		
    		
    		while(rs.next()) {
    			Employee e=new Employee();
    			e.setEmp_id(rs.getInt("emp_id"));
    			e.setEmp_name(rs.getString("emp_name"));
    			e.setEmp_salary(rs.getDouble("emp_salary"));
    			e.setEmp_city(rs.getString("emp_city"));
    			
    			
   			 emp.add(e);
    		}
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
		return emp;
    	
	}


	//Update employee details
	public boolean updateEmployee(Employee emp) {
		boolean b=false;
		
       Employee emp1=getEmployeebyID(emp.getEmp_id());
       
       if(!emp.getEmp_name().equals("0")) {
    	   emp1.setEmp_name(emp.getEmp_name());
       }
       
       if(emp.getEmp_salary()!=0) {
    	   emp1.setEmp_salary(emp.getEmp_salary());
       }
       
       if(!emp.getEmp_city().equals("0")) {
       	
       emp1.setEmp_city(emp.getEmp_city());
       }
       
    	
    	try {
    		
    	PreparedStatement pstmt =con.prepareStatement("Update employee set emp_name=?,emp_salary=?,emp_city=? where emp_id=? ");

    	pstmt.setString(1,emp1.getEmp_name());
    	pstmt.setDouble(2, emp1.getEmp_salary());
    	pstmt.setString(3, emp1.getEmp_city());
    	pstmt.setInt(4, emp1.getEmp_id());
    	
        
    	int i=pstmt.executeUpdate();
    	
    	if(i>=0) {
    		b=true;
    	}		
    	}
    	catch(Exception e ) {
    		System.out.println(e);
    	}
    	return b;
	}


	
	
}
	

