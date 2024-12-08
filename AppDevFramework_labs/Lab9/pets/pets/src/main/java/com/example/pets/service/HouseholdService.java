package com.example.pets.service;

import com.example.pets.entity.Household;

import java.util.List;

public interface HouseholdService {
    Household findByEircode(String eircode);

    Household findHouseholdByEircodeWithPets(String eircode);

    List<Household> findHouseholdsWithNoPets();

    List<Household> getAllHouseholds();

    void deleteHousehold(String eircode);
    Household createHousehold(Household household);
}
