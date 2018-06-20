package jp.co.rakus.ec201804b.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/")
public class Error404 {
	
	@RequestMapping(value="/error404")
	public String not() {
		System.out.println("404 not found");
		return "user/error404";
	}
}