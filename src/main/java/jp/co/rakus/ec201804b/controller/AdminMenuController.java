package jp.co.rakus.ec201804b.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class AdminMenuController {

	@RequestMapping("/")
	public String index() {
		return "administer/menu";
	}
	
	@RequestMapping("/regist")
	public String regist() {
		return "administer/regist";
	}
	
	@RequestMapping("viewList")
	public String listview() {
		return "administer/viewList";
	}
	
}
