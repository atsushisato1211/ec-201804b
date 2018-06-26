package jp.co.rakus.ec201804b.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;


import jp.co.rakus.ec201804b.domain.LoginUser;

@Component
public class MailSendSystem {
	private static final Logger log = LoggerFactory.getLogger(MailSendSystem.class);

	private final JavaMailSender javaMailSender;

	@Autowired
	MailSendSystem(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public SimpleMailMessage send(/* String subject, String content, */ @AuthenticationPrincipal LoginUser loginUser) {

		SimpleMailMessage mailMessage = new SimpleMailMessage();

		mailMessage.setTo(loginUser.getUser().getEmail());
		mailMessage.setReplyTo("ec201804b@gmail.com");
		mailMessage.setFrom("ec201804b@gmail.com");
		String subject = "ご利用ありがとうございます。";
		String content = "お客様の注文内容を添付いたします。";
		mailMessage.setSubject(subject);
		mailMessage.setText(content);

		javaMailSender.send(mailMessage);

		return mailMessage;
	}

}
