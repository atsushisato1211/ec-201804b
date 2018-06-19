package jp.co.rakus.ec201804b.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jp.co.rakus.ec201804b.domain.User;

/**
 * ログアウト関連処理を行うコントローラー.
 * @author Nanami.Sasaki
 *
 */
@Controller
@RequestMapping(value = "/logout")
@SessionAttributes("user")
public class UserLogoutController {

	/**
	 * セッション情報に含まれるMemberオブジェクトをクリアします.
	 * @param member Sessionに入っているメンバー情報
	 * @param sessionStatus　セッションステータス
	 * @return　ログイン画面
	 */
	@RequestMapping(value = "sessionInvalidate")
	public String sessionInvalidate(User user, SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/index";
	}

}