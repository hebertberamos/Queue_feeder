package com.senderToQueue.messageSenderToQueue;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class MessageSenderToQueueApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageSenderToQueueApplication.class, args);
	}

}
