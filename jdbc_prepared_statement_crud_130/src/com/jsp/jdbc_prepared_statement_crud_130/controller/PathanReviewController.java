package com.jsp.jdbc_prepared_statement_crud_130.controller;

import java.util.Scanner;
import java.util.Set;

import com.jsp.jdbc_prepared_statement_crud_130.dto.PathanReview;
import com.jsp.jdbc_prepared_statement_crud_130.service.PathanReviewService;

public class PathanReviewController {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		PathanReview pathanReview = null;

		PathanReviewService pathanReviewService = new PathanReviewService();

		while (true) {

			System.out.println("1.Insert\n2.Update\n3.Display\n4.Delete\n5.getById\n6.getByName\n7.getByPrice\n8.Exit");
			System.out.println("Enter your choice: ");
			int ch = sc.nextInt();

			switch (ch) {
			case 1: {
				pathanReview = new PathanReview();
				System.out.println("Enter the id");
				int id = sc.nextInt();

				System.out.println("Enter the movie rating");
				String rating = sc.next();

				System.out.println("Enter the movie price");
				double price = sc.nextDouble();

				System.out.println("Enter the movie name");
				String name = sc.next();

				pathanReview.setPathanId(id);
				pathanReview.setPathanName(name);
				pathanReview.setPathanRating(rating);
				pathanReview.setPathanPrice(price);

				pathanReviewService.savePathanReview(pathanReview);

			}
				break;
			case 2: {
				pathanReview = new PathanReview();

				System.out.println("Enter the id");
				int id = sc.nextInt();

				System.out.println("Enter the movie rating");
				String rating = sc.next();

				System.out.println("Enter the movie price");
				double price = sc.nextDouble();

				pathanReviewService.updatePathanReview(id, rating, price);

			}
				break;
			case 3: {
				Set<PathanReview> pathanReviews = pathanReviewService.displayAllReview();
				for (PathanReview pathanReview2 : pathanReviews) {
					System.out.println("PathanReviewId" + pathanReview2.getPathanId());
					System.out.println("PathanReviewName" + pathanReview2.getPathanName());
					System.out.println("PathanRating" + pathanReview2.getPathanRating());
					System.out.println("PathanPrice" + pathanReview2.getPathanPrice());
				}
			}
				break;
			case 4: {
				pathanReview = new PathanReview();

				System.out.println("Enter the id");
				int id = sc.nextInt();

				pathanReviewService.deletePathanReview(id);

			}
				break;
			case 5: {

				System.out.println("Enter the customer id to fetch the details");
				int id = sc.nextInt();

				int id1 = pathanReviewService.getById(id);

				System.out.println(id1);

			}
				break;
			case 6: {

				System.out.println("Enter the movie name to fetch the details");
				String name = sc.next();

				String name1 = pathanReviewService.getByName(name);

				System.out.println(name1);

			}
				break;
			case 7: {

				System.out.println("Enter the movie price to fetch the details");
				Double price = sc.nextDouble();
				
					Double price1 = pathanReviewService.getByPrice(price);

					System.out.println(price1);
				
				}break;

			}
				
			}
		}
	}
