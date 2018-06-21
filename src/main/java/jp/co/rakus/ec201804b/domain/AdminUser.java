package jp.co.rakus.ec201804b.domain;

/**
 * 管理者情報に関するクラスです.
 * @author nobuteru.kato
 *
 */
public class AdminUser {
	/**
	 * ID
	 */
	private Long id;
	/**
	 * 名前
	 */
	private String name;
	/**
	 * メールアドレス
	 */
	private String email;
	/**
	 * パスワード
	 */
	private String password;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
}