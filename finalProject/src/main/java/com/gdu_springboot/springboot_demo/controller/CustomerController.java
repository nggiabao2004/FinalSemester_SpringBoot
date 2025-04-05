package com.gdu_springboot.springboot_demo.controller;

import com.gdu_springboot.springboot_demo.entity.Customer;
import com.gdu_springboot.springboot_demo.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/customers")
public class CustomerController {
    private CustomerService customerService;
    public CustomerController(CustomerService customerService) {this.customerService = customerService;}

    @GetMapping("/list-customer")
    public String customerList(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "admin/customers/list-customer";
    }

    @GetMapping("/customer-form-insert")
    public String customerFormInsert(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "admin/customers/customer-form-insert";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("customer", customer);
            return "admin/customers/customer-form-insert";
        }
        customerService.save(customer);
        return "redirect:/admin/customers/list-customer";
    }

    @GetMapping("/customer-form-update")
    public String customerFormUpdate(@RequestParam("id") int id, Model model) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return "redirect:/admin/customers/list-customer";
        }
        model.addAttribute("customer", customer);
        return "admin/customers/customer-form-update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("customer") Customer customer, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customer", customer);
            return "admin/customers/customer-form-update";
        }
        customerService.save(customer);
        return "redirect:/admin/customers/list-customer";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        customerService.deleteById(id);
        return "redirect:/admin/customers/list-customer";
    }
}
