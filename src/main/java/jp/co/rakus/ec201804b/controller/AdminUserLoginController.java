package jp.co.rakus.ec201804b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.rakus.ec201804b.domain.AdminUser;
import jp.co.rakus.ec201804b.form.AdminUserLoginForm;
import jp.co.rakus.ec201804b.form.UserLoginForm;
import jp.co.rakus.ec201804b.repository.AdminUserRepository;

/**
 * 管理者がログインするコントローラー.
 * 
 * @author Nanami.Sasaki
 *
 */
@Controller
@RequestMapping(value="/admin")
public class AdminUserLoginController {
	@Autowired
	PasswordEncoder passwordEncoder;
	@ModelAttribute
	public AdminUserLoginForm setUpForm() {
		return new AdminUserLoginForm();
	}
	
	@RequestMapping("/index")
	public String index(AdminUserLoginForm form, BindingResult result, Model model,
			@RequestParam(required = false) String adminError) {
		System.err.println("login error:" + adminError);
		if (adminError != null) {
			System.err.println("admin: login failed");
			result.addError(new ObjectError("adminLoginError", "メールアドレスまたはパスワードが不正です。"));
		}
		return "administer/adminUserLogin";
	}
	
	
	/**
	 * @return　ログイン画面のJSPを表示するメソッド
	 */
//	@RequestMapping(value="/index")
//	public String index() {
//		return "/administer/adminUserLogin";
//	}
	
//	@RequestMapping(value="/login")
//	public String login(@Validated AdminUserLoginForm form,BindingResult result){
//		AdminUser adminUser=repository.findByEmail(form.getEmail());
//		
//		if(adminUser==null) {
//			result.rejectValue("email",null ,"メールアドレスが不正です");
//		}
//		//else if(!passwordEncoder.matches(adminUser.getPassword(), form.getPassword())) {
//				else if(!adminUser.getPassword().equals(form.getPassword())) {
//		result.rejectValue("password", null,"パスワードが合いません");
//		}
//		if(result.hasErrors()) {
//			return index();
//		}
//		return "redirect:/menu/";
//	}
}