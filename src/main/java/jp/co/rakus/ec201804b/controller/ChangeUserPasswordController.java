package jp.co.rakus.ec201804b.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import jp.co.rakus.ec201804b.domain.LoginUser;
import jp.co.rakus.ec201804b.domain.User;
import jp.co.rakus.ec201804b.form.ChangeUserPasswordForm;
import jp.co.rakus.ec201804b.repository.UserRepository;

@Controller
@RequestMapping(value="/user")
public class ChangeUserPasswordController {
	
	@Autowired
	private UserRepository repository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@ModelAttribute
	public ChangeUserPasswordForm setUp() {
		return new ChangeUserPasswordForm();
	}
	
	@RequestMapping(value="/password")
	public String form(Model model) {
		return "user/changeUserPassword";
	}
	
	@RequestMapping(value="/change")
	public String change(@AuthenticationPrincipal LoginUser loginUser,@Validated ChangeUserPasswordForm form ,BindingResult result,RedirectAttributes attribute,Model model) {
		Long id=loginUser.getUser().getId();
		User user = new User();
		if (!form.getNewPassword().equals(form.getNewConfirmationPassword())) {
			result.rejectValue("newConfirmationPassword", null, "設定したパスワードを再度入力して下さい");
		}
		BeanUtils.copyProperties(form, user);
		String encryptionPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encryptionPassword);
		user.setId(id);
		repository.changeUserPassword(user);
		return "redirect:/user/index";
	}
	

}
