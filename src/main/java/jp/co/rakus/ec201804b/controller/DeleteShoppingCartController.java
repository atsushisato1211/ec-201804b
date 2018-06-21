package jp.co.rakus.ec201804b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ec201804b.repository.OrderRepository;

@Controller
@RequestMapping("/delete")
public class DeleteShoppingCartController {

	@Autowired
	private OrderRepository orderRepository;
	
//	@RequestMapping("/")
//	public String deleteItem(Integer id) {
//		orderRepository.deleteByItemId(id);
//	}
	
	
}
