package com.example.pets.controller;

import com.example.pets.entity.Household;
import com.example.pets.service.HouseholdService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/households")
public class HouseholdController {
    private final HouseholdService householdService;

    public HouseholdController(HouseholdService householdService) {
        this.householdService = householdService;
    }

    @GetMapping
    public ResponseEntity<List<Household>> getAllHouseholds() {
        return ResponseEntity.ok(householdService.getAllHouseholds());
    }

    @GetMapping("/nopets")
    public ResponseEntity<List<Household>> getHouseholdsWithNoPets() {
        return ResponseEntity.ok(householdService.findHouseholdsWithNoPets());
    }

    @GetMapping("/{eircode}")
    public ResponseEntity<Household> getHouseholdByEircode(@PathVariable String eircode) {
        return ResponseEntity.ok(householdService.findHouseholdByEircodeWithPets(eircode));
    }

    @DeleteMapping("/{eircode}")
    public ResponseEntity<Void> deleteHousehold(@PathVariable String eircode) {
        householdService.deleteHouseholdByEircode(eircode);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Household> createHousehold(@RequestBody @Valid Household household) {
        Household createdHousehold = householdService.createHousehold(household);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHousehold);
    }
}
