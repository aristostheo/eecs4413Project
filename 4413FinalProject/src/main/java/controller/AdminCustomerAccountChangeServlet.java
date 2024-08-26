package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddressesDAO;
import dao.CustomerDAO;

/**
 * Servlet implementation class AdminCustomerAccountChangeServlet
 */
@WebServlet("/AdminCustomerAccountChangeServlet")
public class AdminCustomerAccountChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCustomerAccountChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		CustomerDAO cdao = new CustomerDAO();
		AddressesDAO adao = new AddressesDAO();
		// get all the elements
		
		String fname = request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phoneNumber = request.getParameter("phoneNumber");
		String addLine1 = request.getParameter("address1");
		String addLine2 = request.getParameter("address2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipCode = request.getParameter("zipcode");
		String country = request.getParameter("country");
		
		// figure out which ones aren't null
		if (!fname.equals("")) {
			
		} else {
			System.out.println("BOO");
		}
		
		// run a bunch of customerDAOs to update everything
		
		
		// return to somewhere, with suceed message
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
