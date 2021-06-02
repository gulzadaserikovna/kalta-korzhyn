package com.example.demo.data;

import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
}
