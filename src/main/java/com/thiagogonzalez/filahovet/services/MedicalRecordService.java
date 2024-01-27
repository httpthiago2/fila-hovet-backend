package com.thiagogonzalez.filahovet.services;

import com.thiagogonzalez.filahovet.domain.entities.MedicalRecord;
import com.thiagogonzalez.filahovet.domain.exception.ResourceNotFoundException;
import com.thiagogonzalez.filahovet.repositories.MedicalRecordRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService {
    private final MedicalRecordRepository repository;

    public MedicalRecordService(MedicalRecordRepository repository) {
        this.repository = repository;
    }

    public MedicalRecord create(MedicalRecord record) {
        return repository.save(record);
    }

    public MedicalRecord update(Long id, MedicalRecord record) {
        MedicalRecord existingRecord = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Prontuário não encontrado"));
        BeanUtils.copyProperties(record, existingRecord);
        existingRecord.setId(id);
        return repository.save(existingRecord);
    }

    public List<MedicalRecord> findAll() {
        return repository.findAll();
    }

    public MedicalRecord findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Prontuário não encontrado"));
    }

    public Boolean delete(Long id) {
        MedicalRecord toBeDeleted =  repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Prontuário não encontrado"));
        repository.delete(toBeDeleted);
        return Boolean.TRUE;
    }
}
