package org.example.streamdemo.studentdemo.dto;

public class StudentDto {

    private long id;
    private String name;
    private String standard;
    private String departmentName;

    public StudentDto(){

    }

    public StudentDto(long id, String name, String standard, String departmentName) {
        this.id = id;
        this.name = name;
        this.standard = standard;
        this.departmentName = departmentName;
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

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", standard='" + standard + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
