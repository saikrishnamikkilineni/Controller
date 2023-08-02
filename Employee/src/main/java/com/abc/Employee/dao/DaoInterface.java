package com.abc.Employee.dao;

import java.util.List;

import com.abc.Employee.model.Employee;



public interface DaoInterface {

	public boolean addEmployee(Employee emp);
	public List<Employee> viewAllEmployees();
	public Employee getEmployeebyID(int emp_id);
	public boolean deleteEmployee ( int emp_id);
	public boolean updateEmployee(Employee emp);

	
}
