package com.jsp.employee_laptop_jdbc_crud.controller;

import java.util.List;
import java.util.Scanner;

import com.jsp.employee_laptop_jdbc_crud.dto.Employee;
import com.jsp.employee_laptop_jdbc_crud.dto.Laptop;
import com.jsp.employee_laptop_jdbc_crud.service.EmployeeLaptopService;

public class EmployeeLaptopController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		EmployeeLaptopService employeeLaptopService = new EmployeeLaptopService();

		while (true) {

			System.out.println("1.Insert\n2.Display");
			System.out.println("Enter your choice: ");
			int ch = sc.nextInt();

			switch (ch) {
			case 1: {
				Laptop laptop = new Laptop();
				Employee employee = new Employee();
				
				laptop.setLaptopSerialNo(12345);
				laptop.setLapName("hp");
				laptop.setRamMemory("8gb");
				laptop.setLaptopPrice(40000);

				employee.setEmpId(121);
				employee.setEmpName("scott");
				employee.setEmpEmail("scott@gmail.com");
				employee.setLaptop(laptop);

				employeeLaptopService.insertLaptopEmployee(employee);
			}
				break;
			case 2: {
				List<Employee> employees = employeeLaptopService.displayEmployee();

				for (Employee employee : employees) {
					System.out.println("Employee Details..........");

					System.out.println("employeeId= " + employee.getEmpId());
					System.out.println("employeename= " + employee.getEmpName());
					System.out.println("employeeEmail= " + employee.getEmpEmail());

					System.out.println("laptopSerialNumber= " + employee.getLaptop().getLaptopSerialNo());

					System.out.println("Laptop Details..........");

					System.out.println("LaptopSerialNumber= " + employee.getLaptop().getLaptopSerialNo());
					System.out.println("LaptopName= " + employee.getLaptop().getLapName());
					System.out.println("LaptopMemory= " + employee.getLaptop().getRamMemory());

					System.out.println("laptopPrice= " + employee.getLaptop().getLaptopPrice());
				}

			}
				break;

			}
		}
	}
}
