package jp.co.rakus.ec201804b.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.rakus.ec201804b.domain.LoginUser;
import jp.co.rakus.ec201804b.domain.User;
import jp.co.rakus.ec201804b.form.UserInfoUpdateForm;
import jp.co.rakus.ec201804b.repository.UserRepository;

@Controller
@RequestMapping(value="/user")
public class UserInfoUpdateController {
	
	@Autowired
	private UserRepository repository;
	
	@ModelAttribute
	public UserInfoUpdateForm setUp() {
		return new UserInfoUpdateForm();
	}
	
	/**
	 * ユーザー情報変更のページに遷移する.
	 * 
	 * @param model　Model
	 * @return　JSPのリンク先
	 */
	@RequestMapping(value = "/info")
	public String form(Model model) {
		return "user/userInfoUpdate";
	}

	/**
	 * 利用者情報変更処理を行うメソッドです.
	 * @param form フォーム
	 * @param result エラー内容
	 * @param redirectAttributes
	 * @param model
	 * @return 利用者のログイン画面
	 */
	@RequestMapping(value="/update")
	public String Update(@AuthenticationPrincipal LoginUser loginUser,  @Validated UserInfoUpdateForm form, BindingResult result, RedirectAttributes redirectAttributes,Model model) {
		Long id=loginUser.getUser().getId();
		User user = new User();
		Boolean isZipCodeError = false;
		Boolean isTelephoneError = false;
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
		
		if (repository.findByEmail(form.getEmail()) != null) {
			result.rejectValue("email", null, "そのアドレスはすでに使われています");
		}
		if (result.hasErrors()) {
			System.out.println(result);
			return form(model);
		}
		BeanUtils.copyProperties(form, user);
		user.setId(id);
		user.setTelephone(form.getTelephone());
		user.setZipCode(form.getZipCode());
		repository.update(user);
		return "redirect:/user/index";
	}
}