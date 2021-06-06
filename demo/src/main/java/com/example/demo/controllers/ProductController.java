package com.example.demo.controllers;


import com.example.demo.data.ProductEntity;
import com.example.demo.data.ProductImgEntity;
import com.example.demo.data.ProductImgRepository;
import com.example.demo.data.ProductRepository;
import com.example.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.util.Date;

@RestController
@RequestMapping ("/api/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductImgRepository productImgRepository;
    @Autowired
    private FileService fileService;

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


    @GetMapping("{product_id}")
    public Object getAllImg(
            @PathVariable("product_id") Long productId
    ) {
//        return productImgRepository.findAll();
        return null;
    }

    @PostMapping("image")
    public void save(
            @RequestParam("file") MultipartFile multipartFile,
            @RequestParam("name") String name,
            @RequestParam("product_id") Long productId
    ) throws Exception {
        ProductEntity productEntity = productRepository.findById(productId).get();
        String fileLink = fileService.getFileLink(multipartFile, productEntity);

        ProductImgEntity productImgEntity = new ProductImgEntity(
                null,
                name,
                fileLink,
                productEntity
        );

        productImgRepository.save(productImgEntity);
    }

}
