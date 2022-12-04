package Siparis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSiparisBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSiparisBackEndApplication.class, args);
		System.out.println("Application: Connected.");
	}
}
