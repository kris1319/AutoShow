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

public interface OrderDAO extends GenericDAO<Order> {
	public Order getOrderByNumber(Long num) throws SQLException;
	public Collection getOrdersByCar(Car c) throws SQLException;
	public Collection getOrdersByClient(Client c) throws SQLException;
	public Collection getOrdersByStatus(Status st) throws SQLException;
}