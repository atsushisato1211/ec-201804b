package jp.co.rakus.ec201804b.form;

public class UserLoginForm {

	private long name;
	private String email;
	private String password;

	public long getName() {
		return name;
	}
	public void setName(long name) {
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