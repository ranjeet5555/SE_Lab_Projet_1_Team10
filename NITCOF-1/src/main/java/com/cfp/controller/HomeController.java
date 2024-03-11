package com.cfp.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@RestController
public class HomeController {
    // Homepage
    @Contract(value = " -> new", pure = true)
    @GetMapping("/")
    @Operation(summary = "Homepage", description = "Redirects to the homepage.")
    public static @NotNull Object HomePage() {
        return new ModelAndView("index");
    }

}
