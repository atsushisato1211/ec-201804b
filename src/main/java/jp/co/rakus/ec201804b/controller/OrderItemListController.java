package jp.co.rakus.ec201804b.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ec201804b.domain.Order;
import jp.co.rakus.ec201804b.repository.OrderRepository;

@Controller
@RequestMapping("/admin")
public class OrderItemListController {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemDetailController orderItemDetail;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/orderList")
	public String show() {
		List<Order> orderList =orderRepository.findAll();
		
		for (Order order : orderList) {
			Map<Integer, String> statusMap = orderItemDetail.mapCreate();
			String value = statusMap.get(order.getStatus());
			order.setStatusString(value);
		}
		session.setAttribute("orderList", orderList);
		return "administer/viewOrderList";
	}
}
