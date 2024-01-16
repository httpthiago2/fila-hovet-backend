package com.thiagogonzalez.filahovet.domain.dto;

import com.thiagogonzalez.filahovet.domain.entities.Queue;
import com.thiagogonzalez.filahovet.domain.entities.Room;
import com.thiagogonzalez.filahovet.domain.enums.QueueStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter @NoArgsConstructor
public class QueueDTO {
    private Long id;
    private QueueStatusEnum queueStatus;
    private RoomDTO room;
    private List<MedicalRecordDTO> medicalRecords;
    private String userCode;

    public QueueDTO(Queue queue, String userCode) {
        this.id = queue.getId();
        this.queueStatus = queue.getQueueStatus();
        BeanUtils.copyProperties(queue.getRoom(), this.room);
        this.medicalRecords = queue.getMedicalRecords().stream().map(record -> new MedicalRecordDTO(
                record.getId(),
                record.getPetName(),
                record.getTutor(),
                record.getWeight(),
                record.getRegisterDate(),
                record.getComplaint(),
                record.getSpecies(),
                record.getGender()
        )).collect(Collectors.toList());
        this.userCode = userCode;
    }
}
