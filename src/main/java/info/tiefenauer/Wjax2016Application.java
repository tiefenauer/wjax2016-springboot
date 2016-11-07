package info.tiefenauer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.social.TwitterAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableAutoConfiguration(exclude = {TwitterAutoConfiguration.class})
public class Wjax2016Application {

	public static void main(String[] args) {
		SpringApplication.run(Wjax2016Application.class, args);
	}
}
