package dao;

import java.util.List;

import model.Admin;
import model.Customer;

public interface AdminDAOInterface {

	public List<Admin> findAllAdmins();
	public Admin findAdminByEmailPassword(String email, String password);
	
	public int changeAdminEmail(String ogEmail, String newEmail);
	public int changeAdminPassword(String ogPassword, String newPassword);
	
	
}
