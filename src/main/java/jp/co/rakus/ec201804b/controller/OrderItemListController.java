package jp.co.rakus.ec201804b.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ec201804b.domain.Order;
import jp.co.rakus.ec201804b.repository.OrderRepository;

@Controller
@RequestMapping("/orderList")
public class OrderItemListController {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/")
	public String show() {
		List<Order> orderList =orderRepository.findAll();
		session.setAttribute("orderList", orderList);
		return "administer/viewOrderList";
	}
}
