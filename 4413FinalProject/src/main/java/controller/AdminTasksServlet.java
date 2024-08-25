package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import model.OrderDetails;

/**
 * Servlet implementation class AdminTasksServlet
 */
@WebServlet("/AdminTasksServlet")
public class AdminTasksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminTasksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getParameter("adminAction");
		OrderDAO odao = new OrderDAO();
		
		
		if(action.equals("VIEW ORDERS")) {
			System.out.println("view orders");
			// show all orders from a join of both tables, ordered by customer ID
			ArrayList<OrderDetails> orderDetails = odao.getAllOrderInformation();
			request.setAttribute("orderDetails", orderDetails);
			String target = "/jsp/AdminOrderDetails.jsp";
			request.getRequestDispatcher(target).forward(request, response);
		} else if (action.equals("CUSTOMER INFORMATION")) {
			System.out.println("display customer details");
			//
		} else if (action.equals("UPDATE INVENTORY")) {
			System.out.println("Update inventory");
			// show all items, maybe button on each option and a field that will add or subtract
			// with an update  
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
