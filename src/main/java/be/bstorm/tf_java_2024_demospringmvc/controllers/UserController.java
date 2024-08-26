package be.bstorm.tf_java_2024_demospringmvc.controllers;

import be.bstorm.tf_java_2024_demospringmvc.models.User;
import be.bstorm.tf_java_2024_demospringmvc.models.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

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

    


}
