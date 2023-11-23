package org.example.streamdemo.mapdemo;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        MyMap<Employee, Integer> myMap = new MyMap<>();

        IntStream.range(1, 100).forEach(num -> {
            Employee employee = new Employee();
            employee.id = num;
            employee.name = "Akash";
            myMap.inject(employee, employee.id * 10);
        });

        myMap.getNodeSet().forEach(element -> {
            System.out.println(element.getKey() + " -> " + element.getValue());
        });
    }
}

class Employee{

    public int id;
    public String name;

    public Employee() {
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || !obj.getClass().equals(this.getClass())){
            return false;
        }
        Employee emp = (Employee) obj;
        return emp.id == this.id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


