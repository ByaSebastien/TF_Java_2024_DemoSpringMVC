package be.bstorm.tf_java_2024_demospringmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {



    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping("/hello/{name}")
    public String hello(Model model, @PathVariable String name) {
        String lastname = "Bya";
        model.addAttribute("name", name);
        model.addAttribute("lastname", lastname);
        return "hello";
    }
}
