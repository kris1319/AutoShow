package logic;

import java.text.ParseException;
import java.util.List;
import java.util.Collection;
import java.sql.SQLException;

import logic.*;
import DAO.*;
import DAO.Impl.*;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/")
public class AutoShowController {

	private static CarDAO car = new CarDAOImpl(Car.class);
	private static CityDAO city = new CityDAOImpl(City.class);
	private static ClientDAO client = new ClientDAOImpl(Client.class);
	private static ColourDAO col = new ColourDAOImpl(Colour.class);
	private static CountryDAO country = new CountryDAOImpl(Country.class);
	private static LabelDAO label = new LabelDAOImpl(Label.class);
	private static ManufacturerDAO fact = new ManufacturerDAOImpl(Manufacturer.class);
	private static MaterialDAO mater = new MaterialDAOImpl(Material.class);
	private static OrderDAO order = new OrderDAOImpl(Order.class);
	private static SpecificationsDAO spec = new SpecificationsDAOImpl(Specifications.class);
	private static StatusDAO st = new StatusDAOImpl(Status.class);
	private static TestDriveDAO td = new TestDriveDAOImpl(TestDrive.class);

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getIndex(Model model) {
		/*List<NewOrd> orders = null;
		try {
		Collection<Order> ords = order.getAll();
		for (Order i : ords) {
			Client cl = client.getClientById(i.getClientId());
			Status stat = st.getStatusById(i.getStatus());
			NewOrd temp = new NewOrd(i.getNumber(), i.getCarId(), i.getClientId(), cl.getFirstName() + " " + cl.getLastName(), 
						i.getDate(), i.getTestdrive(), stat.getStatus());
			orders.add(temp);
		}
		} catch(SQLException ex) {
			
		}
		
		model.addAttribute("orders", orders);*/
		return "index";
	}
}