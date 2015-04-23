package DAO;

import logic.Car;
import logic.City;
import logic.Client;
import logic.Colour;
import logic.Country;
import logic.Label;
import logic.Manufacturer;
import logic.Material;

import logic.Order;
import logic.Specifications;
import logic.Status;
import logic.TestDrive;

import java.util.Collection;
import java.sql.SQLException;

public interface ClientDAO extends GenericDAO<Client> {	
	public Client getClientById(Long id) throws SQLException;
	public Collection getClientsByFName(String fn) throws SQLException;
	public Collection getClientsByLName(String ln) throws SQLException;
	public Collection getClientsByLocation(City c) throws SQLException;
	public Client getClientByPhone(String ph) throws SQLException;
	public Client getClientByMail(String em) throws SQLException;
	public Client getClientByOrder(Order ord) throws SQLException;
	public Client getClientByTestDrive(TestDrive td) throws SQLException;

}