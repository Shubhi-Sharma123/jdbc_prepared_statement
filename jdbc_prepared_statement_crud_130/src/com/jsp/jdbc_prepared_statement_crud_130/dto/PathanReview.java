package com.jsp.jdbc_prepared_statement_crud_130.dto;

public class PathanReview implements Comparable<PathanReview> {
private int pathanId;
private String pathanRating;
private double pathanPrice;
private String pathanName;
public int getPathanId() {
	return pathanId;
}
public void setPathanId(int pathanId) {
	this.pathanId = pathanId;
}
public String getPathanRating() {
	return pathanRating;
}
public void setPathanRating(String pathanRating) {
	this.pathanRating = pathanRating;
}
public double getPathanPrice() {
	return pathanPrice;
}
public void setPathanPrice(double pathanPrice) {
	this.pathanPrice = pathanPrice;
}
public String getPathanName() {
	return pathanName;
}
public void setPathanName(String pathanName) {
	this.pathanName = pathanName;
}
@Override
public int compareTo(PathanReview o) {
	// TODO Auto-generated method stub
	return 0;
}

}
