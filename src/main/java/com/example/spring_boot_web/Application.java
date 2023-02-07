package com.example.spring_boot_web;

import com.example.spring_boot_web.dto.OrderDto;
import com.example.spring_boot_web.dto.ProductDto;
import com.example.spring_boot_web.service.OrderService;
import com.example.spring_boot_web.service.ProductService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class Application {

  private final ProductService productService;
  private final OrderService orderService;


  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void start() {
    ProductDto cocaCola = new ProductDto(1, "Coca-Cola", 38.50);
    ProductDto pepsi = new ProductDto(2, "Pepsi", 40.0);
    ProductDto borgomi = new ProductDto(3, "Borgomi", 69.3);
    ProductDto redBull = new ProductDto(4, "RedBull", 59.0);
    productService.createProduct(cocaCola);
    productService.createProduct(pepsi);
    productService.createProduct(borgomi);
    productService.createProduct(redBull);

    List<ProductDto> fullOrders = new ArrayList<>();
    fullOrders.add(cocaCola);
    fullOrders.add(pepsi);
    fullOrders.add(borgomi);
    fullOrders.add(redBull);
    OrderDto full = new OrderDto(1, LocalDate.now(), 206.8, fullOrders);
    orderService.createOrder(full);
    log.info("All products in order {}", orderService.createOrder(full));

  }
}
