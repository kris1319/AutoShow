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

public interface CityDAO extends GenericDAO<City> {
	public City getCityById(Integer id) throws SQLException;
	public City getCityByName(String c) throws SQLException;
	public Collection getCitiesByCountry(Country c) throws SQLException;
	public City getCityByClient(Client cl) throws SQLException;
}