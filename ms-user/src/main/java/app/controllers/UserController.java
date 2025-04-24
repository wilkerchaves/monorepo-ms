package app.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entities.User;
import app.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<List<User>> getUsers() {
		return ResponseEntity.ok(this.userService.getUsers());
	}

	@GetMapping("/id")
	public ResponseEntity<User> getByID(Long id) {
		return ResponseEntity.ok(this.userService.getById(id));
	}

	@GetMapping("/search")
	public ResponseEntity<User> getByEmail(@RequestParam String email) {
		User user = this.userService.findByEmail(email);
		return ResponseEntity.ok(user);
	}

	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return ResponseEntity.ok(this.userService.save(user));
	}

}
