package lk.harshana;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lk.harshana.dao.UserDao;
import lk.harshana.dao.VehicleDao;
import lk.harshana.model.User;
import lk.harshana.model.Vehicle;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class Application implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private VehicleDao vehicleDao;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		saveUserVehicle();
		
		getAllDetails();
	}
	
	private void saveUserVehicle() {
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setName("BMW");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setName("Alto");
		
		Vehicle vehicle3 = new Vehicle();
		vehicle3.setName("Maruti");
		
		User user = new User();
		user.setName("harshana");
		
		user.getVehicle().add(vehicle1);
		user.getVehicle().add(vehicle2);
		user.getVehicle().add(vehicle3);
		
		userDao.save(user);
		
		vehicleDao.save(vehicle1);
		vehicleDao.save(vehicle2);
		vehicleDao.save(vehicle3);
	}
	
	private void getAllDetails() {
		
		for(User user  : userDao.findAll()) {
			log.info(user.getName());
			
			for(Vehicle vehicle : user.getVehicle()) {
				log.info(vehicle.getName());
			}
		}
	}
}
