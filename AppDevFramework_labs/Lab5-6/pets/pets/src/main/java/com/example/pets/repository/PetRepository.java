package com.example.pets.repository;

import com.example.pets.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository  extends JpaRepository<Pet, Long>{
    List<Pet> findByName(String name);
    List<Pet> findByAnimalType(String animalType);
    List<Pet> findByBreed(String breed);
    Pet findPetById(Long id);
    void deletePetsByName(String name);

    @Modifying
    @Query("UPDATE Pet p SET p.name = :#{#pet.name}, p.animalType = :#{#pet.animalType}, p.breed = :#{#pet.breed}, p.age = :#{#pet.age} WHERE p.id = :id")
    Pet updatePet(@Param("id") Long id, @Param("pet") Pet pet);

    List<Pet> findAllByNameAndBreed(String name, String breed);

    @Query("SELECT AVG(p.age) FROM Pet p WHERE p.age = :age")
    Double findAverageByAge(@Param("age") int age);

    @Query("SELECT MAX(p.age) FROM Pet p WHERE p.age = :age")
    Integer findMaxByAge(@Param("age") int age);
}
