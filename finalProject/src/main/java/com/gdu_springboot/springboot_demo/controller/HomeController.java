package com.gdu_springboot.springboot_demo.controller;

import com.gdu_springboot.springboot_demo.entity.Product;
import com.gdu_springboot.springboot_demo.service.CustomerService;
import com.gdu_springboot.springboot_demo.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    private ProductService productService;

    public HomeController(ProductService productService) {this.productService = productService;}

    @GetMapping("/about-us")
    public String about(){
        return "about-us";
    }
    @GetMapping("/services")
    public String services(Model model){
        List<Product> product = productService.findAll();
        model.addAttribute("products", product);
        return "services";
    }
    @GetMapping("/pricing")
    public String pricing(Model model){
        List<Product> product = productService.findAll();
        model.addAttribute("products", product);
        return "pricing";
    }
    @GetMapping("/blog")
    public String blog(){
        return "blog";
    }
    @GetMapping("/contact-us")
    public String contact(){
        return "contact-us";
    }

    @GetMapping("/detail-product")
    public String detailStudent(@RequestParam("id") int id, Model model){
        Product student = productService.findById(id);
        model.addAttribute("product", student);
        return "detail-product";
    }
}
