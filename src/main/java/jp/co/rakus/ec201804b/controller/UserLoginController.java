package jp.co.rakus.ec201804b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.rakus.ec201804b.form.UserLoginForm;

/**
 * ユーザーがログインするコントローラー.
 * 
 * @author Nanami.Sasaki
 *
 */
@Controller
@RequestMapping(value = "/user")
public class UserLoginController {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@ModelAttribute
	public UserLoginForm setUpForm() {
		return new UserLoginForm();
	}

	/**
	 * JSPを呼び出すメソッド.
	 * 
	 * @return jspのリンク先を返す.
	 */
	@RequestMapping("/index")
	public String index(UserLoginForm form, BindingResult result, Model model,
			@RequestParam(required = false) String error) {
		System.err.println("login error:" + error);
		if (error != null) {
			System.err.println("user: login failed");
			result.addError(new ObjectError("loginError", "メールアドレスまたはパスワードが不正です。"));
		}
		return "user/login";
	}

//	/**
//	 * ユーザー情報をメールアドレスから検索してパスワードが一致するか調べるメソッド.
//	 * 
//	 * @param form ユーザーのログイン情報が入ったいformクラス
//	 * @param result BindingResult
//	 * @return　商品の一覧を表示するjspのリンク先を戻り値にしている
//	 */
//	@RequestMapping(value = "/login")
//	public String login(UserLoginForm form, BindingResult result) {
//		User user = repository.findByEmail(form.getEmail());
//
//		if (user == null) {
//			result.rejectValue("email", null, "メールアドレスが不正です");
//		}
//		//else if (!passwordEncoder.matches(user.getPassword(), form.getPassword())) {
//		else if(!user.getPassword().equals(form.getPassword())) {
//		result.rejectValue("pass", null, "パスワードが合いません");
//		}
//
//		if (result.hasErrors()) {
//			return index();
//		}
//		return "redirect:/item/";
//	}

}