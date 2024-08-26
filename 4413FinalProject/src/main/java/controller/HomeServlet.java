package controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("session") == null) {
			ProductDAOInterface dao = new ProductDAO();
			List<Category> allCategories = dao.findAllCategories();
			List<String> allBrands = dao.findAllBrands();
			
			session.setAttribute("session", true);
			session.setAttribute("categories", allCategories);
			session.setAttribute("brands", allBrands);
			session.setAttribute("isLoggedIn", false);
			
			CustomerDAOInterface custDAO = new CustomerDAO();
			Customer anon = custDAO.createAnonCustomer();
			session.setAttribute("customer", anon);
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/Home.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
