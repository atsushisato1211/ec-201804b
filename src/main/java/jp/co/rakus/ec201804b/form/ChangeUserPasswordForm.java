package jp.co.rakus.ec201804b.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ChangeUserPasswordForm {

	@NotBlank(message="パスワードを入力してください")
	@Size(min=8 , max=16, message="8文字以上16時未満で入力してください")
	private String password;
	@NotBlank(message="パスワードを入力してください")
	@Size(min=8 , max=16, message="8文字以上16時未満で入力してください")
	private String newPassword;
	@NotBlank(message="パスワードを入力してください")
	@Size(min=8 , max=16, message="8文字以上16時未満で入力してください")
	private String newConfirmationPassword;

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewConfirmationPassword() {
		return newConfirmationPassword;
	}

	public void setNewConfirmationPassword(String newConfirmationPassword) {
		this.newConfirmationPassword = newConfirmationPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
