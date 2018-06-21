package jp.co.rakus.ec201804b.form;

public class ChangeUserPasswordForm {

	private String password;
	private String newPassword;
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
