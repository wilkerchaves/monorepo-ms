package app.controllers;

import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.models.WorkerDto;

import app.services.WorkerService;

@RestController
@RequestMapping("/workers")
@EnableAutoConfiguration
@RefreshScope
public class WorkerController {

	private final WorkerService workerService;

	public WorkerController(WorkerService workerService) {
		this.workerService = workerService;
	}

	@GetMapping
	public ResponseEntity<List<WorkerDto>> getAllWorkers() {
		return ResponseEntity.ok(this.workerService.getAllWorkers());
	}

	@GetMapping("/configs")
	public ResponseEntity<Void> getConfigs() {
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<WorkerDto> getById(@PathVariable Long id) {
		WorkerDto worker = this.workerService.getWorkerById(id);
		if (worker == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(worker);
	}
}
