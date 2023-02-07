package com.example.spring_boot_web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Podvorchan Ruslan 05.02.2023
 */
@Slf4j
public class DispatcherServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    log.info("DispatcherServlet doGet() method is invoked");
    resp.setContentType("text/plain");
    resp.setStatus(200);
    resp.getWriter().println(LocalDate.now());
    resp.getWriter().close();
  }

}
