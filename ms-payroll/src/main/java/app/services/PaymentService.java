package app.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import app.models.Payment;
import app.models.Worker;

@Service
public class PaymentService {

	private final RestTemplate restTemplate;
	@Value("${ms-workers.host}")
	private String workerHost;

	public PaymentService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Payment getPayment(long workerId, int days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", String.valueOf(workerId));

		Worker worker = this.restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);

		if (worker != null) {
			return new Payment(worker.getName(), worker.getDailyIncome(), days);
		}

		return null;

	}

}
