package dao;

import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Product;

public interface ProductDAOInterface {

	public ArrayList<Product> findAllProducts();
	public List<Product> getProductsByBrand(String brand);
	public List<Customer> findAllCustomers();
	public List<String> findAllBrands();
	//public List<Book> findProductsByCategory(String category) // is this being used? 
	public void insert(Product product);
	public void delete(int productid);
	
	
}
