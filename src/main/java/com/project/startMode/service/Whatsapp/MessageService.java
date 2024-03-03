package com.project.startMode.service.Whatsapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import jakarta.annotation.PostConstruct;

@Service
public class MessageService {

    @Value("${TWILIO_ACCOUNT_SID}")
    private String ACCOUNT_SID;

    @Value("${TWILIO_AUTH_TOKEN}")
    private String AUTH_TOKEN;

    @Value("${TWILIO_OUTGOING_SMS_NUMBER}")
    private String OUTGOING_SMS_NUMBER;

    @PostConstruct
    private void setup() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    public String sendMessageService(String destinationNumber, String messageContent) {
        try {
            System.out.println(OUTGOING_SMS_NUMBER);
            System.out.println(destinationNumber);
            System.out.println(messageContent);
            Message message = Message.creator(
                    new PhoneNumber(destinationNumber),
                    new PhoneNumber(OUTGOING_SMS_NUMBER), messageContent).create();
            System.out.println(message);
            return message.getStatus().toString();
        } catch (Exception e) {
            System.out.println("hello " + e);
            return e.toString();
        }

    }
}
