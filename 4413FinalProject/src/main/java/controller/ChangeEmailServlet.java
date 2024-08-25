package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAO;

/**
 * Servlet implementation class ChangeEmailServlet
 */
@WebServlet("/ChangeEmailServlet")
public class ChangeEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeEmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String oldEmail = request.getParameter("current_email");
		String newEmail = request.getParameter("new_email");
		
		CustomerDAO custDao = new CustomerDAO();
		int result = custDao.changeCustEmail(oldEmail, newEmail);
		
		if (result == 1) {
			//forward to account
			System.out.println("Success!");
			response.setContentType("text/html");
			PrintWriter pwriter = response.getWriter();
			pwriter.print("<p><b>You have successfully changed your email!</b></p>");
			RequestDispatcher back=request.getRequestDispatcher("ChangeInfoConfirmPage.html");
			back.include(request, response); 
		} else if (result == 0) {
			System.out.println("Fail!");
			response.setContentType("text/html");
			PrintWriter pwriter = response.getWriter();
			pwriter.print("<p><b>Change email failed. Please try again </b></p>");
			RequestDispatcher back=request.getRequestDispatcher("ChangeInfoConfirmPage.html");
			back.include(request, response); 
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
