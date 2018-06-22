package jp.co.rakus.ec201804b.form;

public class UserPasswordForgetForm {
	
	
	/**
	 *　メールアドレス
	 */
	private String email;
	/**
	 * 確認用メールアドレス
	 */
	private String question;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
}
