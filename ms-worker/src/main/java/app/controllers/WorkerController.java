package app.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.models.WorkerDto;

import app.services.WorkerService;

@Controller
@RequestMapping("/workers")
public class WorkerController {

	private static Logger logger = LoggerFactory.getLogger(WorkerController.class);

	@Autowired
	private ServerProperties properties;

	private final WorkerService workerService;

	public WorkerController(WorkerService workerService) {
		this.workerService = workerService;
	}

	@GetMapping
	public ResponseEntity<List<WorkerDto>> getAllWorkers() {
		return ResponseEntity.ok(this.workerService.getAllWorkers());
	}

	@GetMapping("/{id}")
	public ResponseEntity<WorkerDto> getById(@PathVariable Long id) {
		logger.info("PORT:" + this.properties.getPort());
		WorkerDto worker = this.workerService.getWorkerById(id);
		if (worker == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(worker);
	}
}
