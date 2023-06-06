package com.example.labojavadataweb.models.entities;

import lombok.Getter;

@Getter
public enum Type {

    CORSET_OVERBUST("Corset Overbust"),
    CORSET_UNDERBUST("Corset Underbust"),
    CORSET_BELT("Corset Belt"),
    UNDERBUST_BODICE("Underbust Bodice"),
    STAY("Stay"),
    SUPPLIES("Supplies");

    private final String value;

    Type(String value) {
        this.value = value;
    }

    public static Type fromString(String value) {
        for (Type type : Type.values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid Type value: " + value);
    }

}
