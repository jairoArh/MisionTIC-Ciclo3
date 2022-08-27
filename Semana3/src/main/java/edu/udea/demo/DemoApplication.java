package edu.udea.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

public class DemoApplication {

	/*@GetMapping("/demo")
	public String getDemo(@RequestParam(value = "name", defaultValue = "World!!") String name,
						  @RequestParam(value = "age", defaultValue = "18") int age){
		return String.format("Hola %s cómo estás?? tienes %d años\n",name,age);
	}*/


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
