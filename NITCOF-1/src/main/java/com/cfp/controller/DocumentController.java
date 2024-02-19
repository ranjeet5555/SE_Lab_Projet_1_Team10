package com.cfp.controller;


import com.cfp.entity.FileEntity;
import com.cfp.repository.FileRepository;
import jakarta.servlet.http.HttpSession;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@RestController
public class DocumentController {
    @Autowired
    FileRepository fileRepository;
    @GetMapping("/uploadhere")
    public Object register(@NotNull Model model) {
        FileEntity file = new FileEntity();
        model.addAttribute("file", file);
        return new ModelAndView("uploadedDoc");
    }

    @PostMapping("/uploadDoc")
    public ModelAndView registerAuthor(@ModelAttribute("file") FileEntity file, HttpSession session) {
        fileRepository.save(file);
        return new ModelAndView("redirect:/dashboard"); // Redirect to the dashboard page after upload
    }

}
