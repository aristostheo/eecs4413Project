package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import model.Product;
import model.Category;

public class ProductDAO extends BaseDAO implements ProductDAOInterface{


	public ArrayList<Product> findAllProducts() {
		ArrayList<Product> result = new ArrayList<Product>();
		
		String sql = "select * from products;";
		Connection con = null;
		try {
			con = getConnection();
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
	
	@Override
	public ArrayList<Category> findAllCategories() {
		ArrayList<Category> result = new ArrayList<Category>();
		
		String sql = "select * from categories;";
				
		Connection con = getConnection();
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

		Connection con = getConnection();
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

	public List<String> findAllBrands() {
		List<String> result = new ArrayList<>();
		String sql = "select DISTINCT BrandName from Products";

		Connection con = null;
		try {
			con = getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet resultSet =  statement.executeQuery();
			while (resultSet.next()) {

				result.add(resultSet.getString("BrandName"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
				try {
		            if (con != null) {
		            	con.close();
		            }
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return result;
	}
	
	public ArrayList<Product> findProductsByCategory(String category) {
		ArrayList<Product> result = new ArrayList<Product>();
		 

		String sql = "select * from products join categories on products.CategoryID = categories.CategoryID where "+ "categories.CategoryName='" + category + "'";

		Connection con = getConnection();
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
	
	public ArrayList<Product> sortProductsPrice(){
		ArrayList<Product> result = new ArrayList<>();
		String sql = "select * from products order by Price;";
		
		Connection con = getConnection();
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
		
		Connection con = getConnection();
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
		
		Connection con = getConnection();
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
		
		Connection con = getConnection();
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
			con = getConnection();
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
			con = getConnection();
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
			con = getConnection();
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
	
	public String getCategory(int catID) {
		String cat = null;
		String sql = "select CategoryName from Categories where CategoryID = ?";
		
		Connection con = null;
		try {
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, catID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				cat = rs.getString("CategoryName");
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
		return cat;
	}
	
	public int changeQty(int productID, int newQty) {
		String sql = "update products set products.StockQuantity ='" + newQty + "' where products.ProductID ='" + productID + "';";
		Connection con = getConnection();
		int resultSet = 0;
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			resultSet =  statement.executeUpdate();
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
		
		return resultSet;
	}
}