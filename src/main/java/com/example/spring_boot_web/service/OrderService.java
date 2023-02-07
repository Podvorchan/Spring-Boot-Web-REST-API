package com.example.spring_boot_web.service;

import static java.util.stream.Collectors.toList;

import com.example.spring_boot_web.dto.OrderDto;
import com.example.spring_boot_web.model.Order;
import com.example.spring_boot_web.repository.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Podvorchan Ruslan 05.02.2023
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

  private final OrderRepository orderRepository;
  private final ObjectMapper objectMapper;

  public OrderDto createOrder(OrderDto orderDto) {
    Order order = objectMapper.convertValue(orderDto, Order.class);
    order = orderRepository.save(order);
    orderDto.setId(order.getId());
    log.info("Order id:{}  created", orderDto.getId());
    return orderDto;
  }

  public List<OrderDto> getAllOrders() {
    List<Order> orders = (List<Order>) orderRepository.findAll();
    return orders.stream()
        .map(o -> objectMapper.convertValue(o, OrderDto.class))
        .collect(toList());

  }

  public OrderDto getOrderById(Integer id) {
    Order order = orderRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    return objectMapper.convertValue(order, OrderDto.class);

  }
}
