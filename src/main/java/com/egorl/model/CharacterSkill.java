package com.egorl.model;

import java.awt.*;

public class CharacterSkill {
    private String name;
    private boolean isActive;
    private String description;

    private Image icon;

    public CharacterSkill(String name, boolean isActive) {
        this.name = name;
        this.isActive = isActive;
    }

    public CharacterSkill(String name, String description, boolean isActive) {
        this.name = name;
        this.description = description;
        this.isActive = isActive;
    }

    public CharacterSkill(String name, String description, boolean isActive, Image icon) {
        this.name = name;
        this.description = description;
        this.isActive = isActive;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Image getIcon() {
        return icon;
    }

    public boolean isActive() {
        return isActive;
    }
}
