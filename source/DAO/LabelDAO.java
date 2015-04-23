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

public interface LabelDAO extends GenericDAO <Label> {
	public Label getLabelById(Integer id) throws SQLException;
	public Label getLabelByName(String nl) throws SQLException;
	public Collection getLabelsByManufacturer(Manufacturer man) throws SQLException;
	public Label getLabelByCar(Car c) throws SQLException;
}