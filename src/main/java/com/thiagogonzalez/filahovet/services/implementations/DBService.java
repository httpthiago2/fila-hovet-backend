package com.thiagogonzalez.filahovet.services.implementations;

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

@Service
public class DBService {

    private final UserRepository userRepository;
    private final MedicalRecordRepository medicalRecordRepository;
    private final QueueRepository queueRepository;
    private final RoomRepository roomRepository;

    public DBService(UserRepository userRepository, MedicalRecordRepository medicalRecordRepository, QueueRepository queueRepository, RoomRepository roomRepository) {
        this.userRepository = userRepository;
        this.medicalRecordRepository = medicalRecordRepository;
        this.queueRepository = queueRepository;
        this.roomRepository = roomRepository;
    }


    public boolean initializeDb() {
        User user = new User(null, "Thiago Gonzalez", "teagokkk", "123", ProfileTypeEnum.SECRETARY);
        Room room = new Room(null, "Sala 01", null);
        Queue queue = new Queue("Fila 01/01/2024", QueueStatusEnum.OPEN, room, null, "teagokkk");
        MedicalRecord medicalRecord = new MedicalRecord(null, "Tito", "Thiago Gonzalez", new BigDecimal("5"), LocalDateTime.now(), "Verme na barriga", SpeciesEnum.FELINE, GenderEnum.MALE, queue);
        userRepository.save(user);
        roomRepository.save(room);
        queueRepository.save(queue);
        medicalRecordRepository.save(medicalRecord);
        return false;
    }
}
