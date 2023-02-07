package com.example.spring_boot_web.repository;

import com.example.spring_boot_web.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Podvorchan Ruslan 05.02.2023
 */
@Repository
public interface ProductRepository extends CrudRepository<Order, Integer> {

}
