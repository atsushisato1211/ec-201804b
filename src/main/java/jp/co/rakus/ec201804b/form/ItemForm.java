package jp.co.rakus.ec201804b.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

public class ItemForm {
	private Long id;
	@NotBlank(message="商品名を入力して下さい")
	private String name;
	@NotBlank(message="説明を入力してください")
	private String description;
	@NotNull(message="価格を入力してください")
	@Range(min=1, max=1000000 ,message="正しい数字を入力して下さい")
	private Integer price;
	@NotNull(message="画像をアップロードしてください")
	private MultipartFile imagePath;
	private Boolean deleted;
	@NotBlank(message="生産地を入力してください")
	private String producingArea;
	@NotBlank(message="季節を入力してください")
	private String season;
	
	@NotNull(message="在庫数を入力してください")
	@Range(min=1, max=1000000 ,message="正しい数字を入力して下さい")
	private Integer stock;
	

	
	
	
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
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
	public String getProducingArea() {
		return producingArea;
	}
	public void setProducingArea(String producingArea) {
		this.producingArea = producingArea;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
}
