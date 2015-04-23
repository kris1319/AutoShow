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

public interface ColourDAO extends GenericDAO<Colour> {
	public Colour getColourById(Integer id) throws SQLException;
	public Colour getColourByName(String c) throws SQLException;
	public Colour getColourByCar(Car c) throws SQLException;
}