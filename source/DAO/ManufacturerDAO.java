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

public interface ManufacturerDAO extends GenericDAO<Manufacturer> {
	public Manufacturer getManufactById(Integer id) throws SQLException;
	public Manufacturer getManufactByName(String nf) throws SQLException;
	public Collection getManufactsByCountry(Country c) throws SQLException;
	public Manufacturer getManufactByLabel(Label l) throws SQLException;
}