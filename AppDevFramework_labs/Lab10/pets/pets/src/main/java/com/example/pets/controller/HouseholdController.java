package com.example.pets.controller;

import com.example.pets.entity.Household;
import com.example.pets.entity.Pet;
import com.example.pets.service.HouseholdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/myapi/households")
public class HouseholdController {

    private final HouseholdService householdService;

    public HouseholdController(HouseholdService householdService) {
        this.householdService = householdService;
    }

    @GetMapping
    public ResponseEntity<List<Household>> getAllHouseholds() {
        return ResponseEntity.ok(householdService.getAllHouseholds());
    }

    @GetMapping("/{eircode}")
    public ResponseEntity<Household> getHouseholdByEircode(@PathVariable String eircode) {
        return ResponseEntity.ok(householdService.findByEircode(eircode));
    }

    @GetMapping("/{eircode}/pets")
    public ResponseEntity<Household> getHouseholdWithPets(@PathVariable String eircode) {
        return ResponseEntity.ok(householdService.findHouseholdByEircodeWithPets(eircode));
    }

    @GetMapping("/nopets")
    public ResponseEntity<List<Household>> getHouseholdsWithNoPets() {
        return ResponseEntity.ok(householdService.findHouseholdsWithNoPets());
    }

    @DeleteMapping("/{eircode}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteHouseholdByEircode(@PathVariable String eircode) {
        householdService.deleteHousehold(eircode);
        return ResponseEntity.noContent().build();
    }
}
