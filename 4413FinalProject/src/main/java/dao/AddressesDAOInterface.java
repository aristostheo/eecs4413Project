package dao;

import model.Addresses;

public interface AddressesDAOInterface {
	
	public int changeAddressLine1WithId(int id, String addLine);
	public int changeAddressLine2WithId(int id, String addLine);
	public int changeCityWithId(int id, String city);
	public int changeStateWithId(int id, String state);
	public int changeZipcodeWithId(int id, String zip);
	public int changeCountryWithId(int id, String country);
	
}
