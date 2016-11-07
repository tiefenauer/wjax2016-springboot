package info.tiefenauer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class Wjax2016Application {

	public static void main(String[] args) {
		SpringApplication.run(Wjax2016Application.class, args);
	}
}
