package app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import app.entities.User;
import app.repositories.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getUsers() {
		return this.userRepository.findAll();
	}

	public User getById(Long id) {
		return this.userRepository.getReferenceById(id);
	}

	public User save(User user) {
		return this.userRepository.save(user);
	}

}
