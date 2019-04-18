package com.egorl.model;

public class PersonalIndicator {
    private String name;
    private String value;

    public PersonalIndicator(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
