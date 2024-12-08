package com.example.pets.service;

import com.example.pets.entity.Household;
import com.example.pets.repository.HouseholdRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseholdServiceImplementation implements HouseholdService{

    private final HouseholdRepository householdRepository;

    public HouseholdServiceImplementation(HouseholdRepository householdRepository) {
        this.householdRepository = householdRepository;
    }

    @Override
    public Household findByEircode(String eircode) {
        return householdRepository.findById(eircode).orElseThrow(() -> new RuntimeException("Household not found"));
    }

    @Override
    public Household findHouseholdByEircodeWithPets(String eircode) {
        return householdRepository.findByEircodeWithPets(eircode);
    }


    @Override
    public List<Household> findHouseholdsWithNoPets() {
        return householdRepository.findHouseholdsWithNoPets();
    }

    @Override
    public List<Household> getAllHouseholds() {
        return householdRepository.findAll();
    }

    @Override
    public void deleteHousehold(String eircode) {
       householdRepository.deleteById(eircode);
    }

    @Override
    public Household createHousehold(Household household) {
        return householdRepository.save(household);
    }
}
