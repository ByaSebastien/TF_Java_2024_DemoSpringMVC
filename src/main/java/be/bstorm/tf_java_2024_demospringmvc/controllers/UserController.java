package be.bstorm.tf_java_2024_demospringmvc.controllers;

import be.bstorm.tf_java_2024_demospringmvc.models.User;
import be.bstorm.tf_java_2024_demospringmvc.models.UserDTO;
import be.bstorm.tf_java_2024_demospringmvc.models.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    private static List<User> users = new ArrayList<>();

    public UserController() {
        users.add(new User("Dante","Test1234="));
        users.add(new User("Vergil","Test1234="));
        users.add(new User("Nero","Test1234="));
    }

    @GetMapping
    public String getUsers(Model model) {
        List<UserDTO> userDTOs = users.stream()
                .map(UserDTO::fromUser)
                .toList();
        model.addAttribute("users", userDTOs);
        return "user/index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("form", new UserForm());
        return "user/login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute("form") UserForm form, Model model) {
        User user = users.stream()
                .filter(u -> u.getUsername().equals(form.getUsername()))
                .findFirst().orElseThrow();

        if(!user.getPassword().equals(form.getPassword())) {
            model.addAttribute("error", "Wrong password");
            return "user/login";
        }

        return "redirect:/";
    }




}
