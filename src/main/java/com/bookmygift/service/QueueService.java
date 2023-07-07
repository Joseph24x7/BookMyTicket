package com.bookmygift.service;

import com.bookmygift.entity.Order;
import com.bookmygift.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueueService {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    @SneakyThrows(JsonProcessingException.class)
    public void sendOrderRoutingKey(Order order) {
        rabbitTemplate.convertAndSend("directExchange", "orderRoutingKey", objectMapper.writeValueAsString(order));
    }

    @SneakyThrows(JsonProcessingException.class)
    public void sendCancelRoutingKey(Order order) {
        rabbitTemplate.convertAndSend("directExchange", "cancelRoutingKey", objectMapper.writeValueAsString(order));
    }

    @SneakyThrows(JsonProcessingException.class)
    public void sendOtp(User user) {
        rabbitTemplate.convertAndSend("directExchange", "sendOtpRoutingKey", objectMapper.writeValueAsString(user));
    }

    @SneakyThrows(JsonProcessingException.class)
    public void sendSuccessNotification(User user) {
        rabbitTemplate.convertAndSend("directExchange", "sendVerifySuccessRoutingKey", objectMapper.writeValueAsString(user));
    }
}