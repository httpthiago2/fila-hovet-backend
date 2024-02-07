package com.thiagogonzalez.filahovet.mapper;

import com.thiagogonzalez.filahovet.domain.entities.Queue;
import com.thiagogonzalez.filahovet.domain.entities.User;
import com.thiagogonzalez.filahovet.domain.dto.QueueDTO;
import com.thiagogonzalez.filahovet.domain.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface QueueMapper {
    QueueMapper INSTANCE = Mappers.getMapper( QueueMapper.class );

    QueueDTO fromModel(Queue model);
    Queue toModel(QueueDTO dto);
    List<QueueDTO> fromModelList(List<Queue> listModel);
}
