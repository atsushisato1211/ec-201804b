package jp.co.rakus.ec201804b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ec201804b.domain.User;
import jp.co.rakus.ec201804b.form.UserLoginForm;
import jp.co.rakus.ec201804b.repository.UserRepository;

/**
 * ユーザーがログインするコントローラー.
 * 
 * @author Nanami.Sasaki
 *
 */
@Controller
@RequestMapping(value = "/")
public class UserLoginController {
	@Autowired
	private UserRepository repository;
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
	@RequestMapping(value = "/index")
	public String index() {
		return "user/login";

	}

	/**
	 * ユーザー情報をメールアドレスから検索してパスワードが一致するか調べるメソッド.
	 * 
	 * @param form ユーザーのログイン情報が入ったいformクラス
	 * @param result BindingResult
	 * @return　商品の一覧を表示するjspのリンク先を戻り値にしている
	 */
	@RequestMapping(value = "/login")
	public String login(@Validated UserLoginForm form, BindingResult result) {
		User user = repository.findByAddress(form.getEmail());

		if (user == null) {
			result.rejectValue("email", null, "メールアドレスが不正です");
		} else if (!passwordEncoder.matches(user.getPassword(), form.getPassword())) {
			result.rejectValue("pass", null, "パスワードが合いません");
		}

		if (result.hasErrors()) {
			return index();
		}
		return "/item";
	}
}