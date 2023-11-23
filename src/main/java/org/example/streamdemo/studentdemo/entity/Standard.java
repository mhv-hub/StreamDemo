package org.example.streamdemo.studentdemo.entity;

import java.util.List;

public enum Standard {

    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10");

    private final String digitValue;

    public String getDigitValue() {
        return digitValue;
    }

    Standard(String digit) {
        this.digitValue = digit;
    }
}
