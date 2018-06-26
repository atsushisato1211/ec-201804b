package jp.co.rakus.ec201804b.form;

import javax.validation.constraints.NotBlank;

public class UserContactForm {
	/** 投稿者名 */
	@NotBlank(message="タイトルを記入してください")
	private String name;
	/** 投稿内容 */
	@NotBlank(message="本文を記入してください")
	private String content;
	
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
}
