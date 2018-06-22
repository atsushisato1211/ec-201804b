package jp.co.rakus.ec201804b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ec201804b.domain.LoginUser;
import jp.co.rakus.ec201804b.domain.User;
import jp.co.rakus.ec201804b.form.UserPasswordForgetForm;
import jp.co.rakus.ec201804b.repository.UserRepository;

@Controller
@RequestMapping(value="/user")
public class UserPasswordForgetController {
	
	@Autowired
	private UserRepository repository;
	
	@ModelAttribute
	public UserPasswordForgetForm setUpForm() {
		return new UserPasswordForgetForm();
	}
	
	@RequestMapping(value="/forget")
	public String forgetPassword(Model model) {
		return "/user/passwordForget";
	}
	
	@RequestMapping(value="/checkpassword")
	public String checkpassword(@AuthenticationPrincipal LoginUser loginUser,@Validated UserPasswordForgetForm form,BindingResult result,Model model) {
		Long id=loginUser.getUser().getId();
		String email=repository.load(id).getEmail();
		String question=repository.load(id).getQuestion();
		
		if( ( !form.getEmail().equals(email) ) || ( !form.getQuestion().equals(question) ) ) {
		}
		if(result.hasErrors()) {
			return forgetPassword(model);
		}
		User user=repository.searchByEmailAndQuestion(form.getEmail(), form.getQuestion());
		model.addAttribute("user", user);
		return "redirect:/user/passwordForget";
	}
}