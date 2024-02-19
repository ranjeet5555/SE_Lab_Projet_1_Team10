package com.cfp.controller;


import com.cfp.entity.FileEntity;
import com.cfp.repository.FileRepository;
import jakarta.servlet.http.HttpSession;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class DocumentController {
    @Autowired
    FileRepository repo;
    @GetMapping("/uploadhere")
    public Object register(@NotNull Model model) {
        FileEntity file = new FileEntity();
        model.addAttribute("file", file);
        return new ModelAndView("uploadedDoc");
    }

    @PostMapping("/uploadDoc")
    public ModelAndView registerAuthor(@ModelAttribute("file") FileEntity file, HttpSession session) {
        repo.save(file);
        return new ModelAndView("redirect:/dashboard"); // Redirect to the dashboard page after upload
    }
    @GetMapping("/dashboard")
    public ModelAndView dashboard() {
        List<FileEntity> uploadedFiles = repo.findAll();
        ModelAndView modelAndView = new ModelAndView("speaker_Dashboard");
        modelAndView.addObject("uploadedFiles", uploadedFiles);
        return modelAndView;
    }
}
