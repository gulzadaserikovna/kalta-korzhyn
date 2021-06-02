package com.example.demo.controllers;


import com.example.demo.data.ProductEntity;
import com.example.demo.data.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Date;

@RestController
@RequestMapping ("/api/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public Object getAll() {

        return productRepository.findAll();
    }

    @PostMapping
    public void save(
            @RequestBody ProductEntity productEntity
    ) {
        productEntity.setCreateDate(new Date());
        productEntity.setUpdateDate(new Date());
        productRepository.save(productEntity);
    }

    @DeleteMapping
    public void del(
            @PathParam("id") Long id
    ) {
        productRepository.deleteById(id);
    }


}
