package com.senderToQueue.messageSenderToQueue.senders;

import com.senderToQueue.messageSenderToQueue.dtos.EmailMessageDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailMessageSender {

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.binding_key_email}")
    private String bindingKeyEmail;

    public EmailMessageSender (AmqpTemplate queueSender){
        this.queueSender = queueSender;
    }

    private final AmqpTemplate queueSender;

    public void feedEmailQueue(EmailMessageDto message){
        queueSender.convertAndSend(exchange, bindingKeyEmail, message);
    }


}
