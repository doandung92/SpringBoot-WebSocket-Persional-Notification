package com.evolyb.socket.controller;

import com.evolyb.socket.model.MessageModel;
import com.evolyb.socket.service.MessageService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@Data
@AllArgsConstructor
@RequestMapping("/notifications")
public class NotificationController {
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final MessageService messageService;

    @PostMapping("/{name}")
    public MessageModel sendNotification(@PathVariable String name, @RequestBody MessageModel message){
        messageService.sendMessage(name, message);
        return message;
    }

    @MessageMapping("/notification-server/{name}")
    public void sendMessage(@DestinationVariable String name, @Payload MessageModel message) {
        messageService.sendMessage(name, message);
    }

}
