package com.senderToQueue.messageSenderToQueue.senders;

import com.senderToQueue.messageSenderToQueue.entities.EmailMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailMessageSender {

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.binding_key_email}")
    private String bindingKeyEmail;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void feedEmailQueue(EmailMessage message){
        rabbitTemplate.convertAndSend(exchange, bindingKeyEmail, message);
    }


}
