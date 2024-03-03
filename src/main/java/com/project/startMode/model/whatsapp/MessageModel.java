package com.project.startMode.model.whatsapp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageModel {

    private String destinationNumber;
    private String messageContent;
}
