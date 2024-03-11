package com.cfp.testcase;

import com.cfp.controller.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeControllerTest {
    @Test
    void testHomePage() {
        Object result = HomeController.HomePage();
        assertEquals(ModelAndView.class, result.getClass());
        assertEquals("index", ((ModelAndView) result).getViewName());
    }
}
