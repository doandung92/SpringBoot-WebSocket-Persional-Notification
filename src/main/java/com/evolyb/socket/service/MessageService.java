package com.evolyb.socket.service;

import com.evolyb.socket.model.MessageModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class MessageService {
    private final SimpMessagingTemplate simpMessagingTemplate;

    public void sendMessage(String to, MessageModel message){
        simpMessagingTemplate.convertAndSend("/topic/notification-client/" + to, message);
    }
}
