package com.example.projectSpringBoot.controller;


import com.example.projectSpringBoot.model.User;
import com.example.projectSpringBoot.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/pages")
public class UsersController {
    private final UserServiceImpl userService;

    public UsersController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String getUser(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "index";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.create(user);
        return "redirect:/pages";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.update(id, user);
        return "redirect:/pages";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/pages";
    }
}
