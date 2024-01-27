package com.thiagogonzalez.filahovet.services;

import com.thiagogonzalez.filahovet.domain.entities.MedicalRecord;
import com.thiagogonzalez.filahovet.domain.entities.Queue;
import com.thiagogonzalez.filahovet.domain.entities.Room;
import com.thiagogonzalez.filahovet.domain.entities.User;
import com.thiagogonzalez.filahovet.domain.enums.GenderEnum;
import com.thiagogonzalez.filahovet.domain.enums.ProfileTypeEnum;
import com.thiagogonzalez.filahovet.domain.enums.QueueStatusEnum;
import com.thiagogonzalez.filahovet.domain.enums.SpeciesEnum;
import com.thiagogonzalez.filahovet.repositories.MedicalRecordRepository;
import com.thiagogonzalez.filahovet.repositories.QueueRepository;
import com.thiagogonzalez.filahovet.repositories.RoomRepository;
import com.thiagogonzalez.filahovet.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DBService {

    private final UserRepository userRepository;
    private final MedicalRecordRepository medicalRecordRepository;
    private final QueueRepository queueRepository;
    private final RoomRepository roomRepository;
    private final QueueService queueService;

    public DBService(UserRepository userRepository, MedicalRecordRepository medicalRecordRepository, QueueRepository queueRepository, RoomRepository roomRepository, QueueService queueService) {
        this.userRepository = userRepository;
        this.medicalRecordRepository = medicalRecordRepository;
        this.queueRepository = queueRepository;
        this.roomRepository = roomRepository;
        this.queueService = queueService;
    }


    public boolean initializeDb() {
        List<MedicalRecord> lista = new ArrayList<>();
        User user = new User(null, "Thiago Gonzalez", "teagokkk", "123", ProfileTypeEnum.SECRETARY);
        Room room = new Room(null, "Sala 01", null);
        MedicalRecord medicalRecord = new MedicalRecord(null, "Tito", "Thiago Gonzalez", new BigDecimal("5"), LocalDateTime.now(), "Verme na barriga", SpeciesEnum.FELINE, GenderEnum.MALE, null);
        lista.add(medicalRecord);
        MedicalRecord medicalRecord2 = new MedicalRecord(null, "Tito2", "Thiago Gonzalez", new BigDecimal("5"), LocalDateTime.now(), "Verme na barriga", SpeciesEnum.FELINE, GenderEnum.MALE, null);
        lista.add(medicalRecord2);
        MedicalRecord medicalRecord3 = new MedicalRecord(null, "Tito3", "Thiago Gonzalez", new BigDecimal("5"), LocalDateTime.now(), "Verme na barriga", SpeciesEnum.FELINE, GenderEnum.MALE, null);
        lista.add(medicalRecord3);
        Queue queue = new Queue(null, LocalDateTime.now(),"Fila 01/01/2024", QueueStatusEnum.OPEN, room, lista, "teagokkk");
        userRepository.save(user);
        roomRepository.save(room);
        queueService.create(queue);
        return false;
    }
}
