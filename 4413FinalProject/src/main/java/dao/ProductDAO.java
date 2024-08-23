package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import model.Product;
import model.Customer;

public class ProductDAO{
	
	


	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException ex) {
		}
	}

	public static Connection connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:localhost:3306/eStore", "root", "xi3yyqokgCiPn_e");
			System.out.println("Worked!");
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	private void closeConnection(Connection connection) {
		if (connection == null)
			return;
		try {
			connection.close();
		} catch (SQLException ex) {
		}
	}

	//complete this method
	public ArrayList<Product> findAllProducts() {
		ArrayList<Product> result = new ArrayList<Product>();
		
        // join 3 tables to get needed info
		String sql = "select * from products;";
				
		Connection connection = null;
		try {
			Connection con = connection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				Product product = new Product();
				
				// populate product  with needed info
				product.setId(rs.getInt("ProductID"));
				product.setBrand(rs.getString("BrandName"));
				product.setName(rs.getString("ProductName"));
				product.setCatID(rs.getInt("CategoryID"));				
				product.setPrice(rs.getFloat("Price"));
				product.setStockQty(rs.getInt("StockQuantity"));
				product.setDesc(rs.getString("Description"));
				 				
				result.add(product);
			}
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			closeConnection(connection);
		}
		return result;
	}

	// complete this method
	public List<Product> getProductsByBrand(String brand) {
		List<Product> result = new ArrayList<Product>();
		
		String sql = "select * from Products where BrandName like '%" + brand.trim();

		Connection connection = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/eStore","root","EECS4413");
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Product product = new Product();

				// populate book and author with needed info, and then set author to book
				product.setId(rs.getInt("ProductID"));
				product.setBrand(rs.getString("BrandName"));
				product.setName(rs.getString("ProductName"));
				product.setCatID(rs.getInt("CategoryID"));				
				product.setPrice(rs.getFloat("Price"));
				product.setStockQty(rs.getInt("StockQuantity"));
				product.setDesc(rs.getString("Description"));
				
				result.add(product);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}

		return result;
	}	

	// complete this method
	public List<Customer> findAllCustomers() {
		List<Customer> result = new ArrayList<Customer>();
		String sql = "select * from Customers";

		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/eStore","root","EECS4413");
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet resultSet =  statement.executeQuery();
			while (resultSet.next()) {
				Customer customer = new Customer();
				
				
	            customer.setCustomerId(resultSet.getInt("CustomerID"));
	            customer.setFirstName(resultSet.getString("FirstName"));
	            customer.setLastName(resultSet.getString("LastName"));
	            customer.setPhoneNumber(resultSet.getInt("Phone"));
	            customer.setEmail(resultSet.getString("Email"));
	            customer.setAddress(resultSet.getString("AddressID"));
	            //customer.setPassword(resultSet.getString("Password"));
            

				result.add(customer);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return result;
	}	
	// complete this method
	public List<String> findAllBrands() {
		List<String> result = new ArrayList<>();
		String sql = "select DISTINCT BrandName from Products";

		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/eStore","root","EECS4413");
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet resultSet =  statement.executeQuery();
			while (resultSet.next()) {
				
				

				result.add(resultSet.getString("BrandName"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return result;
	}

	
	
//	
//	public List<Book> findProductsByCategory(String category) {
//		List<Book> result = new ArrayList<Book>();
//		 
//
//		String sql = "select * from book inner join author, category on book.id = author.book_id and book.category_id = category.id  where "
//				+ "CATEGORY_DESCRIPTION='" + category + "'";
//
//		Connection connection = null;
//		try {
//			connection = getConnection();
//			PreparedStatement statement = connection.prepareStatement(sql);
//			ResultSet resultSet =  statement.executeQuery();
//			while (resultSet.next()) {
//				Book book = new Book();
//				Author author = new Author();
//				Category category1 = new Category();
//				// populate book and author beans with needed info, and then set author to book
//	            book.setId(resultSet.getLong("id"));
//	            book.setBookTitle(resultSet.getString("book_title"));
//	            for(Category cat : this.findAllCategories()) {
//	            	if(category.equals(cat.getCategoryDescription())) {
//	            		book.setCategory(cat.getCategoryDescription());
//	            		break;
//	            	}
//	            }
////	            book.setCategory();
////	            book.setAuthor(resultSet.getString("author"));
////	            book.setAuthor((Author)resultSet.getObject("author"));
//	            
//	            // Populate author object
//	            author.setId(resultSet.getLong("id"));
//	            author.setFirstName(resultSet.getString("first_name"));
//	            author.setLastName(resultSet.getString("last_name"));
//	            
//	            book.setAuthor(author);
////	            category1.setId(resultSet.getLong("id"));
////	            category1.setCategoryDescription(resultSet.getString("category_description"));
//	            
////				...
//				
//				result.add(book);
//			}
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		} finally {
//			closeConnection(connection);
//		}
//		return result;
//	}
	
	
	public void insert(Product product) {
	    Connection con = null;
	    PreparedStatement statement = null;
	    ResultSet generatedKeys = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/eStore","root","EECS4413");
			statement = con.prepareStatement(
					"insert into Products (ProductName) values (?)",
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, product.getName());
			statement.execute();
			generatedKeys = statement.getGeneratedKeys();
			if (generatedKeys.next()) {
				product.setId(generatedKeys.getInt(1));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
	            if (generatedKeys != null) generatedKeys.close();
	            if (statement != null) statement.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }		
		}
	}

	
	public void delete(int productid) {
		Connection con = null;
	    PreparedStatement statement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/eStore","root","EECS4413");
			statement = con.prepareStatement("delete from product where ProductID=?");
			statement.setLong(1, productid);
			statement.execute();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
	            if (statement != null) statement.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }				
		}
	}
	

}