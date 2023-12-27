package com.thiagogonzalez.filahovet.controller;

import com.thiagogonzalez.filahovet.model.dto.ResponseObject;
import com.thiagogonzalez.filahovet.model.dto.UserDTO;
import com.thiagogonzalez.filahovet.service.interfaces.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public ResponseEntity<ResponseObject> listAllUsers() {
        return new ResponseEntity<>(
                new ResponseObject(
                        "success",
                        "Usuários encontrados com sucesso",
                        LocalDateTime.now(),
                        userService.getAllUsers()
                ), HttpStatus.OK
        );
    }

    @PostMapping()
    public ResponseEntity<ResponseObject> createUser(@RequestBody UserDTO dto) {
        return new ResponseEntity<>(
                new ResponseObject(
                        "success",
                        "Usuários criado com sucesso",
                        LocalDateTime.now(),
                        userService.createUser(dto)
                ), HttpStatus.CREATED
        );
    }

    @PutMapping()
    public ResponseEntity<ResponseObject> updateUser(@RequestBody UserDTO dto) {
        return new ResponseEntity<>(
                new ResponseObject(
                        "success",
                        "Usuários Atualizado com sucesso",
                        LocalDateTime.now(),
                        userService.updateUser(dto)
                ), HttpStatus.OK
        );
    }

    @DeleteMapping(
            value = "/{id}"
    )
    public ResponseEntity<ResponseObject> deleteUser(@PathVariable Long id) {
        return new ResponseEntity<>(
                new ResponseObject(
                        "success",
                        "Usuários removido com sucesso",
                        LocalDateTime.now(),
                        userService.deleteUser(id)
                ), HttpStatus.OK
        );
    }

    @GetMapping(
            value = "/{id}"
    )
    public ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        return new ResponseEntity<>(
                new ResponseObject(
                        "success",
                        "Usuários removido com sucesso",
                        LocalDateTime.now(),
                        userService.findUserById(id)
                ), HttpStatus.OK
        );
    }


}
