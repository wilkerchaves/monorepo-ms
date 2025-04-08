package app.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.models.WorkerDto;

import app.entities.Worker;

@Mapper
public interface WorkerMapper {

    WorkerMapper INSTANCE = Mappers.getMapper(WorkerMapper.class);
    
    WorkerDto convertToDto(Worker worker);
    Worker convertToEntity(WorkerDto workerDto);

}
