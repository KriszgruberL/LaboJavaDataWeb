package com.example.labojavadataweb.models.entities;

import lombok.Getter;

@Getter
public enum Era {

    VICTORIAN("Victorian"),
    REGENCY("Regency"),
    EDWARDIAN("Edwardian"),
    ELIZABETHAN("Elizabethan"),
    CENTURY_18("18th Century"),
    TUDOR("Tudor"),
    MODERN("Modern");

    private final String value;

    Era(String value) {
        this.value = value;
    }

    public static Era fromString(String value) {
        for (Era era : Era.values()) {
            if (era.value.equalsIgnoreCase(value)) {
                return era;
            }
        }
        throw new IllegalArgumentException("Invalid Era value: " + value);
    }

}
