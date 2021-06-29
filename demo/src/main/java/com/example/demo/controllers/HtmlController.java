package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {


    @GetMapping()
    public String index(Model model) {
        return "index";
    }

    @GetMapping("contact")
    public String contact() {
        return "contact";
    }


    @GetMapping("product")
    public String byWorld() {
        return "file1.html";
    }

    @GetMapping("about")
    public String about() {
        return "about";
    }

    @GetMapping("shop")
    public String shop() {
        return "shop";
    }

    @GetMapping("shop-single")
    public String shopSingle() {
        return "shop-single";
    }

    @GetMapping("admin-panel")
    public String adminPanel() {
        return "admin-panel";
    }

    @GetMapping("task")
    public String task () {
        return "task";
    }


}
