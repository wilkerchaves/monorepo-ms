package app.controllers;

import java.util.List;

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
        WorkerDto worker = this.workerService.getWorkerById(id);
        if (worker == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(worker);
    }
}
