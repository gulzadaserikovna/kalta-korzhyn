package com.example.demo.controllers;

import com.example.demo.data.HumanEntity;
import com.example.demo.data.HumanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Map;

@RestController
@RequestMapping("api/human")
public class HumanController {

    @Autowired
    private HumanRepository humanRepository;

    @GetMapping
    public Object getAll() {
        return humanRepository.findAll();
    }

    @PostMapping
    public void save(
            @RequestBody HumanEntity humanEntity
    ) {
        humanRepository.save(humanEntity);
    }

    @DeleteMapping
    public void del(
            @PathParam("id") Long id
    ) {
        humanRepository.deleteById(id);
    }

}
