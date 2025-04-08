package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
