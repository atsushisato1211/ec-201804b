package jp.co.rakus.ec201804b.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginForm {
	
	private String name;
	@NotBlank(message = "メールアドレスを入力してください")
	@Size(min=0,max=100, message="100文字以内で入力してください")
	private String email;
	@NotBlank(message = "パスワードを入力してください")
	@Size(min=0, max=20, message="20文字以内で入力してください")
	private String password;

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
}