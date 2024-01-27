package com.thiagogonzalez.filahovet.services;

import com.thiagogonzalez.filahovet.domain.entities.MedicalRecord;
import com.thiagogonzalez.filahovet.domain.entities.Queue;
import com.thiagogonzalez.filahovet.domain.enums.QueueStatusEnum;
import com.thiagogonzalez.filahovet.domain.exception.BusinessRuleNotAttendedException;
import com.thiagogonzalez.filahovet.domain.exception.ResourceNotFoundException;
import com.thiagogonzalez.filahovet.repositories.MedicalRecordRepository;
import com.thiagogonzalez.filahovet.repositories.QueueRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QueueService {

    private final QueueRepository repository;
    private final MedicalRecordRepository medicalRecordRepository;

    public QueueService(QueueRepository repository, MedicalRecordRepository medicalRecordRepository) {
        this.repository = repository;
        this.medicalRecordRepository = medicalRecordRepository;
    }

    public List<Queue> findAll() {
        return repository.findAll();
    }

    public Queue findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("A fila informada não existe"));
    }

    @Transactional
    public Queue create(Queue queue) {
        queue.setRoom(queue.getRoom());

        Queue queueCreated = repository.save(queue);

        // atualizando os prontuários caso a lista não esteja vazia
        if (!queue.getMedicalRecords().isEmpty()) {
            for (MedicalRecord record : queue.getMedicalRecords()) {
                record.setQueue(queue);
                medicalRecordRepository.save(record);
            }
        }

        return queueCreated;
    }

    @Transactional
    public Queue update(Long id, Queue newQueueData) {
        Queue existingQueue = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("A fila informada não existe"));
        // remove os prontuários que não existem mais na lista antiga
        List<MedicalRecord> recordsToRemove = existingQueue.getMedicalRecords().stream().filter(item -> !newQueueData.getMedicalRecords().contains(item)).collect(Collectors.toList());
        recordsToRemove.forEach(recordToRemove -> {
            recordToRemove.setQueue(null);
            medicalRecordRepository.save(recordToRemove);
        });
        existingQueue.getMedicalRecords().removeAll(recordsToRemove);


        // adiciona os prontuários novos na lista antiga
        newQueueData.getMedicalRecords().stream().filter(item -> !existingQueue.getMedicalRecords().contains(item))
                .forEach(newRecord -> {
                    existingQueue.getMedicalRecords().add(newRecord);
                    newRecord.setQueue(existingQueue);
                    medicalRecordRepository.save(newRecord);
                });

        existingQueue.setName(newQueueData.getName());
        existingQueue.setRoom(newQueueData.getRoom());
        existingQueue.setQueueStatus(newQueueData.getQueueStatus());

        return repository.save(existingQueue);
    }

    public Queue openQueue(Long id) {
        Queue queue = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Fila não encontrada"));
        if (queue.getQueueStatus().equals(QueueStatusEnum.OPEN)) {
            throw new BusinessRuleNotAttendedException("A fila já está aberta");
        }
        queue.setQueueStatus(QueueStatusEnum.OPEN);
        return repository.save(queue);
    }

    public Queue closeQueue(Long id) {
        Queue queue = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Fila não encontrada"));
        if (queue.getQueueStatus().equals(QueueStatusEnum.CLOSED)) {
            throw new BusinessRuleNotAttendedException("A fila já está aberta");
        }
        queue.setQueueStatus(QueueStatusEnum.CLOSED);
        return repository.save(queue);
    }
}
