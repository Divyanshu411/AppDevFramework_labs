package com.example.pets.service;
import com.example.pets.entity.Pet;
import java.util.List;
public interface PetService {
    Pet createPet(Pet pet);
    List<Pet> getAllPets();
    Pet getPetById(Long id) ;
    Pet updatePet(Long id, Pet pet);
    void deletePetById(Long id);
    void deletePetsByName(String name);
    List<Pet> findPetsByAnimalType(String animalType);
    List<Pet> findPetsByBreed(String breed);
    List<Pet> getNameAndBreedOnly(String name, String breed);
    String getPetStatistics(int age);
}
