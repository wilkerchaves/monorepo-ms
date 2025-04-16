package app.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import app.models.Worker;

@Component
@FeignClient(name = "ms-worker", url = "http://localhost:8081", path = "/workers")
public interface WorkerFeignClient {

	@GetMapping("/{id}")
    public ResponseEntity<Worker> getById(@PathVariable Long id);
}
