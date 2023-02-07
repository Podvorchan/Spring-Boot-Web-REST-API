package com.example.spring_boot_web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Podvorchan Ruslan 05.02.2023
 */
@RestController
public class PingController {

  @GetMapping("ping")
  public String ping() {
    return "Ok";
  }

}
