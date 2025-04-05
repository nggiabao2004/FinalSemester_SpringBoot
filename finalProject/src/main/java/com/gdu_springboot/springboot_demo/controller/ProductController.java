package com.gdu_springboot.springboot_demo.controller;

import com.gdu_springboot.springboot_demo.entity.Product;
import com.gdu_springboot.springboot_demo.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list-product")
    public String list(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "admin/products/list-product";
    }

    @GetMapping("/product-form-insert")
    public String formInsert(Model model) {
        model.addAttribute("product", new Product());
        return "admin/products/product-form-insert";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model) {
        System.out.println("Valid Error: "+bindingResult.hasErrors());
        if (bindingResult.hasErrors()) {
            return "admin/products/product-form-insert"; // Quay lại form nhập nếu có lỗi
        }
        productService.save(product);
        return "redirect:/admin/products/list-product";
    }

    @GetMapping("/product-form-update")
    public String formUpdate(@RequestParam("id") int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "admin/products/product-form-update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "admin/products/product-form-update"; // Quay lại form cập nhật nếu có lỗi
        }
        productService.save(product);
        return "redirect:/admin/products/list-product";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        productService.deleteById(id);
        return "redirect:/admin/products/list-product";
    }
}
