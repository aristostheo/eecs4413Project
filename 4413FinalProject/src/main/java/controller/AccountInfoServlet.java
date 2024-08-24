package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAO;
import model.Customer;

/**
 * Servlet implementation class AccountInfoServlet
 */
@WebServlet("/AccountInfoServlet")
public class AccountInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CustomerDAO dao = new CustomerDAO();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Customer customer = dao.findCustomerByEmailPassword(email, password);
		System.out.println(customer.getFullName());
		if (customer.getFirstName() != null) {
			request.setAttribute("customer", customer);
			String target = "/jsp/AccountInfo.jsp";
			request.getRequestDispatcher(target).forward(request, response);
		} else {
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
