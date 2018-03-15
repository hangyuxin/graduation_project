package cn.edu.xcu.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import cn.edu.xcu.entity.MyUserDetails;
import cn.edu.xcu.service.LoginService;

@Service
public class UserOperationServiceImpl implements LoginService {

	@Override
	public MyUserDetails findByUsername(String userName) {
		List<GrantedAuthority> list = new LinkedList<>();
		list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		StringBuffer stringBuffer = new StringBuffer();
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		messageDigest.update("user".getBytes());
		for (Byte b : messageDigest.digest()) {
			stringBuffer.append(String.format("%02X", b));
		}
		return new MyUserDetails("user",stringBuffer.toString(),"杭玉鑫",list);
	}

}
