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
		
		String[] catImgs = {
				"https://p1.socds.net/llp/4708/photo_upload_63b8986cc1cd0-2023-01-06.png", 
				"https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/mba13-midnight-select-202402?wid=904&hei=840&fmt=jpeg&qlt=90&.v=1708367688034", 
				"https://gadgetward.com/cdn/shop/files/SamsungGalaxyTabS85GSM-X706256GB8GBGraphite.1_800x.jpg?v=1705397553", 
				"https://adminapi.applegadgetsbd.com/storage/media/large/Galaxy-Watch5-Pink-Gold-2134.jpg", 
				"https://i5.walmartimages.com/asr/31c9cfb7-5657-4f74-8def-0491d21c4ae5.c6166a775e3e0211ba9e871cc836e61d.jpeg?odnHeight=612&odnWidth=612&odnBg=FFFFFF"};
		
		session.setAttribute("cartImgs", catImgs);
		
		if ((Boolean)session.getAttribute("session") == null) {
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
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/Home.jsp?home=true");
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
