package com.thiagogonzalez.filahovet.controller;

import com.thiagogonzalez.filahovet.domain.dto.MedicalRecordDTO;
import com.thiagogonzalez.filahovet.mapper.MedicalRecordMapper;
import com.thiagogonzalez.filahovet.repositories.MedicalRecordRepository;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
    @MessageMapping("/updateStatus")
    @SendTo("/topic/status")
    public String updateStatus(@Payload String mewStatus) {
        return "Status atualizado para: " + mewStatus;
    }

}
