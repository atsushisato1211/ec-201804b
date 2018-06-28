package jp.co.rakus.ec201804b.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.rakus.ec201804b.domain.Item;
import jp.co.rakus.ec201804b.domain.LoginUser;
import jp.co.rakus.ec201804b.domain.Order;
import jp.co.rakus.ec201804b.domain.OrderItem;
import jp.co.rakus.ec201804b.repository.ItemRepository;
import jp.co.rakus.ec201804b.repository.OrderItemRepository;
import jp.co.rakus.ec201804b.repository.OrderRepository;

@Component
@Transactional
@RequestMapping("/user")
public class PaymentController {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	OrderItemRepository orderItemRepository;

	@Autowired
	MailSendSystem mail;

	@Autowired

	MailContact con;

	@Autowired
	HttpSession session;

	@RequestMapping("/payment/make")
	public String orderDetail(@AuthenticationPrincipal LoginUser loginUser, Model model) {
		Long userId = null;
		if (loginUser != null) {
			userId = loginUser.getUser().getId();
		} else {
			userId = (Long) session.getAttribute("userId");
		}
		Order orderUser = orderRepository.findByUserIdAndStatus(userId, 0);
		
		if(orderUser == null ) {
			return "user/makePayment"; 
		}
		
		Long orderId = orderUser.getId();
		Order order = orderRepository.load(orderId);
		List<OrderItem> orderItemList = order.getOrderItemList();
		Integer totalPrice = 0;
		for (OrderItem orderItem : orderItemList) {
			totalPrice += orderItem.getQuantity() * orderItem.getItem().getPrice();
		}
		orderRepository.updatetoralPrice(totalPrice, orderId);
		order.setTotalPrice(totalPrice);
		
		// 合算と更新と削除
		List<OrderItem> orderItemList2 = orderItemRepository.findByOrderId(orderId);
		for (OrderItem orderItem : orderItemList2) {
			Long itemId = orderItem.getItemId();
			Long orderItemOrderId = orderItem.getOrderId();
			List<OrderItem> orderItemLi = orderItemRepository.findByItemIdAndOrderId(itemId, orderItemOrderId);

			if (orderItemLi.size() > 1) {
				Long itemIdzero = orderItemLi.get(0).getItemId();
				Long orderIdzero = orderItemLi.get(0).getOrderId();
				// Long zeroId = orderItemLi.get(0).getId();//1つ目の商品のid
				Long oneId = orderItemLi.get(1).getId();// 2つ目の商品のid
				Integer newQuantity = orderItemLi.get(0).getQuantity() + orderItemLi.get(1).getQuantity();// 合算処理
				orderItemRepository.updateById(itemIdzero, orderIdzero, newQuantity);// 1つ目に合算した個数をupdate
				orderItemRepository.deleteById(oneId);// 2つ目を削除
			}
		}
		Order order2 = orderRepository.load(orderId);
		session.setAttribute("order", order2);
		return "user/makePayment";
	}

	@RequestMapping("/payment/confirmed")
	public String confirmed(@RequestParam Long orderId, @AuthenticationPrincipal LoginUser loginUser) {
		Order orderup = orderRepository.load(orderId);
		List<OrderItem> orderItemList = orderup.getOrderItemList();
		for (OrderItem orderItem : orderItemList) {
			Integer stock = orderItem.getItem().getStock();
			Integer quantity = orderItem.getQuantity();
			Integer proceed = orderItem.getItem().getProceed();
			Integer remstock = stock-quantity;
			Integer proceedup = proceed + orderItem.getItem().getPrice() * orderItem.getQuantity();
			System.out.println(stock);
			Long itemId = orderItem.getItemId();
			itemRepository.updateStock(remstock, proceedup, itemId);
			if(remstock <= 0) {
				itemRepository.updateDeleted(itemId,true);
			}
		}
		orderRepository.update(1, orderId);
		//System.out.println(orderId);
		orderRepository.updateNumber(orderId);
		Order order = orderRepository.load(orderId);
		mail.send(loginUser, order);

		// con.send(loginUser);
		return "user/confirmedPayment";

	}
}
