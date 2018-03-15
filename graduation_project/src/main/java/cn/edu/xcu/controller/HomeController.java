package cn.edu.xcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	/**
	 * @Description 登录、登录失败、退出登录
	 * @Title metroLogin
	 * @param error(如不为空，代表登录错误)
	 * @param loginOut(如不为空，代表退出登录)
	 * @param model
	 * @return 登录页面的地址
	 */
	@GetMapping("/loginPage")
	public String metroLogin(Model model,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "loginOut", required = false) String loginOut) {
		if (error != null) {
			model.addAttribute("loginMsg", "用户名或密码错误！");
		} else if (loginOut != null) {
			model.addAttribute("loginMsg", "您已成功退出");
		}
		return "login/login";
	}

	/**
	 * @Description 访问主页
	 * @Title homePage
	 * @return 主页的html页面相对地址
	 */
	@GetMapping("/")
	public String homePage(Model model) {
		return "index";
	}

}
