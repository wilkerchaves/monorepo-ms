package app.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import app.entities.User;
import app.feign.UserFeignClient;

@Service
public class OauthService {
	private static final Logger logger = LoggerFactory.getLogger(OauthService.class);
	
	private final UserFeignClient feignClient;

	public OauthService(UserFeignClient feignClient) {
		this.feignClient = feignClient;
	}

	public User findUserByEmail(String email) {
		User user = this.feignClient.getByEmail(email).getBody();
		if (user == null) {
			logger.error("Email not found: " + email);
		}
		logger.info("Email has found: " + email);
		return user;
	}

}
