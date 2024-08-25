package dao;

import java.util.ArrayList;

import model.PurchaseOrder;

public interface PurchaseDAOInterface {
	
	public ArrayList<PurchaseOrder> getPurchaseOrderbyCustID(int id);
	public PurchaseOrder getPurchaseOrderByPOID(int id, PurchaseOrder pur);
	
	
}
