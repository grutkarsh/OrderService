package com.tcs.orderservice.service;

import com.tcs.orderservice.model.OrderRequest;

public interface Orderservice {


    Long createOrder(OrderRequest orderRequest);
}
