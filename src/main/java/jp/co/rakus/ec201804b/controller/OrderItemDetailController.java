package jp.co.rakus.ec201804b.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.rakus.ec201804b.domain.Order;
import jp.co.rakus.ec201804b.repository.OrderRepository;

@Controller
@RequestMapping("/")
public class OrderItemDetailController {
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/orderDetail")
	public String orderDetail(@RequestParam long id,Model model) {
		Order order = orderRepository.load(id);
		session.setAttribute("order", order);
		return "administer/viewOrderDetail";
	}
}
