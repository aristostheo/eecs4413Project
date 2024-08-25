package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAO;
import dao.ProductDAO;
import dao.PurchaseDAO;
import model.Customer;
import model.Product;
import model.PurchaseOrder;

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
		ArrayList<PurchaseOrder> purchaseHist = new ArrayList<>();
		ArrayList<PurchaseOrder> purchaseHistoryFinal = new ArrayList<>();
		ArrayList<Product> products = new ArrayList<>();
		CustomerDAO custdao = new CustomerDAO();
		PurchaseDAO purdao = new PurchaseDAO();
		ProductDAO proddao = new ProductDAO();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Customer customer = custdao.findCustomerByEmailPassword(email, password);
		System.out.println(customer.getFullName());
		if (customer.getFirstName() != null) {
			request.setAttribute("customer", customer);
			purchaseHist = purdao.getPurchaseOrderbyCustID(customer.getCustomerId());
			
			for (int i = 0; i < purchaseHist.size(); i++) { // get product ID and the product's themselves
				purchaseHistoryFinal.add(purdao.getPurchaseOrderByPOID(purchaseHist.get(i).getPurchaseID(), purchaseHist.get(i)));
				products.add(proddao.findProductByID(purchaseHist.get(i).getPurchaseID()));
			} 
			
			for (int i = 0; i < purchaseHistoryFinal.size(); i++) {
				purchaseHistoryFinal.get(i).setProductName(products.get(i).getName());
				purchaseHistoryFinal.get(i).setProductDesc(products.get(i).getDesc());
			}
			
			request.setAttribute("purchaseHistory", purchaseHistoryFinal);			
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
