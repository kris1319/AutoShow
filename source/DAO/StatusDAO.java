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

public interface StatusDAO extends GenericDAO<Status> {
	public Status getStatusById(Integer id) throws SQLException;
	public Status getStatusByName(String str) throws SQLException;
	public Status getStatusByOrder(Order ord) throws SQLException;
}