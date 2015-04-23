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
import java.text.SimpleDateFormat;

public interface TestDriveDAO extends GenericDAO<TestDrive> {
	public TestDrive getTestDriveByNumber(Long num) throws SQLException;
	public Collection getTestDrivesByCar(Car c) throws SQLException;
	public Collection getTestDrivesByClient(Client c) throws SQLException;
}