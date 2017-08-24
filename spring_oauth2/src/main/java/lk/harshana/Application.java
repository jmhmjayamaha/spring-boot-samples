package lk.harshana;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lk.harshana.config.CustomUserDetails;
import lk.harshana.entities.Role;
import lk.harshana.entities.User;
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
    	if (repo.count()==0)
			repo.save(new User("user", "user", Arrays.asList(new Role("USER"), new Role("ACTUATOR"))));
    	
    	builder.userDetailsService(new UserDetailsService() {
			
			@Override
			public UserDetails loadUserByUsername( String s) throws UsernameNotFoundException {
				// TODO Auto-generated method stub
				return new CustomUserDetails(repo.findByUsername(s));
			}
		});
    	
    }
}
