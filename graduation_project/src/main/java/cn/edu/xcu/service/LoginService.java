package cn.edu.xcu.service;

import cn.edu.xcu.entity.MyUserDetails;

public interface LoginService {
	
	MyUserDetails findByUsername(String username);

}
