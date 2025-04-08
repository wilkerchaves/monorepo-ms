package app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.models.WorkerDto;

import app.mappers.WorkerMapper;
import app.repositories.WorkerRepository;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public List<WorkerDto> getAllWorkers() {
        return workerRepository
                .findAll()
                .stream()
                .map(WorkerMapper.INSTANCE::convertToDto)
                .collect(Collectors.toList());
    }

    public WorkerDto getWorkerById(Long id) {
        return workerRepository
                .findById(id)
                .map(WorkerMapper.INSTANCE::convertToDto)
                .orElse(null);
    }
}
