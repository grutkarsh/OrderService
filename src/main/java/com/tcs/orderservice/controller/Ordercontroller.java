package com.tcs.orderservice.controller;

import com.tcs.orderservice.model.OrderRequest;
import com.tcs.orderservice.service.Orderservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/order")
@RestController
public class Ordercontroller {

    @Autowired
    Orderservice orderservice;

    @PostMapping("/create")
    public ResponseEntity<Long> createOrder(@RequestBody OrderRequest orderRequest) {
        Long orderID = orderservice.createOrder(orderRequest);


        return new ResponseEntity<>(orderID, HttpStatus.CREATED);
    }
}
