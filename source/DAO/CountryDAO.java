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

public interface CountryDAO extends GenericDAO<Country> {
	public Country getCountryById(Integer id) throws SQLException;
	public Country getCountryByName(String c) throws SQLException;
	public Country getCountryByManufacturer(Manufacturer man) throws SQLException;
	public Country getCountryByCity(City c) throws SQLException;
}