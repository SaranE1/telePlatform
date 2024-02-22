package com.project.startMode.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ChatRequestModel {
    private String model;
    private List<ChatMessageModel> messages;
    private int max_tokens = 50;

    public ChatRequestModel(String model, String prompt) {
        this.model = model;
        this.messages = new ArrayList<ChatMessageModel>();
        this.messages.add(new ChatMessageModel("user", prompt));
    }

}
