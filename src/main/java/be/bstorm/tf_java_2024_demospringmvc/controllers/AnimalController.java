package be.bstorm.tf_java_2024_demospringmvc.controllers;

import be.bstorm.tf_java_2024_demospringmvc.entities.Animal;
import be.bstorm.tf_java_2024_demospringmvc.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/animal")
public class AnimalController {

    private final AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping
    public String animals(Model model) {
        List<Animal> animals = animalRepository.findAll();

//        Page<Animal> animals1 = animalRepository.findAll(PageRequest.of(5,10));

        model.addAttribute("animals", animals);
        return "animal/index";
    }

    @PostMapping("/add")
    public String addAnimal(@ModelAttribute("animal") Animal animal) {
        animalRepository.save(animal);
        return "redirect:/animal";
    }
}
