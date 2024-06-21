package com.javarabbitmq.controller;

import ch.qos.logback.core.testUtil.RandomUtil;
import com.javarabbitmq.service.OrderService;
import com.javarabbitmq.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.TimeoutException;

@Transactional
@RestController
@RequestMapping("/api/rabbit-mq")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(path= "/add-order")
    public void addOrder() throws IOException, TimeoutException {
        Order order = new Order();
        order.setOrderId(RandomUtil.getPositiveInt());
        order.setUserId(RandomUtil.getPositiveInt());
        order.setAmount(new BigDecimal(1000000));
        orderService.sendOrder(order);
    }
}
