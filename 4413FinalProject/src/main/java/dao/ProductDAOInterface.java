package dao;

import java.util.ArrayList;
import java.util.List;

import model.Category;
import model.Product;

public interface ProductDAOInterface {

	public ArrayList<Product> findAllProducts();
	public List<Product> getProductsByBrand(String brand);
	public List<String> findAllBrands();
	public ArrayList<Product> findProductsByCategory(String category);
	public ArrayList<Product> sortProductsPrice();
	public ArrayList<Product> sortProductsName();
	public ArrayList<Product> findProductByKeyword(String query);
	public Product findProductByID(int id);
	public void insert(Product product);
	public void delete(int productid);
	public Product getProduct(int productID);
	public ArrayList<Category> findAllCategories();
	public int changeQty(int productID, int newQty);
}
