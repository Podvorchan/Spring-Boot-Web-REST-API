package com.example.spring_boot_web.controller;

import com.example.spring_boot_web.service.OrderService;
import com.example.spring_boot_web.dto.OrderDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Podvorchan Ruslan 05.02.2023
 */
@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderController {
  private final OrderService orderService;

  @GetMapping("{id}")
  public OrderDto getOrderById(@PathVariable Integer id) {
    if (id < 0) {
      throw new IllegalArgumentException("Order ID < 0 cannot be");
    }
    return orderService.getOrderById(id);
  }

  @GetMapping
  public List<OrderDto> getAllOrders() {
    return orderService.getAllOrders();
  }
}
