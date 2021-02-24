package com.evolyb.socket.model;

import lombok.Data;

@Data
public class MessageModel {
    private String from;
    private String to;
    private String message;
}
