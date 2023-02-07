package com.example.spring_boot_web.configuration;

import com.example.spring_boot_web.servlet.DispatcherServlet;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Podvorchan Ruslan 06.02.2023
 */

@Configuration
public class Config {

  @Bean
  ObjectMapper objectMapper() {
    return new ObjectMapper();
  }

  @Bean
  public ServletRegistrationBean dispatcherServletBean() {
    return new ServletRegistrationBean(new DispatcherServlet(), "/my-servlet");
  }

}
