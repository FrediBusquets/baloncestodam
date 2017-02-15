package com.example;

import com.example.service.EquipoService;
import com.example.service.PersonaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BaloncestodamApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BaloncestodamApplication.class, args);
		context.getBean(EquipoService.class).testEquipo();
		context.getBean(PersonaService.class).testPersona();
	}
}
