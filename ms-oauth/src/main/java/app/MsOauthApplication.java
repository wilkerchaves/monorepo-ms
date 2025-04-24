package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsOauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsOauthApplication.class, args);
	}

}
