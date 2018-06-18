package jp.co.rakus.ec201804b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ec201804b.domain.User;
import jp.co.rakus.ec201804b.form.UserLoginForm;
import jp.co.rakus.ec201804b.repository.UserRepository;

@Controller
@RequestMapping(value="/")
public class UserLoginController {
	@Autowired
	private UserRepository repository;
	@ModelAttribute
	public UserLoginForm setUpForm() {
		return new UserLoginForm();
	}

	@Autowired
	PasswordEncoder passwordEncoder;

	@RequestMapping(value = "/index")
	public String index() {
		return "user/login";

	}
	@RequestMapping(value = "/login")
	public String login(UserLoginForm form, BindingResult result) {
		User user = repository.findByAddress(form.getEmail());

		if (user == null) {
			result.rejectValue("email", null, "メールアドレスが不正です");
		} else if (!passwordEncoder.matches(user.getPassword(), form.getPassword())) {
			result.rejectValue("pass", null, "パスワードが合いません");
		}
		
		if (result.hasErrors()) {
			return index();
		}
		return "一覧ページのパス";
	}
}