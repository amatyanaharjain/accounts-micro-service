package com.naharamatya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts Micro Service REST API Documentation",
				description = "This is a sample description about Accounts Micro Service REST API Documentation",
				version = "v1",
				contact = @Contact(
						name= "Amatya Nahar",
						email = "sample@gmail.com",
						url = "https://www.amatyanahar.com"
						),
				license = @License(name ="Apache 2.0",url= "https://www.amatyanahar.com")
				),
		externalDocs = @ExternalDocumentation(
				description = "This is a sample description about Accounts Micro Service REST API Documentation",
				url= "https://www.amatyanahar.com")
		)
public class AccountsMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsMicroServiceApplication.class, args);
	}

}
