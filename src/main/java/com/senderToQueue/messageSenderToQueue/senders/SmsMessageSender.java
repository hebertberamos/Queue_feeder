package com.senderToQueue.messageSenderToQueue.senders;

import com.senderToQueue.messageSenderToQueue.dtos.SmsMessageDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SmsMessageSender {

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.binding_key_sms}")
    private String bindingKeySms;

    public SmsMessageSender (AmqpTemplate queueSender){
        this.queueSender = queueSender;
    }

    private final AmqpTemplate queueSender;

    public void feedMsnQueue(SmsMessageDto message){
        queueSender.convertAndSend(exchange, bindingKeySms, message);
    }

}
