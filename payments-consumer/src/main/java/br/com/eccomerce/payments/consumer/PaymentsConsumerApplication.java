package br.com.eccomerce.payments.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com")
public class PaymentsConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentsConsumerApplication.class, args);
	}

}
