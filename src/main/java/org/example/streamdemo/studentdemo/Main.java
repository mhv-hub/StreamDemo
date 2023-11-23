package org.example.streamdemo.studentdemo;

import org.example.streamdemo.studentdemo.dto.MarksSumDto;
import org.example.streamdemo.studentdemo.dto.StudentDto;
import org.example.streamdemo.studentdemo.entity.*;
import org.example.streamdemo.studentdemo.service.StudentService;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Student> studentList = createStudentData();
        studentList.forEach(System.out::println);

        StudentService studentService = new StudentService();

        Map<String, Map<MarksSumDto, List<StudentDto>>> standardWiseMap = studentService.getStandardAndDepartmentWiseMarksMap(studentList, Year.Y23);
        standardWiseMap.forEach((key, value) -> {
            System.out.println("=====================================================================");
            System.out.println("Standard : " + key);
            value.forEach((innerKey, innerValue) -> {
                System.out.println("---------------------------------------------");
                System.out.println("Department wise average marks : " + innerKey);
                System.out.println("Department wise student list : " + innerValue);
            });
            System.out.println("-------------------------------------------------");
        });
        System.out.println("================================================================================");
    }

    public static List<Student> createStudentData(){

        //Departments :
        Department department1 = new Department(1, "CSE");
        Department department2 = new Department(2, "CIV");

        //Akash
        Map<Subject, Double> a91 = new HashMap<>();
        a91.put(Subject.MATHS, 92d);
        a91.put(Subject.PHYSICS, 85d);
        a91.put(Subject.CHEMISTRY, 91d);
        Marks marksA91 = new Marks(1, a91);
        Map<Subject, Double> a92 = new HashMap<>();
        MarksWrapper am91 = new MarksWrapper(1, "9", 1, Year.Y23, 1, Result.PASS, marksA91);
        a92.put(Subject.MATHS, 91d);
        a92.put(Subject.PHYSICS, 80d);
        a92.put(Subject.CHEMISTRY, 81d);
        Marks marksA92 = new Marks(2, a92);
        MarksWrapper am92 = new MarksWrapper(2, "9", 2, Year.Y23, 1, Result.PASS, marksA92);
        Map<Subject, Double> a81 = new HashMap<>();
        a81.put(Subject.MATHS, 73d);
        a81.put(Subject.PHYSICS, 88d);
        a81.put(Subject.CHEMISTRY, 98d);
        Marks marksA81 = new Marks(3, a81);
        MarksWrapper am81 = new MarksWrapper(3, "8", 1, Year.Y22, 1, Result.PASS, marksA81);
        List<MarksWrapper> akashMarksWrapper = new ArrayList<>(Arrays.asList(am92, am91, am81));
        Student akash = new Student(1, "Akash", department1, "9", akashMarksWrapper);

        //Rakesh
        Map<Subject, Double> r91 = new HashMap<>();
        r91.put(Subject.MATHS, 88d);
        r91.put(Subject.PHYSICS, 84d);
        r91.put(Subject.CHEMISTRY, 81d);
        Marks marksR91 = new Marks(4, r91);
        Map<Subject, Double> r92 = new HashMap<>();
        MarksWrapper ar91 = new MarksWrapper(4, "9", 1, Year.Y23, 1, Result.PASS, marksR91);
        r92.put(Subject.MATHS, 78d);
        a92.put(Subject.PHYSICS, 76d);
        a92.put(Subject.CHEMISTRY, 70d);
        Marks marksR92 = new Marks(5, r92);
        MarksWrapper ar92 = new MarksWrapper(5, "9", 2, Year.Y23, 1, Result.PASS, marksR92);
        Map<Subject, Double> r81 = new HashMap<>();
        r81.put(Subject.MATHS, 89d);
        r81.put(Subject.PHYSICS, 80d);
        r81.put(Subject.CHEMISTRY, 93d);
        Marks marksR81 = new Marks(6, r81);
        MarksWrapper ar81 = new MarksWrapper(6, "8", 1, Year.Y22, 1, Result.PASS, marksR81);
        List<MarksWrapper> rMarksWrapper = new ArrayList<>(Arrays.asList(ar92, ar91, ar81));
        Student rakesh = new Student(2, "Rakesh", department2, "9", rMarksWrapper);

        //Supreeth
        Map<Subject, Double> s91 = new HashMap<>();
        s91.put(Subject.MATHS, 56d);
        s91.put(Subject.PHYSICS, 67d);
        s91.put(Subject.CHEMISTRY, 45d);
        Marks marksS91 = new Marks(7, s91);
        Map<Subject, Double> s92 = new HashMap<>();
        MarksWrapper as91 = new MarksWrapper(7, "9", 1, Year.Y23, 1, Result.PASS, marksS91);
        s92.put(Subject.MATHS, 91d);
        s92.put(Subject.PHYSICS, 98d);
        s92.put(Subject.CHEMISTRY, 94d);
        Marks marksS92 = new Marks(8, s92);
        MarksWrapper as92 = new MarksWrapper(8, "9", 2, Year.Y23, 1, Result.PASS, marksS92);
        Map<Subject, Double> s81 = new HashMap<>();
        s81.put(Subject.MATHS, 99d);
        s81.put(Subject.PHYSICS, 89d);
        s81.put(Subject.CHEMISTRY, 92d);
        Marks marksS81 = new Marks(9, s81);
        MarksWrapper as81 = new MarksWrapper(9, "8", 1, Year.Y22, 1, Result.PASS, marksS81);
        List<MarksWrapper> sMarksWrapper = new ArrayList<>(Arrays.asList(as92, as91, as81));
        Student supreeth = new Student(3, "Supreeth", department1, "9", sMarksWrapper);

        //Amit
        Map<Subject, Double> ami91 = new HashMap<>();
        ami91.put(Subject.MATHS, 94d);
        ami91.put(Subject.PHYSICS, 99d);
        ami91.put(Subject.CHEMISTRY, 92d);
        Marks marksAmi91 = new Marks(10, ami91);
        Map<Subject, Double> ami92 = new HashMap<>();
        MarksWrapper mami91 = new MarksWrapper(10, "9", 1, Year.Y23, 1, Result.PASS, marksAmi91);
        ami92.put(Subject.MATHS, 81d);
        ami92.put(Subject.PHYSICS, 85d);
        ami92.put(Subject.CHEMISTRY, 81d);
        Marks marksAmi92 = new Marks(11, ami92);
        MarksWrapper mami92 = new MarksWrapper(11, "9", 2, Year.Y23, 1, Result.PASS, marksAmi92);
        Map<Subject, Double> ami81 = new HashMap<>();
        ami81.put(Subject.MATHS, 92d);
        ami81.put(Subject.PHYSICS, 88d);
        ami81.put(Subject.CHEMISTRY, 92d);
        Marks marksAmi81 = new Marks(12, ami81);
        MarksWrapper mami81 = new MarksWrapper(13, "8", 1, Year.Y22, 1, Result.PASS, marksAmi81);
        List<MarksWrapper> amiMarksWrapper = new ArrayList<>(Arrays.asList(mami92, mami91, mami81));
        Student amit = new Student(4, "Amit", department2, "9", amiMarksWrapper);

        //Manish
        Map<Subject, Double> man91 = new HashMap<>();
        man91.put(Subject.MATHS, 92d);
        man91.put(Subject.PHYSICS, 73d);
        man91.put(Subject.CHEMISTRY, 76d);
        Marks marksMan91 = new Marks(13, man91);
        Map<Subject, Double> man92 = new HashMap<>();
        MarksWrapper mMan91 = new MarksWrapper(14, "9", 1, Year.Y23, 1, Result.PASS, marksMan91);
        man92.put(Subject.MATHS, 92d);
        man92.put(Subject.PHYSICS, 85d);
        man92.put(Subject.CHEMISTRY, 91d);
        Marks marksMan92 = new Marks(14, man92);
        MarksWrapper mMan92 = new MarksWrapper(15, "9", 2, Year.Y23, 1, Result.PASS, marksMan92);
        Map<Subject, Double> man81 = new HashMap<>();
        man81.put(Subject.MATHS, 94d);
        man81.put(Subject.PHYSICS, 84d);
        man81.put(Subject.CHEMISTRY, 91d);
        Marks marksMan81 = new Marks(15, man81);
        MarksWrapper mMan81 = new MarksWrapper(16, "8", 1, Year.Y22, 1, Result.PASS, marksMan81);
        List<MarksWrapper> manMarksWrapper = new ArrayList<>(Arrays.asList(mMan91, mMan92, mMan81));
        Student manish = new Student(5, "Manish", department1, "9", manMarksWrapper);

        //Praveen
        Map<Subject, Double> p81_2 = new HashMap<>();
        p81_2.put(Subject.MATHS, 92d);
        p81_2.put(Subject.PHYSICS, 73d);
        p81_2.put(Subject.CHEMISTRY, 76d);
        Marks marksP81_2 = new Marks(13, p81_2);
        Map<Subject, Double> p82 = new HashMap<>();
        MarksWrapper mp81_2 = new MarksWrapper(16, "8", 1, Year.Y23, 2, Result.PASS, marksP81_2);
        p82.put(Subject.MATHS, 92d);
        p82.put(Subject.PHYSICS, 85d);
        p82.put(Subject.CHEMISTRY, 91d);
        Marks marksP82 = new Marks(14, p82);
        MarksWrapper mp82 = new MarksWrapper(17, "8", 2, Year.Y23, 2, Result.PASS, marksP82);
        Map<Subject, Double> p81_1 = new HashMap<>();
        p81_1.put(Subject.MATHS, 23d);
        p81_1.put(Subject.PHYSICS, 31d);
        p81_1.put(Subject.CHEMISTRY, 2d);
        Marks marksP81_1 = new Marks(15, p81_1);
        MarksWrapper mp81_1 = new MarksWrapper(18, "8", 1, Year.Y22, 1, Result.FAIL, marksP81_1);
        List<MarksWrapper> pMarksWrapper = new ArrayList<>(Arrays.asList(mp81_1, mp81_2, mp82));
        Student praveen = new Student(6, "Praveen", department1, "8", pMarksWrapper);

        return new ArrayList<>(Arrays.asList(akash, rakesh, supreeth, amit, manish, praveen));
    }
}
