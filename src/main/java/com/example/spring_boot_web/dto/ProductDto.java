package com.example.spring_boot_web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Podvorchan Ruslan 05.02.2023
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {

  private Integer id;

  private String name;

  private double cost;


}
