package jp.co.rakus.ec201804b.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ec201804b.domain.LoginUser;
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
	public String show(@AuthenticationPrincipal LoginUser userDetails) {
//		List<Order> orderList =orderRepository.findAll();
		long userId;
		Order order = new Order();
		if(session.getAttribute("orderId")==null) {
			System.out.println("商品がない場合");
			session.setAttribute("order", order);
			System.out.println(order.getOrderItemList());
			return "user/viewShoppingCart";
		}
		if(userDetails==null) 
			userId=(long) session.getAttribute("userId");
		else
			userId=userDetails.getUser().getId();
		
		Order viewOrder = orderRepository.findByUserIdAndStatus(userId, 0);
		if(viewOrder !=null) {
			Long orderId = viewOrder.getId();
			order=orderRepository.load(orderId);
		}
		
//		for (Order order : orderList) {
//			for (OrderItem item : order.getOrderItemList()) {
//				System.out.println(item.getItem().getImagePath());
//			}
//		}
		
		System.out.println(userId+","+(long) session.getAttribute("orderId"));
		
		session.setAttribute("order" ,order);
		return "user/viewShoppingCart";
	}
}
