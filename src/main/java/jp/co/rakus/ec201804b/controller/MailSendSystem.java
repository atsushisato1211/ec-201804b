package jp.co.rakus.ec201804b.controller;

import java.text.NumberFormat;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;


import jp.co.rakus.ec201804b.domain.LoginUser;
import jp.co.rakus.ec201804b.domain.Order;
import jp.co.rakus.ec201804b.domain.OrderItem;

@Component
public class MailSendSystem {
	private static final Logger log = LoggerFactory.getLogger(MailSendSystem.class);

	private final JavaMailSender javaMailSender;
	
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	@Autowired
	MailSendSystem(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public SimpleMailMessage send(@AuthenticationPrincipal LoginUser loginUser,Order order) {
		NumberFormat nfCur = NumberFormat.getCurrencyInstance();
		String list = "";
		List<OrderItem> orderItemList = order.getOrderItemList();
		for (OrderItem orderItem : orderItemList) {
			list +=  "商品: " + orderItem.getItem().getName() 
					+" 個数: " + orderItem.getQuantity() 
					+" 金額(税抜): " + nfCur.format(orderItem.getItem().getPrice()*orderItem.getQuantity()) + LINE_SEPARATOR;
					
		}
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(loginUser.getUser().getEmail());
		mailMessage.setReplyTo("ec201804b@gmail.com");
		mailMessage.setFrom("ec201804b@gmail.com");
		String subject = "楽楽成果　ご注文の確認";
		String content = loginUser.getUser().getName() + "様" + LINE_SEPARATOR + LINE_SEPARATOR
				+ "ご注文ありがとうございます。" + LINE_SEPARATOR 
				+ "注文番号: " + order.getOrderNumber() + LINE_SEPARATOR + LINE_SEPARATOR
				+ "購入した商品は以下です。" + LINE_SEPARATOR 
				+ "---------------------------------------------------------------------------------------" + LINE_SEPARATOR 
				+ list 
				+ "---------------------------------------------------------------------------------------" + LINE_SEPARATOR
				+ "小計: " + nfCur.format(order.getTotalPrice()*1.08) + LINE_SEPARATOR
				+ "送料: " + nfCur.format(500) + LINE_SEPARATOR
				+ "総計: " + nfCur.format(order.getTotalPrice()*1.08 + 500) + LINE_SEPARATOR
				+ LINE_SEPARATOR
				+ "お届け先: " + order.getDeliveryAddress() + LINE_SEPARATOR
				+ "---------------------------------------------------------------------------------------" + LINE_SEPARATOR + LINE_SEPARATOR
				+ "上記内容に不備があった場合は、恐れ入りますがec201804b@gmail.comまでご連絡をお願いします。" + LINE_SEPARATOR
				+ "ご利用ありがとうございます。またのご利用をお待ちしております。"
				;
		mailMessage.setSubject(subject);
		mailMessage.setText(content);

		javaMailSender.send(mailMessage);

		return mailMessage;
	}

}
