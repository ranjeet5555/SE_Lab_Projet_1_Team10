import com.cfp.entity.User;
import com.cfp.repository.UserRepo;
import com.cfp.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * Controller class for handling user-related operations.
 */
@Controller
public class UserController {

    @Autowired
    private UserRepo repo;
    
    @Autowired
    private UserService service;

    /**
     * Redirects to the home page.
     *
     * @return The name of the home view template.
     */
    @GetMapping("/")
    public String homepage() {
        return "home";
    }

    /**
     * Displays the form to edit user details.
     *
     * @param id User ID to be edited.
     * @param m  Model to add user attributes for the view.
     * @return The name of the edit_user view template.
     */
    @GetMapping("/edituser/{id}")
    public String edit(@PathVariable int id, Model m) {
        User user = service.getuserById(id);
        m.addAttribute("user", user);
        return "edit_user";
    }

    /**
     * Updates user details based on the provided form data.
     *
     * @param user    User details to be updated.
     * @param session HttpSession for storing success/failure messages.
     * @return Redirects to the home page.
     */
    @GetMapping("/updateuserDetails")
    public String updateuser(@ModelAttribute User user, HttpSession session) {
        User updateuser = service.saveUser(user);

        if (updateuser != null) {
            session.setAttribute("msg", "Update successfully");
        } else {
            session.setAttribute("msg", "something wrong on server");
        }

        return "redirect:/";
    }

    /**
     * Displays the registration form.
     *
     * @param model Model to add the user attribute for the view.
     * @return The name of the register view template.
     */
    @GetMapping("/signup")
    public String register(@NotNull Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    /**
     * Registers a new user.
     *
     * @param user User details to be registered.
     * @return The name of the login view template.
     */
    @PostMapping("/registerUser")
    public String registerAuthor(@ModelAttribute("user") User user) {
        service.registerUser(user);
        return "login";
    }

    /**
     * Displays the login form.
     *
     * @param model Model to add the user attribute for the view.
     * @return The name of the login view template.
     */
    @GetMapping("/login")
    public String login(@NotNull Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    /**
     * Authenticates the user based on the provided credentials.
     *
     * @param user User credentials for authentication.
     * @return Redirects to "speaker_Dashboard" if authentication is successful, or "register" if authentication fails.
     */
    @PostMapping("/signing")
    public String loginAuthor(@ModelAttribute("user") @NotNull User user) {
        String userID = user.getUsername();
        Optional<User> data = Optional.ofNullable(repo.findByusername(userID));
        if (user.getPassword().equals(data.get().getPassword())) {
            return "speaker_Dashboard";
        } else {
            return "register";
        }
    }
}
