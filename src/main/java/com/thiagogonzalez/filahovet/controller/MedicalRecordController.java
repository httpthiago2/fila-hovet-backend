package com.thiagogonzalez.filahovet.controller;

import com.thiagogonzalez.filahovet.domain.dto.MedicalRecordDTO;
import com.thiagogonzalez.filahovet.domain.dto.ResponseObject;
import com.thiagogonzalez.filahovet.domain.entities.MedicalRecord;
import com.thiagogonzalez.filahovet.mapper.MedicalRecordMapper;
import com.thiagogonzalez.filahovet.services.MedicalRecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/medical-record")
public class MedicalRecordController {
    private final MedicalRecordService service;


    public MedicalRecordController(MedicalRecordService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ResponseObject> findAll() {
        return new ResponseEntity<>(new ResponseObject(
                "success",
                "Busca efetuada com sucesso",
                LocalDateTime.now(),
                MedicalRecordMapper.INSTANCE.fromModelList(service.findAll())
        ), HttpStatus.OK);
    }

    @GetMapping(
            value = "/{id}"
    )
    public ResponseEntity<ResponseObject> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(new ResponseObject(
                "success",
                "Busca efetuada com sucesso",
                LocalDateTime.now(),
                MedicalRecordMapper.INSTANCE.fromModel(service.findById(id))
        ), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseObject> create(@RequestBody MedicalRecordDTO dto) {
        MedicalRecord record = MedicalRecordMapper.INSTANCE.toModel(dto);
        MedicalRecord recordCreated = service.create(record);
        return new ResponseEntity<>(new ResponseObject(
                "success",
                "Prontuário criado com sucesso!",
                LocalDateTime.now(),
                MedicalRecordMapper.INSTANCE.fromModel(recordCreated)),
                HttpStatus.CREATED
        );
    }

    @PutMapping(
            value = "/{id}"
    )
    public ResponseEntity<ResponseObject> update(@PathVariable("id") Long id, @RequestBody MedicalRecordDTO recordDTO) {
        MedicalRecord updated = service.update(id, MedicalRecordMapper.INSTANCE.toModel(recordDTO));
        return new ResponseEntity<>(new ResponseObject(
                "success",
                "Prontuário atualizado com sucesso",
                LocalDateTime.now(),
                MedicalRecordMapper.INSTANCE.fromModel(updated)),
                HttpStatus.OK
        );
    }

    @DeleteMapping(
            value = "/{id}"
    )
    public ResponseEntity<ResponseObject> delete(@PathVariable("id") Long id, @RequestBody MedicalRecordDTO recordDTO) {
        return new ResponseEntity<>(new ResponseObject(
                "success",
                "Prontuário atualizado com sucesso",
                LocalDateTime.now(),
                service.delete(id)),
                HttpStatus.OK
        );
    }
}
