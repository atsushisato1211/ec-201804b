package jp.co.rakus.ec201804b.form;

public class ArticleForm {

	/** 投稿者名 */
	private String name;
	/** 投稿内容 */
	private String content;
	
	public String getName() {
		return name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
