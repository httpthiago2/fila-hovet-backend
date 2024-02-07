package com.thiagogonzalez.filahovet.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
    @MessageMapping("/updateStatus")
    @SendTo("/topic/status")
    public String updateStatus(@Payload String mewStatus) {
        return "Status atualizado para: " + mewStatus;
    }

}
