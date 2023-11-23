package org.example.streamdemo.studentdemo.dto;

import org.example.streamdemo.studentdemo.entity.Department;
import org.example.streamdemo.studentdemo.entity.Subject;

import java.util.Map;

public class MarksSumDto {

    private Department department;
    private Map<Subject, Double> avgMarksMap;

    public MarksSumDto(){

    }

    public MarksSumDto(Department department, Map<Subject, Double> avgMarksMap) {
        this.department = department;
        this.avgMarksMap = avgMarksMap;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Map<Subject, Double> getAvgMarksMap() {
        return avgMarksMap;
    }

    public void setAvgMarksMap(Map<Subject, Double> avgMarksMap) {
        this.avgMarksMap = avgMarksMap;
    }

    @Override
    public String toString() {
        return "MarksSumDto{" +
                "department=" + department +
                ", totalMarksMap=" + avgMarksMap +
                '}';
    }
}
