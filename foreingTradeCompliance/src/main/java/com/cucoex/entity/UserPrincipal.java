package com.cucoex.entity;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;



public class UserPrincipal  implements UserDetails{


    private Collection<? extends GrantedAuthority> authorities;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private String confirmPassword;
	private Calendar created;
	private Set<Role> roles;
	private Set<Company> companies;
	
	public UserPrincipal() {
		
	}

    public static UserPrincipal build(User user){
        List<GrantedAuthority> authorities =
                user.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getDescription()
                )).collect(Collectors.toList());
        return new UserPrincipal(authorities,user.getFirstName(),user.getLastName(),user.getEmail(),user.getUsername(),user.getPassword(),user.getConfirmPassword(),user.getCreated(),user.getRoles(),user.getCompanies());
    }

	/**
	 * @param authorities
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param username
	 * @param password
	 * @param confirmPassword
	 * @param created
	 * @param roles
	 * @param companies
	 */
	public UserPrincipal(Collection<? extends GrantedAuthority> authorities, String firstName, String lastName,
			String email, String username, String password, String confirmPassword, Calendar created, Set<Role> roles,
			Set<Company> companies) {
		super();
		this.authorities = authorities;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.created = created;
		this.roles = roles;
		this.companies = companies;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}
    
}

