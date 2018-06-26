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
public class MailContact {
	private static final Logger log = LoggerFactory.getLogger(MailContact.class);

	private final JavaMailSender javaMailSender;
	
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");

	@Autowired
	MailContact(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	public SimpleMailMessage send(String title, String comment, @AuthenticationPrincipal LoginUser loginUser) {

		SimpleMailMessage mailMessage = new SimpleMailMessage();

		mailMessage.setTo("ec201804b@gmail.com");
		mailMessage.setReplyTo(loginUser.getUser().getEmail());
		//mailMessage.setFrom(loginUser.getUser().getEmail());
		
		String subject = loginUser.getUser().getName()  +"さんからのお問い合わせ" + " 【" + title + "】";
		String content = "Email: " + loginUser.getUser().getEmail() + LINE_SEPARATOR + LINE_SEPARATOR + comment;
		mailMessage.setSubject(subject);
		mailMessage.setText(content);

		javaMailSender.send(mailMessage);

		return mailMessage;
	}

}

