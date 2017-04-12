package lk.harshana;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lk.harshana.dao.AccountDao;
import lk.harshana.dao.UserDao;
import lk.harshana.model.Account;
import lk.harshana.model.User;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

	private static Logger log = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AccountDao accountDao;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		saveUserAccount();
		
		getAllUsers();
	}
	
	private void saveUserAccount() {
		User user = new User();
		user.setName("harshana");

		Account acc = new Account();
		acc.setAccountNo("12345679");

		user.setAccount(acc);

		userDao.save(user);
		accountDao.save(acc);
	}
	
	public void getAllUsers() {
		for(User user : userDao.findAll()) {
			log.info(user.getName() +" " + user.getAccount().getAccountNo());
		}
	}
}
