package com.senderToQueue.messageSenderToQueue.senders;

import com.senderToQueue.messageSenderToQueue.entities.SmsMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SmsMessageSender {

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.binding_key_sms}")
    private String bindingKeyMsn;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void feedMsnQueue(SmsMessage message){
        rabbitTemplate.convertAndSend(exchange, bindingKeyMsn, message);
    }

}
