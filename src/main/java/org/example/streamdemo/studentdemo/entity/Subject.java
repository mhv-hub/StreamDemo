package org.example.streamdemo.studentdemo.entity;

public enum Subject{

    PHYSICS(1, "Physics"),
    CHEMISTRY(2, "Chemistry"),
    MATHS(3, "Maths"),
    ENGLISH(4, "English"),
    HINDI(5, "Hindi"),
    COMPUTERS(6, "Computer Science");

    private int id;
    private String name;

    Subject(int i, String physics) {
    }
}