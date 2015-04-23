package logic;

import DAO.CarDAO;
import DAO.CityDAO;
import DAO.ClientDAO;
import DAO.ColourDAO;
import DAO.CountryDAO;
import DAO.LabelDAO;
import DAO.ManufacturerDAO;
import DAO.MaterialDAO;

import DAO.OrderDAO;
import DAO.SpecificationsDAO;
import DAO.StatusDAO;
import DAO.TestDriveDAO;
import DAO.Impl.CarDAOImpl;
import DAO.Impl.CityDAOImpl;
import DAO.Impl.ClientDAOImpl;
import DAO.Impl.ColourDAOImpl;
import DAO.Impl.CountryDAOImpl;
import DAO.Impl.LabelDAOImpl;
import DAO.Impl.ManufacturerDAOImpl;
import DAO.Impl.MaterialDAOImpl;

import DAO.Impl.OrderDAOImpl;
import DAO.Impl.SpecificationsDAOImpl;
import DAO.Impl.StatusDAOImpl;
import DAO.Impl.TestDriveDAOImpl;
import logic.HibernateUtil;

public class Factory {
	public static CarDAO carDAO = null;
	public static CityDAO cityDAO = null;
	public static ClientDAO clientDAO = null;
	public static ColourDAO colourDAO = null;
	public static CountryDAO countryDAO = null;
	public static LabelDAO labelDAO = null;
	public static ManufacturerDAO factureDAO = null;
	public static MaterialDAO materialDAO = null;

	public static OrderDAO orderDAO = null;
	public static SpecificationsDAO specificDAO = null;
	public static StatusDAO statusDAO = null;
	public static TestDriveDAO testdriveDAO = null;
	private static Factory instance = null;
	
	public static synchronized Factory getInstance() {
	    if (instance == null) {
	        instance = new Factory();
	    }
	    return instance;
	}

	public CarDAO getCarDAO() {
		if (carDAO == null) {
		    carDAO = new CarDAOImpl(Car.class);
		}
		return carDAO;
	}
	
	public CityDAO getCityDAO() {
		if (cityDAO == null) {
		    cityDAO = new CityDAOImpl(City.class);
		}
		return cityDAO;
	}
	
	public ClientDAO getClientDAO() {
		if (clientDAO == null) {
		    clientDAO = new ClientDAOImpl(Client.class);
		}
		return clientDAO;
	}
	
	public ColourDAO getColourDAO() {
		if (colourDAO == null) {
		    colourDAO = new ColourDAOImpl(Colour.class);
		}
		return colourDAO;
	}
	
	public CountryDAO getCountryDAO() {
		if (countryDAO == null) {
		    countryDAO = new CountryDAOImpl(Country.class);
		}
		return countryDAO;
	}
	
	public LabelDAO getLabelDAO() {
		if (labelDAO == null) {
		    labelDAO = new LabelDAOImpl(logic.Label.class);
		}
		return labelDAO;
	}
	
	public ManufacturerDAO getManufacturerDAO() {
		if (factureDAO == null) {
			factureDAO = new ManufacturerDAOImpl(Manufacturer.class);
		}
		return factureDAO;
	}
	
	public MaterialDAO getMaterialDAO() {
		if (materialDAO == null) {
			materialDAO = new MaterialDAOImpl(logic.Material.class);
		}
		return materialDAO;
	}
	
	public OrderDAO getOrderDAO() {
		if (orderDAO == null) {
		    orderDAO = new OrderDAOImpl(Order.class);
		}
		return orderDAO;
	}
	
	public SpecificationsDAO getSpecificationsDAO() {
		if (specificDAO == null) {
			specificDAO = new SpecificationsDAOImpl(Specifications.class);
		}
		return specificDAO;
	}
	
	public StatusDAO getStatusDAO() {
		if (statusDAO == null) {
		    statusDAO = new StatusDAOImpl(logic.Status.class);
		}
		return statusDAO;
	}
	
	public TestDriveDAO getTestDriveDAO() {
		if (testdriveDAO == null) {
		    testdriveDAO = new TestDriveDAOImpl(TestDrive.class);
		}
		return testdriveDAO;
	}
}