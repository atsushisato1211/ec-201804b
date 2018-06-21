package jp.co.rakus.ec201804b.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ec201804b.domain.Order;
import jp.co.rakus.ec201804b.domain.OrderItem;
import jp.co.rakus.ec201804b.repository.OrderRepository;

@Controller
@Transactional
@RequestMapping("/user")
public class ShowShoppingCartController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private HttpSession session;

	@RequestMapping("/show")
	public String show() {
		List<Order> orderList =orderRepository.findAll();
		for (Order order : orderList) {
			for (OrderItem item : order.getOrderItemList()) {
				System.out.println(item.getItem().getImagePath());
			}
		}
		
		session.setAttribute("orderList", orderList);
		return "user/viewShoppingCart";
	}
}
