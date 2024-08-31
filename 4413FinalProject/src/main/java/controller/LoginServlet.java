package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Customer;

/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		Customer cust = (Customer) session.getAttribute("customer");
		
		if(cust.getFirstName() == null) {
			System.out.println("customer hasn't logged in yet");
			String target = "/jsp/LoginPage.jsp";
			request.getRequestDispatcher(target).forward(request, response);
		} else {
			
			System.out.println("customer is logging out");
			
			session.removeAttribute("session");
			request.getRequestDispatcher("HomeServlet").forward(request, response);
			
//			session.removeAttribute("customer");
//			session.setAttribute("isLoggedIn", false);
//			request.getRequestDispatcher("HomeServlet").forward(request, response);
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
