package jp.co.rakus.ec201804b.controller;


import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ec201804b.domain.LoginUser;
import jp.co.rakus.ec201804b.domain.Order;
import jp.co.rakus.ec201804b.domain.OrderItem;
import jp.co.rakus.ec201804b.form.OrderItemForm;
import jp.co.rakus.ec201804b.repository.OrderRepository;

@Controller
@RequestMapping("/user")
public class InsertShoppingCartController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private HttpSession session;

	@RequestMapping("/insert")
	public String insertItem(OrderItemForm form,@AuthenticationPrincipal LoginUser userDetails) {
		
//		if(orderRepository.findByUserId(userDetails.getUser().getId())==null) {
			Order order= new Order();
			if(userDetails==null) {
				order.setUserId((long) -1);
				order.setDeliveryName("");
				order.setDeliveryEmail("");
				order.setDeliveryZipCode("");
				order.setDeliveryAddress("");
				order.setDeliveryTel("");
			}
			else {
				order.setUserId(userDetails.getUser().getId());
				order.setDeliveryName(userDetails.getUser().getName());
				order.setDeliveryEmail(userDetails.getUser().getEmail());
				order.setDeliveryZipCode(userDetails.getUser().getZipCode());
				order.setDeliveryAddress(userDetails.getUser().getAddress());
				order.setDeliveryTel(userDetails.getUser().getTelephone());
			}
			order.setStatus(0);
			order.setTotalPrice(0);
			LocalDateTime localDateTime = LocalDateTime.now();
			ZoneId zone = ZoneId.systemDefault();
			ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zone);

			Instant instant = zonedDateTime.toInstant();
			Date date = Date.from(instant);
			order.setOrderDate(date);
	
			orderRepository.insertOrder(order);
//		}
		
		OrderItem orderItem = new OrderItem();
		BeanUtils.copyProperties(form,orderItem);
		orderItem.setItemId(form.getItemId().longValue());
//		System.out.println(orderRepository.findByUserId(userDetails.getUser().getId()).getId());
//		orderItem.setOrderId(orderRepository.findByUserId(userDetails.getUser().getId()).getId());
		orderRepository.insertOrderItem(orderItem);
		
		return "redirect:/user/show";
	}
	
	
}
