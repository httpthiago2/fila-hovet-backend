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

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class QueueDTO {
    private Long id;
    private String name;
    private QueueStatusEnum queueStatus;
    private RoomDTO room;
    private List<MedicalRecordDTO> medicalRecords;
    private String userCode;
}
