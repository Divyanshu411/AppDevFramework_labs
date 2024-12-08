package com.example.pets.service;

import com.example.pets.entity.Household;

import java.util.List;

public interface HouseholdService {
    List<Household> getAllHouseholds();

    Household findByEircode(String eircode);

    Household findHouseholdByEircodeWithPets(String eircode);

    List<Household> findHouseholdsWithNoPets();

    void deleteHouseholdByEircode(String eircode);

    Household createHousehold(Household household);
}
