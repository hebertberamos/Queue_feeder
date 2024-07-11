package com.senderToQueue.messageSenderToQueue.controllers;

import com.senderToQueue.messageSenderToQueue.entities.EmailMessage;
import com.senderToQueue.messageSenderToQueue.entities.SmsMessage;
import com.senderToQueue.messageSenderToQueue.senders.EmailMessageSender;
import com.senderToQueue.messageSenderToQueue.senders.SmsMessageSender;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/send/queue")
public class MessageSenderController {

    @Autowired
    private EmailMessageSender emailMessageSender;

    @Autowired
    private SmsMessageSender smsMessageSender;

    @PostMapping("/email")
    public ResponseEntity<String> feedEmailQueue(@RequestBody @Valid EmailMessage emailMessage){

        String responseMessage = String.format("Owner reference: %s\nEmail from: %s\nEmail to: %s\nSubject: %s\nText: %s",
                emailMessage.getOwnerReference(), emailMessage.getEmailFrom(), emailMessage.getEmailTo(), emailMessage.getSubject(), emailMessage.getText());

        emailMessageSender.feedEmailQueue(emailMessage);
        return new ResponseEntity<>(responseMessage, HttpStatus.GONE);
    }

    @PostMapping("/sms")
    public ResponseEntity<String> feedMsnQueue(@RequestBody @Valid SmsMessage smsMessage){

        smsMessageSender.feedMsnQueue(smsMessage);
        return new ResponseEntity<>("Message to msn queue sent", HttpStatus.GONE);
    }

}
