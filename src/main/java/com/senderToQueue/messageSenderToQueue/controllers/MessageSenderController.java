package com.senderToQueue.messageSenderToQueue.controllers;

import com.senderToQueue.messageSenderToQueue.dtos.EmailMessageDto;
import com.senderToQueue.messageSenderToQueue.dtos.SmsMessageDto;
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
    public ResponseEntity<String> feedEmailQueue(@RequestBody @Valid EmailMessageDto emailMessage){

        emailMessageSender.feedEmailQueue(emailMessage);
        return new ResponseEntity<>("Message sent to email queue", HttpStatus.GONE);
    }

    @PostMapping("/sms")
    public ResponseEntity<String> feedMsnQueue(@RequestBody @Valid SmsMessageDto smsMessage){

        smsMessageSender.feedMsnQueue(smsMessage);
        return new ResponseEntity<>("Message sent to msn queue", HttpStatus.GONE);
    }

}
