package jp.co.rakus.ec201804b.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserNewPasswordForm {

	/**
	 * 新しいパスワード
	 */	
	@NotBlank(message = "パスワードを入力してください")
	@Size(min=8, max=16, message="8桁以上16桁以内で設定してください")
	private String newPassword;
	/**
	 * 確認用パスワード
	 */
	@NotBlank(message = "確認用パスワードを入力してください")
	@Size(min=8, max=16, message="8桁以上16桁以内で設定してください")
	private String confirmationNewPassword;
	
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConfirmationNewPassword() {
		return confirmationNewPassword;
	}
	public void setConfirmationNewPassword(String confirmationNewPassword) {
		this.confirmationNewPassword = confirmationNewPassword;
	}
}