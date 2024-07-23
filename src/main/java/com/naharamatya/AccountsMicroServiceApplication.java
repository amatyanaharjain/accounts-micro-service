package com.naharamatya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class AccountsMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsMicroServiceApplication.class, args);
	}

}
