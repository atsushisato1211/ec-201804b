package jp.co.rakus.ec201804b.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

public class ItemForm {
	private Long id;
	@NotBlank(message="商品名を入力してください")
	private String name;
	@NotBlank(message="商品説明を入力してください")
	private String description;
	@NotNull(message="商品価格を入力してください")
	private Integer price;
	@NotNull(message="画像をアップロードしてください")
	private MultipartFile imagePath;
	private Boolean deleted;
	
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public MultipartFile getImagePath() {
		return imagePath;
	}
	public void setImagePath(MultipartFile imagePath) {
		this.imagePath = imagePath;
	}
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
		
	}
}
