package cn.edu.xcu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import cn.edu.xcu.entity.MyUserDetails;
import cn.edu.xcu.service.LoginService;

@Component
public class MetroUserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private LoginService loginService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MyUserDetails myUserDetails = loginService.findByUsername(username);
		if(myUserDetails == null) {
			throw new UsernameNotFoundException("");
		}
		return myUserDetails;
	}
	
}
