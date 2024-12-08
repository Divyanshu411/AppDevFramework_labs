package com.example.pets.controller;

import com.example.pets.entity.Household;
import com.example.pets.entity.Pet;
import com.example.pets.service.HouseholdService;
import com.example.pets.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class GraphQLController {

    private HouseholdService householdService;
    private PetService petService;

    @QueryMapping
    List<Household> getAllHouseholds() {
        return householdService.getAllHouseholds();
    }

    @QueryMapping
    List<Pet> getPetsByAnimalType(@Argument String animalType) {
        return petService.findPetsByAnimalType(animalType);
    }

    @QueryMapping
    Household getHousehold(@Argument String eircode) {
        return householdService.findByEircode(eircode);
    }

    @QueryMapping
    Pet getPet(@Argument Long id) {
        return petService.getPetById(id);
    }

    @QueryMapping
    Object getPetStatistics(@Argument int age) {
        return petService.getPetStatistics(age);
    }

    @MutationMapping
    Household createHousehold(@Argument("household") AddHousehold addHousehold) throws ChangeSetPersister.NotFoundException {
        Household household = new Household();
        household.setEircode(addHousehold.getEircode());
        household.setNumberOfOccupants(addHousehold.getNumberOfOccupants());
        household.setMaxNumberOfOccupants(addHousehold.getMaxNumberOfOccupants());
        household.setOwnerOccupied(addHousehold.isOwnerOccupied());
        return householdService.createHousehold(household);
    }

    @MutationMapping
    public int deleteHousehold(@Argument String eircode) throws ChangeSetPersister.NotFoundException {
        householdService.deleteHousehold(eircode);
        return 1;
    }

    @MutationMapping
    public int deletePet(@Argument Long id) throws ChangeSetPersister.NotFoundException {
        petService.deletePetById(id);
        return 1;
    }
}
