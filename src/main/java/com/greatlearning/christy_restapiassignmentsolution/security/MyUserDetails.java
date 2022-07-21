package com.greatlearning.christy_restapiassignmentsolution.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.greatlearning.christy_restapiassignmentsolution.model.Role;
import com.greatlearning.christy_restapiassignmentsolution.model.Users;

public class MyUserDetails implements UserDetails {

	private Users user;

	public MyUserDetails(Users user) {
		this.user = user;

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return this.user.getRoles().stream().map(Role::getName).map(roleName -> new SimpleGrantedAuthority(roleName))
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
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
