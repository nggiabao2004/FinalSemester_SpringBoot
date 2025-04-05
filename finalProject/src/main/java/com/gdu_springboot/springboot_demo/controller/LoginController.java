package com.gdu_springboot.springboot_demo.controller;

import com.gdu_springboot.springboot_demo.entity.Product;
import com.gdu_springboot.springboot_demo.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//08mar2025
@Controller
public class LoginController {

    private final ProductService productService;

    public LoginController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(Model model) {
//        List<Product> randomProducts = productService.getRandomProducts(3); // Lấy 3 sản phẩm ngẫu nhiên
//        model.addAttribute("products", randomProducts);
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/system")
    public String system() {
        return "system";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }
}