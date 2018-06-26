package jp.co.rakus.ec201804b.domain;

public class UserContact {

	/** 投稿者名 */
	private String name;
	/** 投稿内容 */
	private String content;
	/** メールアドレス*/
	private String email;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}