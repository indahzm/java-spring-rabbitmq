package com.javarabbitmq.service;

import com.javarabbitmq.entity.Order;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Service
@Transactional
public class OrderService {
//    @Autowired
//    private ConnectionFactory connectionFactory;

    @Value("${spring.rabbitmq.exchange.name}")
    private String exchange;
    @Value("${spring.rabbitmq.routing.key}")
    private String routingKey;

    private RabbitTemplate rabbitTemplate;

    public OrderService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendOrder(Order order) throws IOException, TimeoutException {
        System.out.println("orderId : " + order.getOrderId() + "\n userId : " + order.getUserId() + "\n amount : " + order.getAmount().toString());
//        Connection connection = connectionFactory.newConnection();
//        Channel channel = connection.createChannel();
//
//        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
//                .build();
//        channel.basicPublish("order-proses", "QUEUE_ADD_ORDER", properties, order.getOrderId().toString().getBytes());
//
//        channel.close();
//        connection.close();

        rabbitTemplate.convertAndSend(exchange,routingKey, "orderId : " + order.getOrderId() + "\n userId : " + order.getUserId() + "\n amount : " + order.getAmount().toString());
    }
}
