package dao;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
=======
import model.Category;
import model.Customer;
>>>>>>> refs/remotes/origin/main
import model.Product;

public interface ProductDAOInterface {

	public ArrayList<Product> findAllProducts();
	public List<Product> getProductsByBrand(String brand);
	public List<String> findAllBrands();
	public ArrayList<Product> sortProductsPrice();
	public ArrayList<Product> sortProductsName();
	public ArrayList<Product> findProductByKeyword(String query);
	public Product findProductByID(int id);
	public List<Product> findProductsByCategory(String category); // is this being used? 
	public List<Product> findProductsByPrice(int price); // is this being used? 
	public void insert(Product product);
	public void delete(int productid);
	public Product getProduct(int productID);
	public ArrayList<Category> findAllCategories();
	public int changeQty(int productID, int newQty);
}
