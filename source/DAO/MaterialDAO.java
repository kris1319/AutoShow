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

public interface MaterialDAO extends GenericDAO<Material> {	
	public Material getMaterialById(Integer id) throws SQLException;
	public Material getMaterialByName(String str) throws SQLException;
	public Material getMaterialByCar(Car c) throws SQLException;
}