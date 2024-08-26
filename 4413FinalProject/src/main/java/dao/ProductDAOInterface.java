package dao;

import java.util.ArrayList;
import java.util.List;

import model.Product;

public interface ProductDAOInterface {

	public ArrayList<Product> findAllProducts();
	public List<Product> getProductsByBrand(String brand);
	public List<String> findAllBrands();
<<<<<<< HEAD
	public List<Product> findProductsByPrice(int price); // is this being used? =======
	public ArrayList<Product> findProductsByCategory(String category);
	public ArrayList<Product> sortProductsPrice();
	public ArrayList<Product> sortProductsName();
	public ArrayList<Product> findProductByKeyword(String query);
	public Product findProductByID(int id);
=======
	public List<Product> findProductsByCategory(String category); // is this being used? 
	public List<Product> findProductsByPrice(int price); // is this being used? 
>>>>>>> refs/heads/main
	public void insert(Product product);
	public void delete(int productid);
	public Product getProduct(int productID);
	
}
