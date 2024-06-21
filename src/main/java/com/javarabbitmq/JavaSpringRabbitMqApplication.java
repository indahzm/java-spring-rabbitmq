package com.javarabbitmq;

import com.rabbitmq.client.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class JavaSpringRabbitMqApplication {

	public static void main(String[] args) throws Exception {

//		ConnectionFactory factory = new ConnectionFactory();
//		factory.setUri("amqp://guest:guest@localhost:5672/");
//		factory.setVirtualHost("/");
//
//		Connection connection = factory.newConnection();
//		Channel channel = connection.createChannel();
//
//		DeliverCallback deliverCallback = (consumerTag, message) -> {
//			System.out.println(message.getEnvelope().getRoutingKey());
//			System.out.println(new String(message.getBody()));
//		};
//
//		CancelCallback cancelCallback = consumerTag -> {
//			System.out.println("Consumer is canceled");
//		};
//
//		channel.basicConsume("QUEUE_ADD_ORDER", true, deliverCallback, cancelCallback);
		SpringApplication.run(JavaSpringRabbitMqApplication.class, args);
	}

}
