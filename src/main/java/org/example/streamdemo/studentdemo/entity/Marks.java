package org.example.streamdemo.studentdemo.entity;

import java.util.Map;

public class Marks {

    private int id;
    private Map<Subject, Double> marksMap;

    public Marks(){

    }

    public Marks(int id, Map<Subject, Double> marksMap) {
        this.id = id;
        this.marksMap = marksMap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Subject, Double> getMarksMap() {
        return marksMap;
    }

    public void setMarksMap(Map<Subject, Double> marksMap) {
        this.marksMap = marksMap;
    }

    @Override
    public String toString() {
        return "Marks{" +
                "id=" + id +
                ", marksMap=" + marksMap +
                '}';
    }
}
