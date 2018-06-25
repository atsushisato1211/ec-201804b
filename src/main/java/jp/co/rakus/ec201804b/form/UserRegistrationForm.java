package jp.co.rakus.ec201804b.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



public class UserRegistrationForm {
	/**
	 * 名前
	 */
	@NotBlank(message="お名前を入力して下さい")
	private String name;
	/**
	 * メールアドレス
	 */
	@Email(message="アドレスが不正です")
	@NotBlank(message="アドレスを入力して下さい")
	private String email;
	/**
	 * パスワード
	 */
	@NotBlank(message="パスワードを入力してください")
	@Size(min=8,max=16,message="8桁以上16桁以下で設定してください")
	private String password;
	/**
	 * 確認用パスワード
	 */
	@NotBlank(message="確認用パスワードを入力してください")
	private String confirmationpassword;
	//@NotBlank(message="郵便番号を入力して下さい")
	/**
	 * 郵便番号
	 */
	private String zipCode;
	/**
	 * 郵便番号の左3桁
	 */
	private String zipCode1;
	/**
	 * 郵便番号の右4桁
	 */
	private String zipCode2;
	/**
	 * 住所
	 */
	@NotBlank(message="住所を入力して下さい")
	private String address;
	//@NotBlank(message="電話番号を入力してください")
	/**
	 * 電話番号
	 */
	private String telephone;
	/**
	 * 電話番号の左側
	 */
	private String telephone1;
	/**
	 * 電話番号の真ん中
	 */
	private String telephone2;
	/**
	 * 電話番号の右側
	 */
	private String telephone3;
	/**
	 * 秘密の質問
	 */
	private String question;

	public String getZipCode1() {
		return zipCode1;
	}

	public void setZipCode1(String zipCode1) {
		this.zipCode1 = zipCode1;
	}

	public String getZipCode2() {
		return zipCode2;
	}

	public void setZipCode2(String zipCode2) {
		this.zipCode2 = zipCode2;
	}

	public String getConfirmationpassword() {
		return confirmationpassword;
	}

	public void setConfirmationpassword(String confirmationpassword) {
		this.confirmationpassword = confirmationpassword;
	}

	public String getTelephone() {
		return telephone1 + "-" + telephone2 + "-" + telephone3;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone1 + "-" + telephone2 + "-" + telephone3;
	}

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

	public String getZipCode() {
		return zipCode1 + "-" + zipCode2;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone1() {
		return telephone1;
	}

	public void setTelephone1(String telephone1) {
		this.telephone1 = telephone1;
	}

	public String getTelephone2() {
		return telephone2;
	}

	public void setTelephone2(String telephone2) {
		this.telephone2 = telephone2;
	}

	public String getTelephone3() {
		return telephone3;
	}

	public void setTelephone3(String telephone3) {
		this.telephone3 = telephone3;
	}

	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	@Override
	public String toString() {
		return "UserRegistrationForm [name=" + name + ", email=" + email + ", password=" + password + ", zipCode="
				+ zipCode + ", address=" + address + ", telephone1=" + telephone1 + ", telephone2=" + telephone2
				+ ", telephone3=" + telephone3 + " question= " +question +"]";
	}


}
