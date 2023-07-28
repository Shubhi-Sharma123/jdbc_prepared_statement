package com.jsp.employee_laptop_jdbc_crud.dto;

public class Laptop {
private int laptopSerialNo;
private String lapName;
private String ramMemory;
private double laptopPrice;

public int getLaptopSerialNo() {
	return laptopSerialNo;
}
public void setLaptopSerialNo(int laptopSerialNo) {
	this.laptopSerialNo = laptopSerialNo;
}
public String getLapName() {
	return lapName;
}
public void setLapName(String lapName) {
	this.lapName = lapName;
}
public String getRamMemory() {
	return ramMemory;
}
public void setRamMemory(String ramMemory) {
	this.ramMemory = ramMemory;
}
public double getLaptopPrice() {
	return laptopPrice;
}
public void setLaptopPrice(double laptopPrice) {
	this.laptopPrice = laptopPrice;
}

}
