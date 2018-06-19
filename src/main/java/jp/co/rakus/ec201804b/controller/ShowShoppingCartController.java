package jp.co.rakus.ec201804b.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ec201804b.repository.OrderRepository;

@Controller
@Transactional
@RequestMapping("/")
public class ShowShoppingCartController {
	
	private OrderRepository orderRepository;

	@RequestMapping("/show")
	public String show() {
//		orderRepository.findAll();
		return "";
	}
}
