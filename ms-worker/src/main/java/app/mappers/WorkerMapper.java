package app.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.models.WorkerDto;

import app.entities.Worker;
import org.mapstruct.Mapping;

@Mapper
public interface WorkerMapper {

    WorkerMapper INSTANCE = Mappers.getMapper(WorkerMapper.class);
    
    WorkerDto convertToDto(Worker worker);
    
    @Mapping(target = "id", ignore = true)
	Worker convertToEntity(WorkerDto workerDto);

}
