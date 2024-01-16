package com.thiagogonzalez.filahovet.mapper;

import com.thiagogonzalez.filahovet.domain.entities.Queue;
import com.thiagogonzalez.filahovet.domain.entities.User;
import com.thiagogonzalez.filahovet.domain.dto.QueueDTO;
import com.thiagogonzalez.filahovet.domain.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface QueueMapper {
    QueueMapper INSTANCE = Mappers.getMapper( QueueMapper.class );

    QueueDTO fromModel(Queue model);
    User toModel(UserDTO dto);
    List<UserDTO> fromModelList(List<User> listModel);
}
