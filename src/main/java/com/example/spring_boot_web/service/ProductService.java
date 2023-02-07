package com.example.spring_boot_web.service;

import com.example.spring_boot_web.dto.ProductDto;
import com.example.spring_boot_web.model.Product;
import com.example.spring_boot_web.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Podvorchan Ruslan 05.02.2023
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

  private final ProductRepository productRepository;
  private final ObjectMapper objectMapper;


  public ProductDto createProduct(ProductDto productDto) {
    Product product = objectMapper.convertValue(productDto, Product.class);
    // productRepository.save(product);
    productDto.setId(product.getId());
    log.info("Product id:{} created", productDto.getId());
    return productDto;

  }

  public ProductDto findById(Integer id) {
    var Id = productRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("!!!"));
    return objectMapper.convertValue(Id, ProductDto.class);
  }

  public void deleteProduct(Integer Id) {
    productRepository.deleteById(Id);
  }

}
