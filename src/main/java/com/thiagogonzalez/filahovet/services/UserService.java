package com.thiagogonzalez.filahovet.services;

import com.thiagogonzalez.filahovet.domain.exception.ResourceNotFoundException;
import com.thiagogonzalez.filahovet.mapper.UserMapper;
import com.thiagogonzalez.filahovet.domain.entities.User;
import com.thiagogonzalez.filahovet.domain.dto.UserDTO;
import com.thiagogonzalez.filahovet.repositories.UserRepository;
import com.thiagogonzalez.filahovet.utils.AppUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class UserService{

    private final Logger logger = Logger.getLogger(UserService.class.getName());

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO createUser(UserDTO dto) {
        logger.info("###Creating a user...");
        dto.setPassword(AppUtils.generateMD5(dto.getPassword()));
        User model = userRepository.save(UserMapper.INSTANCE.toModel(dto));
        return UserMapper.INSTANCE.fromModel(model);
    }

    public UserDTO updateUser(UserDTO dto) {
        logger.info("###Updating user with id: " + dto.getId());
        if (!userRepository.existsById(dto.getId())) {
            throw new ResourceNotFoundException("There are no rooms for id: " + dto.getId());
        }
        dto.setPassword(AppUtils.generateMD5(dto.getPassword()));
        return UserMapper.INSTANCE.fromModel(
                userRepository.save(UserMapper.INSTANCE.toModel(dto))
        );
    }

    public UserDTO deleteUser(Long id) {
        logger.info("###Deleting user...");
        User userEntity = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("There are no rooms for id: " + id));
        userRepository.delete(userEntity);
        return UserMapper.INSTANCE.fromModel(userEntity);
    }
    public UserDTO findUserById(Long id) {
        logger.info("###Finding user with id: "  + id);
        User userEntity = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("There are no rooms for id: " + id));
        return UserMapper.INSTANCE.fromModel(userEntity);
    }
    public List<UserDTO> getAllUsers() {
        logger.info("###Listikng all users...");
        return UserMapper.INSTANCE.fromModelList(userRepository.findAll());
    }
}
