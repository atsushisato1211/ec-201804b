package jp.co.rakus.ec201804b.form;

public class UserRegistrationForm {

	private String name;
	private String email;
	private String password;
	private String confirmationpassword;
	private String zipCode;
	private String address;
	private String telephone;

	private String telephone1;
	private String telephone2;
	private String telephone3;

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
		return zipCode;
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

	@Override
	public String toString() {
		return "UserRegistrationForm [name=" + name + ", email=" + email + ", password=" + password + ", zipCode="
				+ zipCode + ", address=" + address + ", telephone1=" + telephone1 + ", telephone2=" + telephone2
				+ ", telephone3=" + telephone3 + "]";
	}

}
