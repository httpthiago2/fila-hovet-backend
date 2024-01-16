package com.thiagogonzalez.filahovet.controller;

import com.thiagogonzalez.filahovet.domain.dto.ResponseObject;
import com.thiagogonzalez.filahovet.domain.entities.AbstractEntity;
import com.thiagogonzalez.filahovet.services.implementations.GenericService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

public class GenericController<T extends AbstractEntity, DTO> {

    ModelMapper modelMapper = new ModelMapper();
    private final GenericService<T> service;
    private final Class<DTO> dtoClass;
    private final Class<T> entityClass;

    public GenericController(GenericService<T> service, Class<DTO> dtoClass, Class<T> entityClass) {
        this.service = service;
        this.dtoClass = dtoClass;
        this.entityClass = entityClass;
    }

    @GetMapping
    public ResponseEntity<ResponseObject> findAll() {
        List<T> entities = service.findAll();
        List<DTO> dtos = entities.stream().map(this::fromModel).toList();
        return new ResponseEntity<>(new ResponseObject(
                "success",
                "Busca realizada com sucesso",
                LocalDateTime.now(),
                dtos),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getById(@PathVariable("id") Long id) {
        T entity = service.findById(id);
        DTO dto = fromModel(entity);
        return new ResponseEntity<>(new ResponseObject(
                "success",
                "Busca realizada com sucesso",
                LocalDateTime.now(),
                dto),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<ResponseObject> create(@RequestBody DTO dto) {
        T createdEntity = service.create(toModel(dto));
        DTO createdDto = fromModel(createdEntity);
        return new ResponseEntity<>(new ResponseObject(
                "success",
                "Busca realizada com sucesso",
                LocalDateTime.now(),
                createdDto),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> update(@PathVariable("id") Long id, @RequestBody DTO dto) {
        T updatedEntity = service.update(id, toModel(dto));
        DTO updatedDto = fromModel(updatedEntity);
        return new ResponseEntity<>(new ResponseObject(
                "success",
                "Busca realizada com sucesso",
                LocalDateTime.now(),
                updatedDto),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> delete(@PathVariable Long id) {
        boolean deleted = service.delete(id);
        return new ResponseEntity<>(new ResponseObject(
                "success",
                "Busca realizada com sucesso",
                LocalDateTime.now(),
                deleted),
                HttpStatus.OK
        );
    }

    public DTO fromModel(T entity) {
        return modelMapper.map(entity, dtoClass);
    }

    public T toModel(DTO dto) {
        return modelMapper.map(dto, entityClass);
    }
}