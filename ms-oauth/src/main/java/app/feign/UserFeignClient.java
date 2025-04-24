package app.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.entities.User;

@Component
@FeignClient(name = "ms-user", path = "/users")
public interface UserFeignClient {

	@GetMapping("/search")
	public ResponseEntity<User> getByEmail(@RequestParam String email);
}
