package com.jsp.jdbc_prepared_statement_crud_130.service;

import java.util.Set;

import com.jsp.jdbc_prepared_statement_crud_130.dao.PathanReviewDao;
import com.jsp.jdbc_prepared_statement_crud_130.dto.PathanReview;

public class PathanReviewService {
	PathanReviewDao dao=new PathanReviewDao();
	public void savePathanReview(PathanReview pathanReview) {
		dao.savePathanReview(pathanReview);
		
	}
	public int getById(int id) {
	int	id2=dao.getById(id);
	return id2;
		
	}
	public String getByName(String name) {
		String name2=dao.getByName(name);
		return name2;
			
		}
	public double getByPrice(double price) {
		double price2=dao.getByPrice(price);
		return price2;
	}
	public void updatePathanReview(int id,String rating, double price ) {
		dao.updatePathanReview(id, rating, price);
	}
	public void deletePathanReview(int id) {
		dao.deletePathanReview(id);
	}
	public Set<PathanReview> displayAllReview() {
		Set<PathanReview> pathanReviews=dao.displayAllReview();
		return pathanReviews;
		//return dao.displayAllReview();
	}
}
