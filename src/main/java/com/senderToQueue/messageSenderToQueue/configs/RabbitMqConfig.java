package com.senderToQueue.messageSenderToQueue.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue emailQueue() {
        return new Queue("ms.email", true);
    }

    @Bean
    public Queue smsQueue() {
        return new Queue("ms.sms", true);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange("exchange.ms");
    }

    @Bean
    Binding emailBinding(Queue emailQueue, DirectExchange exchange){
        return BindingBuilder.bind(emailQueue).to(exchange).with("email");
    }

    @Bean
    Binding smsBinding(Queue smsQueue, DirectExchange exchange){
        return BindingBuilder.bind(smsQueue).to(exchange).with("sms");
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
