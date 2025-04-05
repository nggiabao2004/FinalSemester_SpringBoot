package com.gdu_springboot.springboot_demo.controller;

import com.gdu_springboot.springboot_demo.entity.Authorities;
import com.gdu_springboot.springboot_demo.service.AuthoritiesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/system/authorities")
public class AuthoritiesController {
    private final AuthoritiesService authoritiesService;

    public AuthoritiesController(AuthoritiesService authoritiesService) {
        this.authoritiesService = authoritiesService;
    }

    @GetMapping("/list-user")
    public String list(Model model) {
        List<Authorities> authorities = authoritiesService.findAll();
        model.addAttribute("authorities", authorities);
        return "admin/authorities/list-user"; // View danh sách quyền
    }

    @GetMapping("/form-insert")
    public String formInsert(Model model) {
        Authorities authority = new Authorities();
        model.addAttribute("authority", authority);
        return "admin/authorities/user-form-insert"; // Form thêm mới
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("authority") Authorities authority) {
        authoritiesService.save(authority); // Lưu quyền mới hoặc cập nhật quyền
        return "redirect:/system/authorities/list-user";
    }

    @GetMapping("/form-update")
    public String formUpdate(@RequestParam("id") Long id, Model model) {
        Authorities authority = authoritiesService.findById(id);  // Tìm quyền theo id
        model.addAttribute("authority", authority);  // Truyền authority vào view
        return "admin/authorities/user-form-update"; // Form cập nhật
    }

    @PostMapping("/update")
    public String update(@RequestParam("id") Long id, @ModelAttribute("authority") Authorities authority) {
        authority.setId(id); // Đảm bảo id được gán đúng cho đối tượng authority
        authoritiesService.save(authority); // Lưu quyền đã cập nhật
        return "redirect:/system/authorities/list-user";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("username") String username) {
        authoritiesService.deleteByUsername(username);
        return "redirect:/system/authorities/list-user";
    }

    @GetMapping("/delete-user_role")
    public String delete(@RequestParam("username") String username, @RequestParam("authority") String authority) {
        authoritiesService.deleteByUsernameAndAuthority(username, authority);
        return "redirect:/system/authorities/list-user";
    }
}
