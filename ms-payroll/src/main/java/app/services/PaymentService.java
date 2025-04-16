package app.services;

import org.springframework.stereotype.Service;

import app.feign.WorkerFeignClient;
import app.models.Payment;
import app.models.Worker;

@Service
public class PaymentService {

	private final WorkerFeignClient feignClient;

	public PaymentService(WorkerFeignClient feignClient) {
		this.feignClient = feignClient;
	}

	public Payment getPayment(long workerId, int days) {

		Worker worker = this.feignClient.getById(workerId).getBody();

		if (worker != null) {
			return new Payment(worker.getName(), worker.getDailyIncome(), days);
		}

		return null;

	}

}
