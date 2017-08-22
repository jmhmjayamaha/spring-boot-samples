package lk.harshana;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lk.harshana.config.CustomUserDetails;
import lk.harshana.repositories.UserRepository;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class Application 
{
    public static void main( String[] args )
    {
        SpringApplication.run(Application.class, args);
    }
    
    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, final UserRepository repo) throws Exception {
    	builder.userDetailsService(new UserDetailsService() {
			
			@Override
			public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
				// TODO Auto-generated method stub
				return new CustomUserDetails(repo.findByUsername(s));
			}
		});
    	
    }
}
