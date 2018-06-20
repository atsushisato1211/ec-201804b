package jp.co.rakus.ec201804b.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AdminUserRegistrationForm {
	@NotBlank(message="お名前を入力して下さい")
	private String name;
	@Email(message="アドレスが不正です")
	@NotBlank(message="アドレスを入力して下さい")
	private String email;
	@NotBlank(message="パスワードを入力してください")
	@Size(min=8,max=16,message="8桁以上16桁以下で設定してください")
	private String password;
	@NotBlank(message="確認用パスワードを入力してください")
	private String confirmationpassword;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmationpassword() {
		return confirmationpassword;
	}
	public void setConfirmationpassword(String confirmationpassword) {
		this.confirmationpassword = confirmationpassword;
	}
}
