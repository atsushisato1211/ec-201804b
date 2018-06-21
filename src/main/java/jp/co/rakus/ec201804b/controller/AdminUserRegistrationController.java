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

import jp.co.rakus.ec201804b.domain.AdminUser;
import jp.co.rakus.ec201804b.form.AdminUserRegistrationForm;
import jp.co.rakus.ec201804b.repository.AdminUserRepository;

/**
 * @author nobuteru.kato
 * 管理者登録を行うコントローラです.
 */
@Controller
@Transactional
@RequestMapping(value = "/admin")
public class AdminUserRegistrationController {
	@Autowired
	private AdminUserRepository adminUserLoginRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@ModelAttribute
	private AdminUserRegistrationForm setUpForm() {
		return new AdminUserRegistrationForm();
	}
	/**
	 * 管理者登録ページを表示します.
	 * @param model
	 * @return 管理者登録ページ
	 */
	@RequestMapping(value = "/form")
	public String form(Model model) {
		return "administer/adminUserRegistration";
	}
	
	/**
	 * 管理者の登録に関する処理を行います.
	 * @param form フォーム
	 * @param result エラー情報
	 * @param redirectAttributes
	 * @param model
	 * @return 管理者ログインページ
	 */
	@RequestMapping(value = "/create")
	public String Registration(@Validated AdminUserRegistrationForm form,BindingResult result,RedirectAttributes redirectAttributes, Model model) {
	AdminUser adminUser = new AdminUser();
	if (!form.getPassword().equals(form.getConfirmationpassword())) {
		result.rejectValue("confirmationpassword", null, "設定したパスワードを再度入力して下さい");
	}
	if (adminUserLoginRepository.findByEmail(form.getEmail()) != null) {
		result.rejectValue("email", null, "そのアドレスはすでに使われています");
	}
	if(result.hasErrors()) {
		return form(model);
	}
	BeanUtils.copyProperties(form, adminUser);
	String encryptionPassword = passwordEncoder.encode(adminUser.getPassword());
	adminUser.setPassword(encryptionPassword);
	adminUserLoginRepository.insert(adminUser);
	return "redirect:/admin/index";
	}
	
}
