package jp.co.rakus.ec201804b.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

public class OrderItemForm {

	private Integer id;
	private Integer itemId;
	private Integer orderId;
	@Range(min=1,max=1000,message="1~1000までの範囲で入力してください")
	@NotNull(message="個数を入力してください")
	private Integer quantity;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
