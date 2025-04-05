package com.gdu_springboot.springboot_demo.controller;

import com.gdu_springboot.springboot_demo.entity.User;
import com.gdu_springboot.springboot_demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/system/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Hiển thị danh sách người dùng
    @GetMapping("/list")
    public String listUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "admin/users/list-username";
    }

    // Hiển thị form thêm user
    @GetMapping("/form-insert")
    public String formInsert(Model model) {
        model.addAttribute("user", new User());
        return "admin/users/username-form-insert";
    }

    // Lưu user mới với validation
    @PostMapping("/save")
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "admin/users/username-form-insert"; // Hiển thị lại form nếu có lỗi
        }
        userService.save(user);
        return "redirect:/system/users/list";
    }

    // Hiển thị form cập nhật user
    @GetMapping("/form-update")
    public String formUpdate(@RequestParam("username") String username, Model model) {
        User user = userService.findByUsername(username);
        model.addAttribute("user", user);
        return "admin/users/username-form-update";
    }

    // Cập nhật thông tin user
    @PostMapping("/update")
    public String updateUser(@RequestParam String username, @RequestParam boolean enabled) {
        userService.updateUser(username, enabled);
        return "redirect:/system/users/list";
    }

    // Xóa người dùng
    @GetMapping("/delete")
    public String deleteUser(@RequestParam("username") String username) {
        userService.deleteByUsername(username);
        return "redirect:/system/users/list";
    }

    // Cập nhật mật khẩu
    @PostMapping("/update-password")
    public String updatePassword(@RequestParam String username, @RequestParam String newPassword) {
        userService.updatePassword(username, newPassword);
        return "redirect:/system/users/list";
    }
}
