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
		session.setAttribute("customerID", 1);
		
		Cart c;
		int custID = (Integer) session.getAttribute("customerID");
		synchronized (session) {
			c = cartDAO.getCart(custID);
			if (c == null) {
				c = cartDAO.createCart(custID);
				System.out.println("cart does not exists");
			} else {
				cartDAO.populateCartItems(c);
				System.out.println("cart exists");
			}
		}
		
		session.setAttribute("cart", c);
		// Testing
		//String todo = request.getParameter("todo");
		String todo = "view";
		
		if (todo.equals("view")) {
			cartDAO.populateCartItems(c);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/Cart.jsp");
			rd.forward(request, response);
		}
		
		Integer productID = Integer.parseInt(request.getParameter("productID"));
		int quantity = Integer.parseInt(request.getParameter("qty"));
		
		if (todo.equals("add")) {
			Integer carItemID = cartDAO.checkItemInCartAlready(c.getCartID(), productID);
			if (carItemID != null) {
				// existing quantity plus user input quantity makes new quantity
				quantity = c.getCartItem(carItemID).getQuantity() + quantity;
				// becomes update instead
				cartDAO.updateCartItem(c.getCartItemID(productID), quantity);
			} else {
				cartDAO.addCartItem(c.getCartID(), productID, quantity);
			}
			
		} else if (todo.equals("update")) {
			cartDAO.updateCartItem(c.getCartItemID(productID), quantity);
			
		} else if (todo.equals("remove")) {
			cartDAO.removeCartItem(c.getCartItemID(productID));
		}
		
		
		cartDAO.populateCartItems(c);
		System.out.println(c.getCartID() + " " + c.getCustID());
		RequestDispatcher rq = getServletContext().getRequestDispatcher("../../webapp/Cart.jsp");
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
