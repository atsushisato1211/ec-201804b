package jp.co.rakus.ec201804b.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/")
public class Error500 {

	@RequestMapping(value="/error500")
	public String not() {
		System.out.println("500 not found");
	    return "user/error500";
		}
}