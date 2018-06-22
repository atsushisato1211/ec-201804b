package jp.co.rakus.ec201804b.controller;

import javax.servlet.http.HttpSession;

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

import jp.co.rakus.ec201804b.domain.LoginUser;
import jp.co.rakus.ec201804b.domain.User;
import jp.co.rakus.ec201804b.form.UserNewPasswordForm;
import jp.co.rakus.ec201804b.form.UserPasswordForgetForm;
import jp.co.rakus.ec201804b.repository.UserRepository;

@Controller
@RequestMapping(value="/user")
public class UserPasswordForgetController {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@ModelAttribute
	public UserPasswordForgetForm setUpForm() {
		return new UserPasswordForgetForm();
	}
	@ModelAttribute 
	public UserNewPasswordForm setForm() {
		return new UserNewPasswordForm();
	}
	
	
	@RequestMapping(value="/forget")
	public String forgetPassword() {
		return "/user/passwordForget";
	}
	
	@RequestMapping("/filloutpass")
	public String fillOutPass() {
		return "/user/forgetPassword";
	}
	
	@RequestMapping(value="/checkpassword")
	public String checkpassword(@AuthenticationPrincipal LoginUser loginUser,@Validated UserPasswordForgetForm form,BindingResult result,Model model,RedirectAttributes redirect) {
		//Long id=loginUser.getUser().getId();
		User user = repository.findByEmail(form.getEmail());
		session.setAttribute("user_id", user.getId());
		if(user.equals(null)) {
			result.rejectValue("email",null ,"eメールが一致しません");
		}
		
		String question = user.getQuestion();
		
		if( !form.getQuestion().equals(question) ) {
			result.rejectValue("question" , null,"解答に誤りがあります");
		}
		
		if(result.hasErrors()) {
			return forgetPassword();
		}
		redirect.addFlashAttribute("password",user.getPassword());
		
		return "redirect:/user/filloutpass";
	}
	
	@RequestMapping("/postpass")
	public String postNewPassword(@Validated UserNewPasswordForm form,BindingResult result) {
		Long id = (Long)session.getAttribute("user_id");
		
		if(!form.getNewPassword().equals(form.getConfirmationNewPassword())) {
			result.rejectValue("newPassword", null,"パスワードが一致しません");
		}
		if(result.hasErrors()) {
			return "/user/filloutpass";
		}
		String encodepass = passwordEncoder.encode(form.getNewPassword());
		repository.changeUserPassword(encodepass, id);
		
		return "redirect:/user/index";
	}
}