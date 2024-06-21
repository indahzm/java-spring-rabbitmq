package com.javarabbitmq.service;

import com.javarabbitmq.entity.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumerService {

//    @RabbitListener(queues = {"${spring.rabbitmq.queue.name}"})
//    public void consume(Order order) {
//        System.out.println("---MESSAGE OUTPUT --- " + "orderId : " + order.getOrderId() + "\n userId : " + order.getUserId() + "\n amount : " + order.getAmount().toString());
//    }
}
