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
 * Servlet implementation class CheckoutServlet
 */
@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Customer c = (Customer) session.getAttribute("customer");
		
		if ((Boolean)session.getAttribute("isLoggedIn")) {
			CustomerDAOInterface customerDAO = new CustomerDAO();
			customerDAO.getCustAddresses(c);
		} else {
			RequestDispatcher r = request.getRequestDispatcher("/jsp/Login.jsp");
			r.forward(request, response);
		}
		
		CartDAOInterface cartDAO = new CartDAO();
		Cart cart = cartDAO.getCart(c.getCustomerId());
		cartDAO.populateCartItems(cart);
//		cartDAO.verifyEntries(cart.getItems());
		
		String offendingItem = null;
		Boolean possible = true;
		for(CartItem i : cart.getItems()) {
			if (i.getProduct().getStockQty() < i.getQuantity()) {
				possible = false;
				offendingItem = "The item " + i.getProduct().getName() + " does not have enough stock left to purchase " + i.getQuantity() + " units."; 
				break;
			}
		}
		
		if (possible) {
			RequestDispatcher r = request.getRequestDispatcher("/jsp/Checkout.jsp");
			r.forward(request, response);
		} else {
			request.setAttribute("errorMessage", offendingItem);
			RequestDispatcher r = request.getRequestDispatcher("/jsp/checkoutError.jsp");
			r.forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
