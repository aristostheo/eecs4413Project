package controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ConnectionManager;
import model.PasswordUtil;

@WebServlet("/AccountCreationServlet")
public class AccountCreationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AccountCreationServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    	
    	RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/AccountCreation.jsp");
		rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        System.out.println("Starting account creation process...");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone").trim();
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zipCode = request.getParameter("zipCode");
        String country = request.getParameter("country");

        Connection con = null;
        PreparedStatement addressStatement = null;
        PreparedStatement customerStatement = null;
        PreparedStatement updateAddressStatement = null;
        ResultSet generatedKeys = null;
        ResultSet customerKeys = null;

        try {
            System.out.println("Establishing database connection...");
            con = ConnectionManager.getConnection();
            con.setAutoCommit(false);
            
            System.out.println("Inserting address...");
            String addressSql = "INSERT INTO Addresses (addressLine1, city, state, zipCode, country) VALUES (?, ?, ?, ?, ?);";
            addressStatement = con.prepareStatement(addressSql, PreparedStatement.RETURN_GENERATED_KEYS);
            addressStatement.setString(1, address);
            addressStatement.setString(2, city);
            addressStatement.setString(3, state);
            addressStatement.setString(4, zipCode);
            addressStatement.setString(5, country);
            addressStatement.executeUpdate();

            generatedKeys = addressStatement.getGeneratedKeys();
            int addressID = 0;
            if (generatedKeys.next()) {
                addressID = generatedKeys.getInt(1);
            }
            
            System.out.println("Address inserted with ID: " + addressID);
            
            System.out.println("Inserting customer...");
            String customerSql = "INSERT INTO Customers (firstName, lastName, email, password, phone, addressID) VALUES (?, ?, ?, ?, ?, ?);";
            customerStatement = con.prepareStatement(customerSql, PreparedStatement.RETURN_GENERATED_KEYS);
            customerStatement.setString(1, firstName);
            customerStatement.setString(2, lastName);
            customerStatement.setString(3, email);
            try {
                String hashedPassword = PasswordUtil.hashPassword(password);
                customerStatement.setString(4, hashedPassword);
            } catch (NoSuchAlgorithmException e) {
                System.out.println("Password hashing failed.");
                e.printStackTrace();
                con.rollback();
                return;
            }
            customerStatement.setString(5, phone);
            customerStatement.setInt(6, addressID);
            customerStatement.executeUpdate();
            
            customerKeys = customerStatement.getGeneratedKeys();
            int customerID = 0;
            if (customerKeys.next()) {
                customerID = customerKeys.getInt(1);
            }
            
            System.out.println("Customer inserted with ID: " + customerID);
            
            System.out.println("Updating address with customer ID...");
            String updateAddressSql = "UPDATE Addresses SET customerID = ? WHERE addressID = ?;";
            updateAddressStatement = con.prepareStatement(updateAddressSql);
            updateAddressStatement.setInt(1, customerID);
            updateAddressStatement.setInt(2, addressID);
            updateAddressStatement.executeUpdate();

            con.commit();
            System.out.println("Transaction committed successfully.");
            response.sendRedirect("./SuccessAccount.html");
        } catch (SQLException e) {
            System.out.println("SQL error during account creation process.");
            e.printStackTrace();
            if (con != null) {
                try {
                    con.rollback();
                    System.out.println("Transaction rolled back.");
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.out.println("Error during account creation process.");
            e.printStackTrace();
        } finally {
            // Close resources in the reverse order of their creation
            if (generatedKeys != null) {
                try { generatedKeys.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
            if (customerKeys != null) {
                try { customerKeys.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
            if (addressStatement != null) {
                try { addressStatement.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
            if (customerStatement != null) {
                try { customerStatement.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
            if (updateAddressStatement != null) {
                try { updateAddressStatement.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
            if (con != null) {
                try {
                    con.close();
                    System.out.println("Database connection closed.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
