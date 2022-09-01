package edu.udea.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class ApiApplication {

	@GetMapping("/demo/{nm}")
	public String getRoot(@PathVariable(required = false) String nm){
		return String.format("Hola %s!!\n",nm );
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
