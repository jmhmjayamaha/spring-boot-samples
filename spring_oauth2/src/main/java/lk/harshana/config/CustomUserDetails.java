package lk.harshana.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lk.harshana.entities.Role;
import lk.harshana.entities.User;

public class CustomUserDetails implements UserDetails {

	private Collection<? extends GrantedAuthority> authorities;
    private String password;
    private String username;
	
	public CustomUserDetails(User byUserName) {
		this.username = byUserName.getUsername();
		this.password = byUserName.getPassword();
		
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		for(Role role : byUserName.getRoles()) {
			auths.add(new SimpleGrantedAuthority(role.getName().toUpperCase()));
		}
		
		this.authorities = auths;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
