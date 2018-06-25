package jp.co.rakus.ec201804b.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.rakus.ec201804b.domain.LoginUser;
import jp.co.rakus.ec201804b.domain.Order;
import jp.co.rakus.ec201804b.domain.OrderItem;
import jp.co.rakus.ec201804b.repository.OrderRepository;

@Component
@Transactional
@RequestMapping("/user")
public class PaymentController {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	MailSendSystem mail;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/payment/make")
	public String orderDetail(@RequestParam Long id, Model model) {
		Order order = orderRepository.load(id);
		List<OrderItem> orderItemList = order.getOrderItemList();
		Integer totalPrice = 0;
		for (OrderItem orderItem : orderItemList) {
			totalPrice += orderItem.getQuantity()*orderItem.getItem().getPrice();
		}
		order.setTotalPrice(totalPrice);
		session.setAttribute("order", order);
		return "user/makePayment";
	}
	
	
	@RequestMapping("/payment/confirmed")
	public String confirmed(@RequestParam Long orderId, @AuthenticationPrincipal LoginUser loginUser) {
		orderRepository.update(1, orderId);
		mail.send(loginUser);
		return "user/confirmedPayment";
	}
}
