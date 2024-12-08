package com.example.pets.controller;

import com.example.pets.entity.Pet;
import com.example.pets.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {
        return ResponseEntity.ok(petService.createPet(pet));
    }

    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets() {
        return ResponseEntity.ok(petService.getAllPets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable Long id) {
        return ResponseEntity.ok(petService.getPetById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable Long id, @RequestBody Pet pet) {
        return ResponseEntity.ok(petService.updatePet(id, pet));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePetById(@PathVariable Long id) {
        petService.deletePetById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/name/{name}")
    public ResponseEntity<Void> deletePetsByName(@PathVariable String name) {
        petService.deletePetsByName(name);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/type/{animalType}")
    public ResponseEntity<List<Pet>> findPetsByAnimalType(@PathVariable String animalType) {
        return ResponseEntity.ok(petService.findPetsByAnimalType(animalType));
    }

    @GetMapping("/breed/{breed}")
    public ResponseEntity<List<Pet>> findPetsByBreed(@PathVariable String breed) {
        return ResponseEntity.ok(petService.findPetsByBreed(breed));
    }

    @GetMapping("/statistics")
    public ResponseEntity<?> getPetStatistics(int age) {
        return ResponseEntity.ok(petService.getPetStatistics(age));
    }
}
