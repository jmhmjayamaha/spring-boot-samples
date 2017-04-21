package lk.harshana.banner;

import java.io.PrintStream;

import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

public class MyBanner implements Banner {

	@Override
	public void printBanner(Environment arg0, Class<?> arg1, PrintStream arg2) {
		
		arg2.println("===========================");
		arg2.println("=        jayamaha         =");
		arg2.println("===========================");
		
	}

}
