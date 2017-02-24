package com.statistics.models.classes;

public enum ROLE {

    USER("ONE"),
    ADMIN("TWO");

    private final String text;

    ROLE(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
