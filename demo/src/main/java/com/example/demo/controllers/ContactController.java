package com.example.demo.controllers;


import com.example.demo.data.ContactEntity;
import com.example.demo.data.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping
    public Object getall() {
        return contactRepository.findAll();
    }

    @PostMapping
    public void save(
            @RequestBody ContactEntity contactEntity
            ) {
        contactRepository.save(contactEntity);
    }

    @DeleteMapping
    public void del(
            @PathParam("id") Long id
    ) {
        contactRepository.deleteById(id);
    }


}
