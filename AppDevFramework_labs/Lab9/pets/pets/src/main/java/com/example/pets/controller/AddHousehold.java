package com.example.pets.controller;

import lombok.Data;

@Data
public class AddHousehold {
    private String eircode;
    private int numberOfOccupants;
    private int maxNumberOfOccupants;
    private boolean ownerOccupied;
}
