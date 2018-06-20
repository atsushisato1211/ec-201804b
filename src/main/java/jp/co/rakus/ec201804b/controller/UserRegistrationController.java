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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.rakus.ec201804b.domain.User;
import jp.co.rakus.ec201804b.form.UserRegistrationForm;
import jp.co.rakus.ec201804b.repository.UserRepository;

@Controller
@Transactional
@RequestMapping(value = "/registration")
public class UserRegistrationController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	

	@ModelAttribute
	UserRegistrationForm setUpForm() {
		return new UserRegistrationForm();
	}

	@RequestMapping(value = "/form")
	public String form(Model model) {
		return "user/userRegistration";
	}

	@RequestMapping(value = "/create")
	public String Registration(@Validated UserRegistrationForm form, BindingResult result, RedirectAttributes redirectAttributes,Model model) {
		User user = new User();
		if (!form.getPassword().equals(form.getConfirmationpassword())) {
			result.rejectValue("confirmationpassword", null, "設定したパスワードを再度入力して下さい");
		}
		if (userRepository.findByEmail(form.getEmail()) != null) {
			result.rejectValue("email", null, "そのアドレスはすでに使われています");
		}
		if(form.getZipCode1().isEmpty() && form.getZipCode2().isEmpty()) {
			result.rejectValue("zipCode1", null, "郵便番号入力して下さい");
		}else if(form.getZipCode1().isEmpty() || form.getZipCode2().isEmpty()) {
			result.rejectValue("zipCode1", null, "郵便番号を正しく入力して下さい");
		}
		if(form.getTelephone1().isEmpty() && form.getTelephone2().isEmpty() && form.getTelephone3().isEmpty()) {
			result.rejectValue("telephone1",null,"電話番号を入力して下さい");
		}else if(form.getTelephone1().isEmpty()|| form.getTelephone2().isEmpty()|| form.getTelephone3().isEmpty()) {
			result.rejectValue("telephone1", null,"電話番号を正しく入力して下さい");
		}
		if (result.hasErrors()) {
			System.out.println(result);
			return form(model);
		}
		BeanUtils.copyProperties(form, user);
		user.setTelephone(form.getTelephone());
		String encryptionPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encryptionPassword);
		user.setZipCode(form.getZipCode());
		userRepository.insert(user);
		return "redirect:/index";// 要編集

	}
}