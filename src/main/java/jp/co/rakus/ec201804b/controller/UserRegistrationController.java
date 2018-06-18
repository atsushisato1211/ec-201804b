package jp.co.rakus.ec201804b.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ec201804b.domain.User;
import jp.co.rakus.ec201804b.form.UserRegistrationForm;
import jp.co.rakus.ec201804b.repository.UserRepository;

@Controller
@Transactional
@RequestMapping(value = "registration")
public class UserRegistrationController {
	@Autowired
	private UserRepository userRepository;

	@ModelAttribute
	public UserRegistrationForm setUpForm() {
		return new UserRegistrationForm();
	}
	@RequestMapping(value = "form")
	public String form(Model model) {
		return "user/userRegistration";
	}
	@RequestMapping(value = "/create")
	public String Registration(@Validated UserRegistrationForm form, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return form(model);
		}
		User user = new User();
		BeanUtils.copyProperties(form, user);
		user.setTelephone(form.getTelephone());
		userRepository.insert(user);
		return "redirect:/index";//要編集
		
	}
}