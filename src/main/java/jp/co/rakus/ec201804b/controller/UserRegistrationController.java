package jp.co.rakus.ec201804b.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	private PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@ModelAttribute UserRegistrationForm setUpForm() {
		return new UserRegistrationForm();
	}

	@RequestMapping(value = "form")
	public String form(Model model) {
		return "user/userRegistration";
	}

	@RequestMapping(value = "/create")
	public String Registration(@Validated UserRegistrationForm form, BindingResult result, Model model) {
		User user = new User();
		if (!form.getPassword().equals(form.getConfirmationpassword())) {
			result.rejectValue("confirmationpassword", "", "パスワードが一致しません");
		}
		if (userRepository.findByEmail(form.getEmail()) != null) {
			result.rejectValue("email", "", "そのアドレスはすでに使われています");
		}
		if (result.hasErrors()) {
			return form(model);
		}
		BeanUtils.copyProperties(form, user);
		user.setTelephone(form.getTelephone());
		String encryptionPassword = passwordEncoder.encode(user.getPassword());
		System.out.println(user.getPassword());
		user.setPassword(encryptionPassword);
		System.out.println(user.getPassword());
		userRepository.insert(user);
		return "redirect:/index";// 要編集

	}
}