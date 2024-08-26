package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		CustomerDAO cdao = new CustomerDAO();
		AddressesDAO adao = new AddressesDAO();
		// get all the elements
		String customerID = request.getParameter("custID");
		int custId = Integer.valueOf(customerID.substring(12));
		//System.out.println(custId);
		
		int success = 0;
		
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
			success = cdao.changeCustomerFirstName(custId, fname);
		}
		
		if (!lname.equals("")) {
			success = cdao.changeCustomerLastName(custId, lname);
		}
		
		if (!email.equals("")) {
			success = cdao.changeCustEmailWithID(custId, email);
		}
		
		if (!password.equals("")) {
			success = cdao.changeCustPasswordWIthID(custId, password);
		}
		
		if (!phoneNumber.equals("")) {
			success = cdao.changeCustPhoneNumWithID(custId, Long.valueOf(phoneNumber));
		}
		
		if (!addLine1.equals("")) {
			success = adao.changeAddressLine1WithId(custId, addLine1);
		}
		
		if (!addLine2.equals("")) {
			success = adao.changeAddressLine2WithId(custId, addLine2);
		}
		
		if (!city.equals("")) {
			success = adao.changeCityWithId(custId, city);
		}
		
		if (!state.equals("")) {
			success = adao.changeStateWithId(custId, state);
		}
		
		if (!zipCode.equals("")) {
			success = adao.changeZipcodeWithId(custId, zipCode);
		}
		if (!country.equals("")) {
			success = adao.changeCountryWithId(custId, country);
		}
		
		// return to somewhere, with succeed message
		response.setContentType("text/html");
		PrintWriter pwriter = response.getWriter();
		pwriter.print("<p><b>Change customer success!</b></p>");
		RequestDispatcher back=request.getRequestDispatcher("ChangeInfoConfirmPage.html");
		back.include(request, response); 
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
