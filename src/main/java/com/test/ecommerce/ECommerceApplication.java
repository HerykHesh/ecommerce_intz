package com.test.ecommerce;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = {"com.test.ecommerce", "springfox.documentation.spring.data.rest"})
@EnableJpaRepositories(basePackages = {"com.test.ecommerce.repository"})
@EntityScan(basePackages = {"com.test.ecommerce.model"})
@EnableScheduling
public class ECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void started() {
		log.info("---------------------------------------------------------------------------");
		log.info("---------------------------------------------------------------------------");
		log.info("---------------------------------------------------------------------------");
		log.info("----------------------------Started application----------------------------");
		log.info("---------------------------------------------------------------------------");
		log.info("---------------------------------------------------------------------------");
		log.info("---------------------------------------------------------------------------");
		log.info("---------------------------------------------------------------------------");
	}

}
