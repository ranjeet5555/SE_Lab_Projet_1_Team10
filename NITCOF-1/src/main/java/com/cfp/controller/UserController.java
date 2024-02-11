package com.cfp.controller;

import com.cfp.entity.User;
import com.cfp.repository.UserRepo;
import com.cfp.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserRepo repo;
    @Autowired
    private UserService service;

    @GetMapping("/")
    public String homepage(){
        return "index";
    }

    @GetMapping("/edituser/{id}")
    public String edit(@PathVariable int id, Model m){
        User user = service.getuserById(id);
        m.addAttribute( "user", user);
        return "edit_user";
    }

    @GetMapping("/updateuserDetails")
    public String updateuser(@ModelAttribute User user, HttpSession session){
        User updateuser = service.save(user);

        if(updateuser != null){
            session.setAttribute("msg","Update successfully");
        }
        else{
            session.setAttribute("msg","something wrong on server");
        }

        return "redirect:/";
    }
    
    @GetMapping("/signup")
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

