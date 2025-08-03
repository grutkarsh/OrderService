package com.tcs.orderservice.service;

import com.tcs.orderservice.entity.OrderEntity;
import com.tcs.orderservice.model.OrderRequest;
import com.tcs.orderservice.repository.OrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class OrderServiceImpl implements Orderservice{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Long createOrder(OrderRequest orderRequest) {

        log.info("placing order Request {}",orderRequest);

        OrderEntity orderEntity=OrderEntity.builder().productId(orderRequest.getProductId())
                .quantity(orderRequest.getQuantity())
                .orderDate(Instant.now())
                .amount(orderRequest.getTotalAmount())
                .orderStatus("CREATED")
                .build();
        orderRepository.save(orderEntity);

        log.info("order placed with order ID{} ",orderEntity.getId());

        return orderEntity.getId();
    }
}
