package com.jsp.employee_laptop_jdbc_crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.employee_laptop_jdbc_crud.connection.JdbcConnection;
import com.jsp.employee_laptop_jdbc_crud.dto.Employee;
import com.jsp.employee_laptop_jdbc_crud.dto.Laptop;

public class EmployeeLaptopDao {

	Connection connection = null;

	public void insertLaptopEmployee(Employee employee) {
		PreparedStatement preparedStatement = null;
		connection = JdbcConnection.getConnection();

		String insertLaptopQuery = "insert into employee values(?,?,?,?)";
		String insertEmployeeQuery = "insert into laptop values(?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(insertLaptopQuery);
			preparedStatement.setInt(1, employee.getLaptop().getLaptopSerialNo());
			preparedStatement.setString(2, employee.getLaptop().getLapName());
			preparedStatement.setString(3, employee.getLaptop().getRamMemory());
			preparedStatement.setDouble(4, employee.getLaptop().getLaptopPrice());
			
			preparedStatement.execute();
			
			System.out.println("Laptop Data inserted....");

			preparedStatement = connection.prepareStatement(insertEmployeeQuery);
			preparedStatement.setInt(1, employee.getEmpId());
			preparedStatement.setString(2, employee.getEmpName());
			preparedStatement.setString(3, employee.getEmpEmail());
			preparedStatement.setInt(4, employee.getLaptop().getLaptopSerialNo());
	
			preparedStatement.execute();

			System.out.println("Employee Data inserted....");

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	public List<Employee> displayEmployee() {

		PreparedStatement preparedStatement = null;
		connection = JdbcConnection.getConnection();
		try {
			String displayEmployeeLaptopQuery = "select employee.*, laptop.* from employee inner join"
					+ "laptop where employee.laptopSerialNumber=laptop.laptopSerialNumber";
			preparedStatement = connection.prepareStatement(displayEmployeeLaptopQuery);

			ResultSet resultSet = preparedStatement.executeQuery();
			List<Employee> employees = new ArrayList<Employee>();

			while (resultSet.next()) {

				Employee employee = new Employee();

				Laptop laptop = new Laptop();

				laptop.setLaptopSerialNo(resultSet.getInt("laptopserialnumber"));
				laptop.setLapName(resultSet.getString("laptopname"));
				laptop.setLaptopPrice(resultSet.getDouble("laptopprice"));
				laptop.setRamMemory(resultSet.getString("laptopmemory"));

				employee.setEmpId(resultSet.getInt("employeeId"));
				employee.setEmpName(resultSet.getString("employeename"));
				employee.setEmpEmail(resultSet.getString("employeeemail"));

				employee.setLaptop(laptop);

				employees.add(employee);
			}
				return employees;

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return null;
	}

}
