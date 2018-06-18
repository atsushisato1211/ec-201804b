package jp.co.rakus.ec201804b.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/logout")
public class UserLogoutController {
	
	@RequestMapping(value="/")
	public String logout() {
		return "/";
	}

}
