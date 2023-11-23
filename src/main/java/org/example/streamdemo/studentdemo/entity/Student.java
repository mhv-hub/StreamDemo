package org.example.streamdemo.studentdemo.entity;

import java.util.List;

public class Student {

    private long id;
    private String name;
    private Department department;
    private String standard;
    private List<MarksWrapper> marksWrappers;

    public Student(){

    }

    public Student(long id, String name, Department department, String standard, List<MarksWrapper> marksWrappers) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.standard = standard;
        this.marksWrappers = marksWrappers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public List<MarksWrapper> getMarksWrappers() {
        return marksWrappers;
    }

    public void setMarksWrappers(List<MarksWrapper> marksWrappers) {
        this.marksWrappers = marksWrappers;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + department +
                ", standard='" + standard + '\'' +
                ", marksWrappers=" + marksWrappers +
                '}';
    }
}
