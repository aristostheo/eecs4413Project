package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import model.Admin;
import model.Customer;

/**
 * Servlet implementation class AdminAccountServlet
 */
@WebServlet("/AdminAccountServlet")
public class AdminAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		
		AdminDAO adao = new AdminDAO();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Admin admin = adao.findAdminByEmailPassword(email, password);
		
		if (admin.getFirstName()!= null) {
			request.setAttribute("admin", admin);			
			String target = "/jsp/AdminAccountInfo.jsp";
			request.getRequestDispatcher(target).forward(request, response);
		} else if (admin.getFirstName() == null) {
			response.setContentType("text/html");
			PrintWriter pwriter = response.getWriter();
			pwriter.print("<p><b>Your email or password was incorrect</b></p>");
			RequestDispatcher back=request.getRequestDispatcher("AdminLogin.html");
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
