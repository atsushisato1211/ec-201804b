package jp.co.rakus.ec201804b.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ec201804b.domain.OrderItem;
import jp.co.rakus.ec201804b.form.OrderItemForm;
import jp.co.rakus.ec201804b.repository.OrderRepository;

@Controller
@RequestMapping("/insert")
public class InsertShoppingCartController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private HttpSession session;

	@RequestMapping("/")
	public String insertItem(OrderItemForm form) {
		System.out.println("controllerを呼びました");
		OrderItem orderItem = new OrderItem();
		BeanUtils.copyProperties(form,orderItem);
		orderItem.setItemId(form.getItemId().longValue());
		orderItem.setOrderId((long) 1);
		orderItem.setQuantity(1);
		orderRepository.insert(orderItem);
		
		return "redirect:/show/";
	}
}
