package jp.co.rakus.ec201804b.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jp.co.rakus.ec201804b.domain.AdminUser;

/**
 * ログアウトの処理を行うコントローラー.
 * 
 * @author Nanami.Sasaki
 *
 */
@Controller
@RequestMapping(value="/session")
@SessionAttributes("adminUser")
public class AdminUserLogoutController {
	
	@RequestMapping(value="logout")
	public String sessionLogout(AdminUser adminUser,SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redurect:/admin/index";
	}

}
