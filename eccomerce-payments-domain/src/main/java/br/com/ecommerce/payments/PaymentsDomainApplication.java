package br.com.ecommerce.payments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"br.com"})
public class PaymentsDomainApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentsDomainApplication.class, args);
	}

}
