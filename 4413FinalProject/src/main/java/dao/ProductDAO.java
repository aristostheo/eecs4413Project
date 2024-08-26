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
import model.Cart;
import model.Category;
import model.Customer;

public  class ProductDAO implements ProductDAOInterface{

	public static Connection connection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newstore", "root", "EECS4413");

			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public ArrayList<Product> findAllProducts() {
		ArrayList<Product> result = new ArrayList<Product>();
		
		String sql = "select * from products;";
		Connection con = null;
		try {
			con = connection();
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
				product.setImg(rs.getString("ImageURL"));

				result.add(product);
			}
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			try {
	            if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public ArrayList<Category> findAllCategories() {
		ArrayList<Category> result = new ArrayList<Category>();
		
		String sql = "select * from categories;";
				
		Connection con = connection();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				Category category = new Category();
				
				category.setId(rs.getInt("CategoryID"));
				category.setName(rs.getString("Categoryname"));
				category.setDescription(rs.getString("Description"));
	
				result.add(category);
			}
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			try {
	            if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return result;
	}

	public List<Product> getProductsByBrand(String brand) {
		List<Product> result = new ArrayList<Product>();

		String sql = "select * from Products where BrandName like '%" + brand.trim() + "'";

		Connection con = connection();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Product product = new Product();

				product.setId(rs.getInt("ProductID"));
				product.setBrand(rs.getString("BrandName"));
				product.setName(rs.getString("ProductName"));
				product.setCatID(rs.getInt("CategoryID"));				
				product.setPrice(rs.getFloat("Price"));
				product.setStockQty(rs.getInt("StockQuantity"));
				product.setDesc(rs.getString("Description"));
				product.setImg(rs.getString("ImageURL"));
				
				result.add(product);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
	            if (con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}	

	// complete this method
	public ArrayList<Customer> findAllCustomers() {
		ArrayList<Customer> result = new ArrayList<Customer>();
		String sql = "select * from Customers";

		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/eStore","root","EECS4413");
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
			try {
	            if (con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		}
		return result;
	}	
	// complete this method
	public ArrayList<String> findAllBrands() {
		ArrayList<String> result = new ArrayList<>();
		String sql = "select DISTINCT BrandName from Products";

		Connection con = null;
		try {
			con = connection();
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet resultSet =  statement.executeQuery();
			while (resultSet.next()) {

				result.add(resultSet.getString("BrandName"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
				try {
		            if (con != null) con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return result;
	}
	
	public ArrayList<Product> findProductsByCategory(String category) {
		ArrayList<Product> result = new ArrayList<Product>();
		 

		String sql = "select * from products join categories on products.CategoryID = categories.CategoryID where categories.CategoryName='" + category + "';";

		Connection con = connection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs =  statement.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("ProductID"));
				product.setBrand(rs.getString("BrandName"));
				product.setName(rs.getString("ProductName"));
				product.setCatID(rs.getInt("CategoryID"));				
				product.setPrice(rs.getFloat("Price"));
				product.setStockQty(rs.getInt("StockQuantity"));
				product.setDesc(rs.getString("Description"));
				product.setImg(rs.getString("ImageURL"));
//	            for(Category cat : this.findAllCategories()) {
//	            	if(category.equals(cat.getDescription())) {
//	            		product.setCatID(cat.getId());
//	            		break;
//	            	}
//	            }
				
				result.add(product);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
	            if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return result;
	}
//	public ArrayList<Product> findProductsByPrice(int price) {
//		ArrayList<Product> result = new ArrayList<Product>();
//		 
//
//		String sql = "select * from products where price <" + price+";";
//
//
//		Connection con = null;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/eStore","root","EECS4413");
//			PreparedStatement statement = con.prepareStatement(sql);
//			ResultSet rs =  statement.executeQuery();
//			while (rs.next()) {
//				Product product = new Product();
//
//				product.setId(rs.getInt("ProductID"));
//				product.setBrand(rs.getString("BrandName"));
//				product.setName(rs.getString("ProductName"));
//				product.setCatID(rs.getInt("CategoryID"));				
//				product.setPrice(rs.getFloat("Price"));
//				product.setStockQty(rs.getInt("StockQuantity"));
//				product.setDesc(rs.getString("Description"));
//
//
//				
//				result.add(product);
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		} finally {
//			try {
//	            if (con != null) con.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
//		return result;
//	}
	public ArrayList<Product> findProductsByPrice(int price) {
		ArrayList<Product> result = new ArrayList<Product>();
		 

		String sql = "select * from products where price <" + price+";";

		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/eStore","root","EECS4413");
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs =  statement.executeQuery();
			while (rs.next()) {
				Product product = new Product();
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
			try {
	            if (con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return result;
	}
	
	public ArrayList<Product> sortProductsPrice(){
		ArrayList<Product> result = new ArrayList<>();
		String sql = "select * from products order by Price;";
		
		Connection con = connection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs =  statement.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("ProductID"));
				product.setBrand(rs.getString("BrandName"));
				product.setName(rs.getString("ProductName"));
				product.setCatID(rs.getInt("CategoryID"));				
				product.setPrice(rs.getFloat("Price"));
				product.setStockQty(rs.getInt("StockQuantity"));
				product.setDesc(rs.getString("Description"));
				product.setImg(rs.getString("ImageURL"));
				result.add(product);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
	            if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
	
	public ArrayList<Product> sortProductsName(){
		ArrayList<Product> result = new ArrayList<>();
		String sql = "select * from products order by ProductName;";
		
		Connection con = connection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs =  statement.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("ProductID"));
				product.setBrand(rs.getString("BrandName"));
				product.setName(rs.getString("ProductName"));
				product.setCatID(rs.getInt("CategoryID"));				
				product.setPrice(rs.getFloat("Price"));
				product.setStockQty(rs.getInt("StockQuantity"));
				product.setDesc(rs.getString("Description"));
				product.setImg(rs.getString("ImageURL"));
				result.add(product);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
	            if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
	
	public Product findProductByID(int id) {
		Product prod = new Product();
		String sql = "select * from products where ProductID ='" + id + "';";
		
		Connection con = connection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs =  statement.executeQuery();
			while (rs.next()) {
				prod.setId(rs.getInt("ProductID"));
				prod.setBrand(rs.getString("BrandName"));
				prod.setName(rs.getString("ProductName"));
				prod.setCatID(rs.getInt("CategoryID"));				
				prod.setPrice(rs.getFloat("Price"));
				prod.setStockQty(rs.getInt("StockQuantity"));
				prod.setDesc(rs.getString("Description"));
				prod.setImg(rs.getString("ImageURL"));
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
	            if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return prod;
		
	}
	
	public ArrayList<Product> findProductByKeyword(String query){
		ArrayList<Product> result = new ArrayList<>();
		String sql = "select * from Products where BrandName like '%" + query + "%' "
				+ "or ProductName like '%" + query + "%' or Description like '%" + query + "%';";
		
		Connection con = connection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs =  statement.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("ProductID"));
				product.setBrand(rs.getString("BrandName"));
				product.setName(rs.getString("ProductName"));
				product.setCatID(rs.getInt("CategoryID"));				
				product.setPrice(rs.getFloat("Price"));
				product.setStockQty(rs.getInt("StockQuantity"));
				product.setDesc(rs.getString("Description"));
				product.setImg(rs.getString("ImageURL"));
				result.add(product);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
	            if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
	public void insert(Product product) {
	    Connection con = null;
	    PreparedStatement statement = null;
	    ResultSet generatedKeys = null;
		try {
			con = connection();
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
			con = connection();
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
	
	@Override
	public Product getProduct(int productID) {
		Product p = null;
		String sql = "select * from Products where ProductID = ?";
		
		Connection con = null;
		try {
			con = connection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, productID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				p = new Product();
				p.setId(rs.getInt("ProductID"));
				p.setBrand(rs.getString("BrandName"));
				p.setName(rs.getString("ProductName"));
				p.setCatID(rs.getInt("CategoryID"));				
				p.setPrice(rs.getFloat("Price"));
				p.setStockQty(rs.getInt("StockQuantity"));
				p.setDesc(rs.getString("Description"));
				p.setImg(rs.getString("ImageURL"));
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			try {
	            if (con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return p;
	}
	

}