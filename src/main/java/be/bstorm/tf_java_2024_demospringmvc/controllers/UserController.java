package be.bstorm.tf_java_2024_demospringmvc.controllers;

import be.bstorm.tf_java_2024_demospringmvc.models.User;
import be.bstorm.tf_java_2024_demospringmvc.models.UserDTO;
import be.bstorm.tf_java_2024_demospringmvc.models.UserLoginForm;
import be.bstorm.tf_java_2024_demospringmvc.models.UserRegisterForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private static List<User> users = new ArrayList<>();

    public UserController() {
        users.add(new User("Dante","Test1234=",180, LocalDate.of(1991,3,27)));
        users.add(new User("Vergil","Test1234=",180, LocalDate.of(1991,3,27)));
        users.add(new User("Nero","Test1234=",180, LocalDate.of(1991,3,27)));
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
        model.addAttribute("form", new UserLoginForm());
        return "user/login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute("form") UserLoginForm form, Model model) {
        User user = users.stream()
                .filter(u -> u.getUsername().equals(form.getUsername()))
                .findFirst().orElseThrow();

        if(!user.getPassword().equals(form.getPassword())) {
            model.addAttribute("error", "Wrong password");
            return "user/login";
        }

        return "redirect:/";
    }

    @GetMapping("/register")
    public String register(Model model) {

        model.addAttribute("form",new UserRegisterForm());
        return "/user/register";
    }

    @PostMapping("/register")
    public String registerSubmit(@Valid @ModelAttribute("form") UserRegisterForm form,
                                 BindingResult bindingResult,
                                 Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("form",form);
            return "user/register";
        }
        users.add(form.toUser());
        return "redirect:/user";
    }
}
