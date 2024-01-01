package com.thiagogonzalez.filahovet.mapper;

import com.thiagogonzalez.filahovet.domain.User;
import com.thiagogonzalez.filahovet.domain.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    UserDTO fromModel(User model);
    User toModel(UserDTO dto);
    List<UserDTO> fromModelList(List<User> listModel);
}
