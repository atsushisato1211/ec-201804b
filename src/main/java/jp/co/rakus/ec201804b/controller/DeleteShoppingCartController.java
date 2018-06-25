package jp.co.rakus.ec201804b.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.rakus.ec201804b.repository.OrderRepository;

@Controller
@RequestMapping("/user")
public class DeleteShoppingCartController {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/delete")
	public String deleteItem(@RequestParam long itemId, @RequestParam long orderId) {
		orderRepository.deleteByItemId(itemId,orderId);
		return "redirect:/user/show";
	}
	
	
}
