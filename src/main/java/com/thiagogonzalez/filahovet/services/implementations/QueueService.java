package com.thiagogonzalez.filahovet.services.implementations;

import com.thiagogonzalez.filahovet.domain.entities.MedicalRecord;
import com.thiagogonzalez.filahovet.domain.entities.Queue;
import com.thiagogonzalez.filahovet.domain.enums.QueueStatusEnum;
import com.thiagogonzalez.filahovet.domain.exception.BusinessRuleNotAttendedException;
import com.thiagogonzalez.filahovet.domain.exception.ResourceNotFoundException;
import com.thiagogonzalez.filahovet.repositories.MedicalRecordRepository;
import com.thiagogonzalez.filahovet.repositories.QueueRepository;
import org.springframework.stereotype.Service;

@Service
public class QueueService extends GenericService<Queue> {

    private final QueueRepository repository;
    private final MedicalRecordRepository medicalRecordRepository;

    public QueueService(QueueRepository repository, MedicalRecordRepository medicalRecordRepository) {
        super(repository);
        this.repository = repository;
        this.medicalRecordRepository = medicalRecordRepository;
    }


    public MedicalRecord addMedicalRecord(Long queueId, MedicalRecord record) {
        Queue queue = repository.findById(queueId).orElseThrow(() -> new ResourceNotFoundException("Fila não encontrada"));
        if (queue.getQueueStatus().equals(QueueStatusEnum.CLOSED)) {
            throw new BusinessRuleNotAttendedException("Não é possível adicionar um prontuário em uma fila fechada. Por favor, abra a fila antes de adicionar!");
        }
        record.setQueue(queue);
        medicalRecordRepository.save(record);
        return record;
    }
}
