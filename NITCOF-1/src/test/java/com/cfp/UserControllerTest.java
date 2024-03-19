//package com.cfp;
//
//import com.cfp.controller.UserController;
//import com.cfp.entity.User;
//import com.cfp.repository.FileRepository;
//import com.cfp.repository.UserRepository;
//import com.cfp.service.UserService;
//import jakarta.servlet.http.HttpSession;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.ui.Model;
//import org.springframework.web.servlet.ModelAndView;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//public class UserControllerTest {
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Mock
//    private UserService userService;
//
//    @Mock
//    private FileRepository fileRepository;
//
//    @InjectMocks
//    private UserController userController;
//
//    @Mock
//    private HttpSession session;
//
//    @Mock
//    private Model model;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
////    @Test
////    public void testRegistrationPage() {
////        ModelAndView modelAndView = (ModelAndView) userController.RegistrationPage(model);
////        assertEquals("register", modelAndView.getViewName());
////        User user = (User) modelAndView.getModel().get("user");
////        assertEquals(new User(), user);
////    }
//
//    @Test
//    public void testRegisterAuthor_UserExists() {
//        User existingUser = new User();
//        existingUser.setUsername("existingUser");
//        when(userRepository.findByUsername(existingUser.getUsername())).thenReturn(existingUser);
//
//        User user = new User();
//        user.setUsername("existingUser");
//        ModelAndView modelAndView = userController.RegisterAuthor(user, session);
//        assertEquals("redirect:/signup", modelAndView.getViewName());
//        assertEquals("Username already exists", session.getAttribute("message1"));
//    }
//
//    // Write similar test methods for other controller methods
//}
