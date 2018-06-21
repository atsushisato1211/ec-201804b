package jp.co.rakus.ec201804b.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class LoginAdminUser extends org.springframework.security.core.userdetails.User {
	private static final long serialVersionUID = 1L;
	
	private final AdminUser adminUser;
	
	public LoginAdminUser(AdminUser adminUser, Collection<GrantedAuthority> authorityList) {
		super(adminUser.getEmail(), adminUser.getPassword(), authorityList);
		this.adminUser = adminUser;
		
	}
	
	public AdminUser getAdminUser() {
		return adminUser;
	}
}
