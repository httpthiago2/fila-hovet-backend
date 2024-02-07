package com.thiagogonzalez.filahovet.mapper;

import com.thiagogonzalez.filahovet.domain.dto.ChildQueueDTO;
import com.thiagogonzalez.filahovet.domain.dto.QueueDTO;
import com.thiagogonzalez.filahovet.domain.entities.Queue;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ChildQueueMapper {
    ChildQueueMapper INSTANCE = Mappers.getMapper( ChildQueueMapper.class );

    ChildQueueDTO fromModel(Queue model);
    Queue toModel(ChildQueueDTO dto);
    List<ChildQueueDTO> fromModelList(List<Queue> listModel);
}
