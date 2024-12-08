package com.example.pets.service;
import com.example.pets.repository.PetRepository;
import org.springframework.stereotype.Service;
import com.example.pets.entity.Pet;

import java.util.List;

@Service
public class PetServiceImplementation implements PetService{

    private final PetRepository petRepository;

    public PetServiceImplementation(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Pet createPet(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Pet getPetById(Long id)  {
        return petRepository.findPetById(id);
    }

    @Override
    public Pet updatePet(Long id, Pet pet) {
        return petRepository.updatePet(id, pet);
    }

    @Override
    public void deletePetById(Long id) {
        petRepository.deleteById(id);
    }

    @Override
    public void deletePetsByName(String name) {
        petRepository.deletePetsByName(name);
    }

    @Override
    public List<Pet> findPetsByAnimalType(String animalType) {
        return petRepository.findByAnimalType(animalType);
    }

    @Override
    public List<Pet> findPetsByBreed(String breed) {
        return petRepository.findByBreed(breed);
    }

    @Override
    public List<Pet> getNameAndBreedOnly(String name, String breed) {
        return petRepository.findAllByNameAndBreed(name, breed);
    }

    @Override
    public String getPetStatistics(int age) {
        Double averageAge = petRepository.findAverageByAge(age);
        Integer oldestAge = petRepository.findMaxByAge(age);
        return String.format("Average Age: %.2f, Oldest Age: %d",
                averageAge != null ? averageAge : 0.0,
                oldestAge != null ? oldestAge : 0);
    }
}
