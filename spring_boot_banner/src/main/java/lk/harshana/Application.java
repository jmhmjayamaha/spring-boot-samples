package lk.harshana;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lk.harshana.banner.MyBanner;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Application.class);
		
//		uncomment to disable the banner mode 
//		application.setBannerMode(Banner.Mode.OFF);
		
		application.setBanner(new MyBanner());
		application.run(args);
	}
}
