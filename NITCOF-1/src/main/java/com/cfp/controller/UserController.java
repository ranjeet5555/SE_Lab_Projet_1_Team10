package com.cfp.controller;

import com.cfp.entity.User;
import com.cfp.repository.UserRepo;
import com.cfp.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserRepo repo;
    @Autowired
    private UserService service;

    @GetMapping("/")
    public String register(@org.jetbrains.annotations.NotNull Model model){
        User user=new User();
        model.addAttribute("user",user);
        return "register";
    }
    @PostMapping("/registerUser")
    public String registerAuthor(@ModelAttribute("user") User user){
        service.registerUser(user);
        return "login";
    }
    @GetMapping("/login")
    public String login(@NotNull Model model){
        User user=new User();
        model.addAttribute("user",user);
        return "login";
    }
    @PostMapping("/signing")
    public String loginAuthor(@ModelAttribute("user") @NotNull User user){
        String userID=user.getUsername();
        Optional<User> data= Optional.ofNullable(repo.findByusername(userID));
        if(user.getPassword().equals(data.get().getPassword())){
            return "speaker_Dashboard";
        }
        else{
            return "register";
        }
    }
}

