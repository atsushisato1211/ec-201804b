package jp.co.rakus.ec201804b.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/admin")
public class AdminUserLoginController {
	
	@RequestMapping(value="/login")
	public String login() {
		
		return "";
	}
}