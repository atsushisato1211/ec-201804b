package jp.co.rakus.ec201804b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@SpringBootApplication
public class Ec201804bApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ec201804bApplication.class, args);
	}
	@Bean
    PasswordEncoder passwordEncoder() {
        return new StandardPasswordEncoder();
    }
	
//	DROP TABLE IF EXISTS items;
//	create table items (
//	  id bigserial not null
//	  , name text not null unique
//	  , description text not null
//	  , price integer not null
//	  , imagePath text not null
//	  , deleted boolean default false not null
//	  , constraint items_PKC primary key (id)
//	) ;
//
//	INSERT INTO items  values(1,'キューリ','宮崎県産',100,'001.jpg',true);
//	INSERT INTO items  values(2,'きゃべつ','愛知県産',150,'002.jpg',true);
//	INSERT INTO items  values(3,'枝豆','千葉県産',100,'003.jpg',true);
}
