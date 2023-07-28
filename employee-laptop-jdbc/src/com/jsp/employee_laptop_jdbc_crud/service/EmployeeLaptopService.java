package com.jsp.employee_laptop_jdbc_crud.service;

import java.util.List;

import com.jsp.employee_laptop_jdbc_crud.dao.EmployeeLaptopDao;
import com.jsp.employee_laptop_jdbc_crud.dto.Employee;

public class EmployeeLaptopService {

	EmployeeLaptopDao dao = new EmployeeLaptopDao();

	public void insertLaptopEmployee(Employee employee) {
		dao.insertLaptopEmployee(employee);
	}

	public List<Employee> displayEmployee(){
		return dao.displayEmployee();
	}
}
