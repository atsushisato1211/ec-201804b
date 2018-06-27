package jp.co.rakus.ec201804b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ec201804b.domain.LoginUser;
import jp.co.rakus.ec201804b.form.UserContactForm;

@Controller
@RequestMapping("/user")
public class UserContactController {
	
	
	@Autowired
	MailContact mail;
	
	@ModelAttribute
	public UserContactForm setForm() {
		return new UserContactForm();
	}

	@RequestMapping("/recontact")
	public String contact() {
		return "/user/userContact";
	}
	@RequestMapping("/finish")
	public String contactfinish() {
		return "/user/userContactFinish";
	}
	
	@RequestMapping("/contact")
	public String request(@Validated UserContactForm form , BindingResult result,@AuthenticationPrincipal LoginUser loginUser) {

		if(result.hasErrors()) {
			return contact();
		}
		mail.send(form.getName(), form.getContent(), loginUser);
		
		return "redirect:/user/finish";
	}
}
