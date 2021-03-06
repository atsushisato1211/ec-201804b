package jp.co.rakus.ec201804b.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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


/**
 * 利用者に関する処理を行うコントローラです.
 * @author @{nobuteru.kato}
 *
 */
@Controller
@Transactional
@RequestMapping(value = "user/")
public class UserRegistrationController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	

	@ModelAttribute
	UserRegistrationForm setUpForm() {
		return new UserRegistrationForm();
	}

	/**
	 * 初期画面を表示するためのメソッドです.
	 * @param model
	 * @return 利用者登録画面
	 */
	@RequestMapping(value = "/form")
	public String form(Model model) {
		return "user/userRegistration";
	}

	/**
	 * 利用者登録処理を行うメソッドです.
	 * @param form フォーム
	 * @param result エラー内容
	 * @param redirectAttributes
	 * @param model
	 * @return 利用者のログイン画面
	 */
	@RequestMapping(value = "/create")
	public String Registration(@Validated UserRegistrationForm form, BindingResult result, RedirectAttributes redirectAttributes,Model model) {
		User user = new User();
		Boolean isZipCodeError = false;
		Boolean isTelephoneError = false;
		if (!form.getPassword().equals(form.getConfirmationpassword())) {
			result.rejectValue("confirmationpassword", null, "設定したパスワードを再度入力して下さい");
		}
		if (userRepository.findByEmail(form.getEmail()) != null) {
			result.rejectValue("email", null, "そのアドレスはすでに使われています");
		}
		if(!isZipCodeError) {
		if(form.getZipCode1().isEmpty() && form.getZipCode2().isEmpty()) {
			result.rejectValue("zipCode1", null, "郵便番号には数字を入力して下さい");
			isZipCodeError = true;
		}else if(form.getZipCode1().isEmpty() || form.getZipCode2().isEmpty()) {
			result.rejectValue("zipCode1", null, "郵便番号には数字を入力して下さい");
			isZipCodeError = true;
		}
		}
		if(!isZipCodeError) {
		if(form.getZipCode1().matches("\\d{3}") == false || form.getZipCode2().matches("\\d{4}") == false){
			result.rejectValue("zipCode1", null, "郵便番号には数字を入力して下さい");
			isZipCodeError = true;
		}
		}
		if(!isTelephoneError) {
		if(form.getTelephone1().isEmpty() && form.getTelephone2().isEmpty() && form.getTelephone3().isEmpty()) {
			result.rejectValue("telephone1",null,"電話番号には数字を入力して下さい");
			isTelephoneError = true;
		}else if(form.getTelephone1().isEmpty()|| form.getTelephone2().isEmpty()|| form.getTelephone3().isEmpty()) {
			result.rejectValue("telephone1", null,"電話番号には数字を入力して下さい");
			isTelephoneError = true;
		}
		}
		if(!isTelephoneError) {
		if(form.getTelephone1().matches("\\d{3}|\\d{2}") == false || form.getTelephone2().matches("\\d{4}") == false || form.getTelephone3().matches("\\d{4}") == false) {
			result.rejectValue("telephone1", null,"電話番号には数字を入力して下さい");
			isTelephoneError = true;
		} 
		}
		if(form.getQuestion().equals("")) {
			result.rejectValue("question", null, "旧姓を入力して下さい");
		}else if(form.getQuestion().matches("\\d") == true) {
			result.rejectValue("question", null, "旧姓を入力して下さい");
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
		return "redirect:/user/index";// 要編集

	}
}