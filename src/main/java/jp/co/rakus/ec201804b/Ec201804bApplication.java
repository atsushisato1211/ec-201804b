package jp.co.rakus.ec201804b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@SpringBootApplication
public class Ec201804bApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ec201804bApplication.class, args);
	}
	



}
