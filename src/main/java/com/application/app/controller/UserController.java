package com.application.app.controller;

import com.application.app.entity.User;
import com.application.app.mapper.UserMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") Integer id, Model model) {
        User user = userMapper.getId(id);
        model.addAttribute("user", user);
        return "user-details";
    }

    @GetMapping("/username/{username}")
    public String getUserByUsername(@PathVariable("username") String username, Model model) {
        User user = userMapper.getUsername(username);
        model.addAttribute("user", user);
        return "user-details";
    }

    @GetMapping("/add")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User(null, null, null, false));
        return "user-form";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user) {
        userMapper.addUser(user);
        return "redirect:/user/" + user.getId();
    }

    @GetMapping("/edit/{id}")
    public String showEditUserForm(@PathVariable("id") Integer id, Model model) {
        User user = userMapper.getId(id);
        model.addAttribute("user", user);
        return "user-form";
    }

    @PostMapping("/edit")
    public String updateUser(@ModelAttribute("user") User user) {
        userMapper.updateUser(user);
        return "redirect:/user/" + user.getId();
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") Integer id) {
    userMapper.deleteUser(id);
    return "redirect:/users";
    }

    @GetMapping("/login")
    public String showLoginPage() {
    return "login";
    }

    @PostMapping("/login")
    public String handleLoginSubmit(@RequestParam String username, @RequestParam String password, Model model) {
        // TODO: Add authentication logic
        if (username.equals("admin") && password.equals("admin")) {
            return "redirect:/user/users";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }


    @GetMapping("/signup")
    public String showSignUpPage() {
    return "signup";
    }

    @GetMapping("/users")
    public String showUserList(Model model) {
    List<User> userList = userMapper.getAllUsers();
    model.addAttribute("userList", userList);
    return "user-list";
}



}
