package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.*;
import model.*;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CartServlet() {
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = request.getSession();
		CartDAOInterface cartDAO = new CartDAO();
		
		// testing
		//int custID = 1;
		
		Cart c;
		Customer customer = (Customer) session.getAttribute("customer");
		int custID = customer.getCustomerId();
		synchronized (session) {
			c = cartDAO.getCart(custID);
			if (c == null) {
				c = cartDAO.createCart(custID);
				System.out.println("cart does not exist");
			} else {
				cartDAO.populateCartItems(c);
				System.out.println("cart exists");
			}
		}
		
//		CartItem k = new CartItem();
//		Product p = new Product();
//		p.setName("Test Item");
//		k.setProduct(p);
//		List<CartItem> list = new ArrayList<CartItem>();
//		list.add(k);
//		list.add(k);
//		c.setItems(list);
		session.setAttribute("cart", c);
		// Testing
		String todo = request.getParameter("todo");
		//String todo = "view";
		
		if (todo.equals("view")) {
			cartDAO.populateCartItems(c);
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/Cart.jsp");
			rd.forward(request, response);
			return;
		}
		
		Integer productID = Integer.parseInt(request.getParameter("productID"));
		
		if (todo.equals("add")) {
			int quantity = Integer.parseInt(request.getParameter("qty"));

			Integer carItemID = cartDAO.checkItemInCartAlready(c.getCartID(), productID);
			if (carItemID != null) {
				// existing quantity plus user input quantity makes new quantity
				quantity = c.getCartItem(carItemID).getQuantity() + quantity;
				// becomes update instead
				cartDAO.updateCartItem(c.getCartItemID(productID), quantity);
			} else {
				cartDAO.addCartItem(c.getCartID(), productID, quantity);
			}
			
			ProductDAOInterface productDAO = new ProductDAO();
			Product p = productDAO.getProduct(productID);
			String prodName = p.getName();
			
			request.setAttribute("successMessage", "Success! " + prodName + " has been added to your cart.");
			
			RequestDispatcher rq = getServletContext().getRequestDispatcher("/QueryServlet?action=SHOW+ALL+PRODUCTS");
			rq.forward(request, response);
			
		} else if (todo.equals("update")) {
			int quantity = Integer.parseInt(request.getParameter("qty"));

			cartDAO.updateCartItem(c.getCartItemID(productID), quantity);
			
		} else if (todo.equals("remove")) {
			cartDAO.removeCartItem(c.getCartItemID(productID));
		}
		
		
		cartDAO.populateCartItems(c);
		System.out.println(c.getCartID() + " " + c.getCustID());
		RequestDispatcher rq = getServletContext().getRequestDispatcher("/jsp/Cart.jsp");
		rq.forward(request, response);
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
