package jp.co.rakus.ec201804b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Ec201804bApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Ec201804bApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Ec201804bApplication.class);
	}

}
