package cn.edu.xcu.config;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import cn.edu.xcu.service.impl.MetroUserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MetroUserDetailsServiceImpl metroUserDetailsService;

	/**
	 * http请求安全处理
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/login**").anonymous()
			.anyRequest().permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(metroUserDetailsService)
			.passwordEncoder(new PasswordEncoder() {
				
				@Override
				public boolean matches(CharSequence rawPassword, String encodedPassword) {
					StringBuffer stringBuffer = new StringBuffer();
					MessageDigest messageDigest = null;
					try {
						messageDigest = MessageDigest.getInstance("MD5");
					} catch (NoSuchAlgorithmException e) {
						e.printStackTrace();
					}
					messageDigest.update(((String)rawPassword).getBytes());
					for (Byte b : messageDigest.digest()) {
						stringBuffer.append(String.format("%02X", b));
					}
					//登录结果
					boolean flag = encodedPassword.equals(stringBuffer.toString());
					return flag;
				}
				
				@Override
				public String encode(CharSequence rawPassword) {
					StringBuffer stringBuffer = new StringBuffer();
					MessageDigest messageDigest = null;
					try {
						messageDigest = MessageDigest.getInstance("MD5");
					} catch (NoSuchAlgorithmException e) {
						e.printStackTrace();
					}
					messageDigest.update(((String)rawPassword).getBytes());
					for (Byte b : messageDigest.digest()) {
						stringBuffer.append(String.format("%02X", b));
					}
					return stringBuffer.toString();
				}
			});
	}
}
