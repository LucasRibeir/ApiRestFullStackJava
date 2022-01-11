package br.com.Lucas.ProjetoFullStack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EntityScan(basePackages = "br.com.Lucas.entity")
@EnableJpaRepositories(basePackages = "br.com.Lucas.repository")
@ComponentScan(basePackages = "br.com.Lucas.resource")
@ComponentScan(basePackages = "br.com.Lucas.service")
@ComponentScan(basePackages = "br.com.Lucas.exception")


@SpringBootApplication
public class ProjetoFullStackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoFullStackApplication.class, args);
	}

}
