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

import java.math.BigDecimal;
import java.util.Collection;
import java.sql.SQLException;

public interface CarDAO extends GenericDAO<Car> {
	public Car getCarByRegNumber(Long num) throws SQLException;
	public Collection getCarsByCost(BigDecimal lc, BigDecimal rc) throws SQLException;
	public Collection getCarsByColour(Colour c) throws SQLException;
	public Collection getCarsByUpholstery(Material m) throws SQLException;
	public Collection getCarsByLabel(Label l) throws SQLException;
	public Car getCarByOrder(Order ord) throws SQLException;
	public Car getCarByTestDrive(TestDrive td) throws SQLException;
}