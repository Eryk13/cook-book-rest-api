package com.eryk.cook.book;

import com.eryk.cook.book.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class CookBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(CookBookApplication.class, args);
	}

	@Bean
	public InMemoryUserDetailsManager users() {
		return new InMemoryUserDetailsManager(
				User.withUsername("dvega")
						.password("{noop}password")
						.authorities("read")
						.build()
		);
	}


}
