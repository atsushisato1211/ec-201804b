package jp.co.rakus.ec201804b.controller;

import java.util.ArrayList;
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
		List<Order> orderList2 = new ArrayList<>();
		for (Order order : orderList) {
			Map<Integer, String> statusMap = orderItemDetail.mapCreate();
			String value = statusMap.get(order.getStatus());
			order.setStatusString(value);
			if(order.getStatus()!=0) {
				orderList2.add(order);
			}
		}
		
		
		session.setAttribute("orderList", orderList2);
		return "administer/viewOrderList";
	}
}
