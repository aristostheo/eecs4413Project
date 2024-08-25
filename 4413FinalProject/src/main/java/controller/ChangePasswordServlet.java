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
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String oldPassword = request.getParameter("current_password");
		String newPassword = request.getParameter("new_password");
		
		CustomerDAO custDao = new CustomerDAO();
		int result = custDao.changeCustPassword(oldPassword, newPassword);
		
		if (result == 1) {
			//forward to account
			System.out.println("Success!");
			response.setContentType("text/html");
			PrintWriter pwriter = response.getWriter();
			pwriter.print("<p><b>You have successfully changed your password!</b></p>");
			RequestDispatcher back=request.getRequestDispatcher("ChangeInfoConfirmPage.html");
			back.include(request, response); 
		} else if (result == 0) {
			System.out.println("Fail!");
			response.setContentType("text/html");
			PrintWriter pwriter = response.getWriter();
			pwriter.print("<p><b>Change password failed. Please log in and try again </b></p>");
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
