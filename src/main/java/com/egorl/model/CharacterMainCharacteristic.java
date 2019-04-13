package com.egorl.model;

public class CharacterMainCharacteristic {
    private String name;
    private int value;

    private int minValue;
    private int maxValue;

    public CharacterMainCharacteristic(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
