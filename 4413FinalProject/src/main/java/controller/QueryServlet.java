package controller;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Product;

/**
 * Servlet implementation class QueryServlet
 */
@WebServlet("/QueryServlet")
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			response.setContentType("text/html;charset=UTF-8");
			
			String action = request.getParameter("button");
			ProductDAO dao = new ProductDAO();
			ArrayList<Product> productList = new ArrayList<>();
			if (action.equals("APPLY FILTER")) {
				System.out.println("Get filtered products");
				ArrayList<Product> catList = new ArrayList<>();
				ArrayList<Product> brandList = new ArrayList<>();
				String[] categories = request.getParameterValues("categories");
				String[] brands = request.getParameterValues("brand");
				
				if (categories == null && brands == null) { // nothing selected
					System.out.println("Nothing selected");
				} else if (categories == null && brands != null) { // only brands 
					for (int i = 0; i < brands.length; i++) {
						//System.out.println(brands[i]);
						productList.addAll(dao.getProductsByBrand(brands[i]));
					} 
				} else if (categories != null && brands == null) { // only categories selected
					for (int i = 0; i < categories.length; i++) {
						//System.out.println(categories[i]);
						productList.addAll(dao.findProductsByCategory(categories[i]));
					} 
				} else if (catList != null && brandList != null) { // categories and brands selected
					for (int i = 0; i < categories.length; i++) {
						//System.out.println(categories[i]);
						catList.addAll(dao.findProductsByCategory(categories[i]));
					} 
					for (int i = 0; i < brands.length; i++) {
						//System.out.println(brands[i]);
						brandList.addAll(dao.getProductsByBrand(brands[i]));
					}  
					for (int i = 0; i < catList.size(); i++) {
						for (int j = 0; j < brands.length; j++) {
							if (catList.get(i).getBrand().toUpperCase().equals(brands[j].toUpperCase())) {
								productList.add(catList.get(i)); 
							}
						}
					}
				}
			} else if (action.equals("SUBMIT")) {
				String searchQuery = request.getParameter("searchQuery");
				System.out.println("get keyword search products");
				System.out.println(searchQuery);
			} else if (action.equals("SORT BY PRICE")) {
				System.out.println("Sort by price");
				productList = dao.sortProductsPrice();
			} else if (action.equals("SORT BY NAME")) {
				System.out.println("Sort by name");
				productList = dao.sortProductsName();
			} else if (action.equals("SHOW ALL PRODUCTS")) {
				System.out.println("Show all products");
				productList = dao.findAllProducts();
			}
			
			request.setAttribute("productList", productList);
			String target = "/jsp/productView.jsp";
			request.getRequestDispatcher(target).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
