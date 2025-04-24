package app.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entities.User;
import app.services.OauthService;

@RestController
@RequestMapping("/users")
public class OauthController {

	private final OauthService oauthService;

	public OauthController(OauthService oauthService) {
		this.oauthService = oauthService;
	}

	@GetMapping("/search")
	public ResponseEntity<User> findUserByEmail(@RequestParam String email) {
		User user = this.oauthService.findUserByEmail(email);
		return ResponseEntity.ok(user);
	}

}
