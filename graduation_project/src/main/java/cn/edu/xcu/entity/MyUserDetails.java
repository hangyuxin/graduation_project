package cn.edu.xcu.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {

	//用户名
	private final String username;
	//用户密码
	private final String password;
	//用户姓名
	private final String name;
	//用户角色列表
	private final List<GrantedAuthority> roleName;
	private final Boolean accountNonExpired;
	private final Boolean accountNonLocked;
	private final Boolean credentialsNonExpired;
	private final Boolean enabled;

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public String getName() {
		return name;
	}

	public List<GrantedAuthority> getRoleName() {
		return roleName;
	}

	@Override
	public String toString() {
		return "MyUserDetails [username=" + username + ", password=" + password + ", name=" + name + ", roleName="
				+ roleName + ", accountNonExpired=" + accountNonExpired + ", accountNonLocked=" + accountNonLocked
				+ ", credentialsNonExpired=" + credentialsNonExpired + ", enabled=" + enabled + "]";
	}

	public MyUserDetails(String username, String password,String name, List<GrantedAuthority> roleName) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.roleName = roleName;
		accountNonExpired = true;
		accountNonLocked = true;
		credentialsNonExpired = true;
		enabled = true;
	}

	public MyUserDetails(String username, String password,String name, List<GrantedAuthority> roleName,Boolean accountNonExpired,Boolean accountNonLocked,Boolean credentialsNonExpired,Boolean enabled) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.roleName = roleName;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roleName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

}
