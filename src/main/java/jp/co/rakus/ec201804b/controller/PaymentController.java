package jp.co.rakus.ec201804b.controller;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@Transactional
@RequestMapping("/user")
public class PaymentController {

	@RequestMapping("/payment/make")
	public String make() {
		return "user/makePayment";
	}
	
	@RequestMapping("/payment/confirmed")
	public String confirmed() {
		return "user/confirmedPayment";
	}
}
