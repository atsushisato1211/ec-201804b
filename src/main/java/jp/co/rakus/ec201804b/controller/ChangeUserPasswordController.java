package jp.co.rakus.ec201804b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ec201804b.domain.LoginUser;
import jp.co.rakus.ec201804b.form.ChangeUserPasswordForm;
import jp.co.rakus.ec201804b.repository.UserRepository;

/**
 * ユーザーのパスワード変更を行うメソッド.
 * 
 * @author Nanami.Sasaki
 *
 */
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
	
	/**
	 * jspを表示するメソッド.
	 * 
	 * @param model　Model
	 * @return　JSPのパスを返す
	 */
	@RequestMapping(value="/password")
	public String form(Model model) {
		return "user/changeUserPassword";
	}
	
	/**
	 * JSPを表示するメソッド.
	 * 
	 * @param loginUser　LoginUser
	 * @param form　ChangeUserPasswordForm
	 * @param result　BindingResult
	 * @param attribute　RedirectAttributes
	 * @param model　Model
	 * @return　JSPのパスが戻り値になっている
	 */
	@RequestMapping(value="/change")
	public String change(@AuthenticationPrincipal LoginUser loginUser,@Validated ChangeUserPasswordForm form ,BindingResult result,Model model) {
		Long id=loginUser.getUser().getId();
		String password = form.getPassword();
		String encodePassword = repository.load(id).getPassword();
		if(!passwordEncoder.matches(password, encodePassword)) {
			result.rejectValue("password",null,"パスワードが一致しません");
		}
		
		if (!form.getNewPassword().equals(form.getNewConfirmationPassword())) {
			result.rejectValue("newConfirmationPassword", null, "設定したパスワードを再度入力して下さい");
		}
		if(result.hasErrors()) {
			
			return form(model);
		}
		String encryptionPassword = passwordEncoder.encode(form.getNewConfirmationPassword());
		repository.changeUserPassword(encryptionPassword,id);
		return "redirect:/user/index";
	}
}