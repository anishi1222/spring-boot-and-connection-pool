package com.example.demo99;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.Optional;

@Controller
@RequestMapping(path="/pets")
public class PetController {
    @Autowired
    private PetRepository petRepository;

    @PostMapping
    public @ResponseBody String createPet(@RequestBody Pet pet) {
        petRepository.save(pet);
        return String.format("Added %s", pet);
    }

    @GetMapping
    public @ResponseBody Iterable<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Pet> getPet(@PathVariable Integer id) {
        return Optional.ofNullable(petRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public @ResponseBody String deletePet(@PathVariable Integer id) {
        petRepository.deleteById(id);
        return "Deleted " + id;
    }

    @PostMapping("/con")
    public @ResponseBody String addConnection() {
        return "OK";
    }
}