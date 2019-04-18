package com.egorl.model;

import java.awt.*;

public class CharacterAbility {
    private String name;
    private int value;

    private Image icon;

    public CharacterAbility(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public CharacterAbility(String name, int value, Image icon) {
        this.name = name;
        this.value = value;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
