package com.jsp.jdbc_prepared_statement_crud_130.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import com.jsp.jdbc_prepared_statement_crud_130.dto.PathanReview;
import com.mysql.cj.protocol.Resultset;

public class PathanReviewDao {
	// insert method
	public void savePathanReview(PathanReview pathanReview) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc_simple_project_130";
			String user = "root";
			String password = "shubhi@123";
			Connection connection = DriverManager.getConnection(url, user, password);

			String insert = "insert into pathanreview values(?,?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(insert);

			preparedStatement.setInt(1, pathanReview.getPathanId());
			preparedStatement.setString(4, pathanReview.getPathanName());
			preparedStatement.setString(2, pathanReview.getPathanRating());
			preparedStatement.setDouble(3, pathanReview.getPathanPrice());

			preparedStatement.execute();

			System.out.println("Data inserted.....");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// getById method
	public int getById(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc_simple_project_130";
			String user = "root";
			String password = "shubhi@123";
			Connection connection = DriverManager.getConnection(url, user, password);

			String select = "Select * from pathanreview where id=?";

			PreparedStatement preparedStatement = connection.prepareStatement(select);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			int id1=0;
			while (resultSet.next()) {
				
				id1=resultSet.getInt("id");
			}

			return id1;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	// Update Method
	public void updatePathanReview(int id, String rating, double price) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc_simple_project_130";
			String user = "root";
			String password = "shubhi@123";
			Connection connection = DriverManager.getConnection(url, user, password);

			String update = "Update pathanreview set pathanrating=?, pathanprice=? where id=?";

			PreparedStatement preparedStatement = connection.prepareStatement(update);

			preparedStatement.setString(1, rating);
			preparedStatement.setDouble(2, price);
			preparedStatement.setInt(3, id);

			preparedStatement.executeUpdate();
			System.out.println("data updated....");
			System.out
					.println("Given id=" + id + " " + "\nupdated price=" + price + " " + "\nupdated rating=" + rating);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// Delete Method
		public void deletePathanReview(int id) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/jdbc_simple_project_130";
				String user = "root";
				String password = "shubhi@123";
				Connection connection = DriverManager.getConnection(url, user, password);

				String delete = "Delete from pathanreview where id=?";

				PreparedStatement preparedStatement = connection.prepareStatement(delete);
				preparedStatement.setInt(1, id);

				preparedStatement.executeUpdate();
				System.out.println("data updated....");
				 

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	// getByName method
	public String getByName(String name) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc_simple_project_130";
			String user = "root";
			String password = "shubhi@123";
			Connection connection = DriverManager.getConnection(url, user, password);

			String select = "Select * from pathanreview where cinemaname=? ";

			PreparedStatement preparedStatement = connection.prepareStatement(select);
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				return resultSet.getString("cinemaname");
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}

	// getByPrice method
	public double getByPrice(double price) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc_simple_project_130";
			String user = "root";
			String password = "shubhi@123";
			Connection connection = DriverManager.getConnection(url, user, password);

			String select = "Select * from pathanreview where pathanprice>=?";

			PreparedStatement preparedStatement = connection.prepareStatement(select);
			preparedStatement.setDouble(1, price);
			ResultSet resultSet = preparedStatement.executeQuery();

			Double price1=0.0;
			while (resultSet.next()) {
				
				price1=resultSet.getDouble("pathanprice");
			}

			return price1;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	// display method
	public Set<PathanReview> displayAllReview() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc_simple_project_130";
			String user = "root";
			String password = "shubhi@123";
			Connection connection = DriverManager.getConnection(url, user, password);

			String select = "Select * from pathanreview";

			PreparedStatement preparedStatement = connection.prepareStatement(select);
			ResultSet resultSet = preparedStatement.executeQuery();
			Set<PathanReview> pathanReviews = new HashSet<PathanReview>();

			while (resultSet.next()) {
				PathanReview pathanReview = new PathanReview();

				int id = resultSet.getInt("id");
				pathanReview.setPathanId(id);
				
				String name=resultSet.getString("cinemaname");
				pathanReview.setPathanName(name);
				
				String rating=resultSet.getString("pathanrating");
				pathanReview.setPathanRating(rating);
				
				Double price=resultSet.getDouble("pathanprice");
				pathanReview.setPathanPrice(price);
				
				pathanReviews.add(pathanReview);
			}
			return pathanReviews;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
