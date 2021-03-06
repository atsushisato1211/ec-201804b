package jp.co.rakus.ec201804b.controller;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.rakus.ec201804b.domain.LoginUser;
import jp.co.rakus.ec201804b.domain.Order;
import jp.co.rakus.ec201804b.domain.OrderItem;
import jp.co.rakus.ec201804b.form.OrderItemForm;
import jp.co.rakus.ec201804b.repository.ItemRepository;
import jp.co.rakus.ec201804b.repository.OrderItemRepository;
import jp.co.rakus.ec201804b.repository.OrderRepository;

@Controller
@RequestMapping("/user")
public class InsertShoppingCartController {

	Random rand = new Random();
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private HttpSession session;
	


	@RequestMapping("/insert")
	public String insertItem(@Validated OrderItemForm form,BindingResult result ,RedirectAttributes redirect , @AuthenticationPrincipal LoginUser userDetails) {
		String quantity = String.valueOf(form.getQuantity());
		if(form.getQuantity()==0 || !quantity.matches("[0-9]+")) {
			redirect.addFlashAttribute("error","正の整数を入力してください");
			return "redirect:/user/itemdetail?id="+form.getItemId();
		}
		Integer stock = itemRepository.load(form.getItemId().longValue()).getStock();
		if(form.getQuantity() > stock) {
			redirect.addFlashAttribute("error","在庫数は" +stock +  "個です。");
			return "redirect:/user/itemdetail?id="+form.getItemId();
		}
		Long userId = null;
		if (userDetails != null) {
			userId = userDetails.getUser().getId();
		} else {
			userId = (Long) session.getAttribute("userId");
		}
		Order orderUser = orderRepository.findByUserIdAndStatus(userId, 0);
		if (orderUser == null) {
			Order order = new Order();
			if (userDetails == null) {
				long random = (long) -(rand.nextInt(Integer.MAX_VALUE));
				session.setAttribute("userId", random);
				order.setUserId(random);
				order.setDeliveryName("");
				order.setDeliveryEmail("");
				order.setDeliveryZipCode("");
				order.setDeliveryAddress("");
				order.setDeliveryTel("");
			} else {
				order.setUserId(userDetails.getUser().getId());
				session.setAttribute("userId", order.getUserId());
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
		}

		OrderItem orderItem = new OrderItem();
		BeanUtils.copyProperties(form, orderItem);
		orderItem.setItemId(form.getItemId().longValue());
		List<Order> orderItemList = null;
		if (orderUser == null) {
			orderItem.setOrderId((long) session.getAttribute("orderId"));
			orderItemList = orderRepository.findByOrderId((long) session.getAttribute("orderId"));
		} else {
			orderItem.setOrderId(orderUser.getId());
			orderItemList = orderRepository.findByOrderId(orderUser.getId());
		}
		// for (Order order : orderItemList) {
		// if(order.getOrderItemList().get(order.getOrderItemList().size()-1).getItemId()==form.getItemId().longValue())
		// {
		// System.out.println("111");
		// orderRepository.updateOrderItem(orderItem);
		// }else {
		// System.out.println("222");
		// orderRepository.insertOrderItem(orderItem);
		// }
		// System.out.println(orderItemRepository.findByItemId(form.getItemId().longValue()));
//		if (orderItemRepository.findByItemId(form.getItemId().longValue()).size() >= 1) {
//			orderRepository.updateOrderItem(orderItem);
//		} else {
//			orderRepository.insertOrderItem(orderItem);
//		}

		// }
		// System.out.println(orderRepository.findByUserId((long)session.getAttribute("userId"),(long)session.getAttribute("orderId")).getId());
		// orderItem.setOrderId(orderRepository.findByUserId((long)session.getAttribute("userId"),(long)session.getAttribute("orderId")).getId());
		orderRepository.insertOrderItem(orderItem);

		return "redirect:/user/show";
	}

}
