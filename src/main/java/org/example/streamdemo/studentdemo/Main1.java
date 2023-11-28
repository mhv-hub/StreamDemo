

package org.example.streamdemo.studentdemo;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.example.streamdemo.studentdemo.dto.MarksSumDto;
import org.example.streamdemo.studentdemo.dto.StudentDto;
import org.example.streamdemo.studentdemo.entity.Department;
import org.example.streamdemo.studentdemo.entity.Marks;
import org.example.streamdemo.studentdemo.entity.MarksWrapper;
import org.example.streamdemo.studentdemo.entity.Result;
import org.example.streamdemo.studentdemo.entity.Student;
import org.example.streamdemo.studentdemo.entity.Subject;
import org.example.streamdemo.studentdemo.entity.Year;

public class Main1 {
    public Main1() {
    }

    public static void main(String[] args) {
        List<Student> studentList = createStudentData();
        PrintStream var10001 = System.out;
        Objects.requireNonNull(var10001);
        studentList.forEach(var10001::println);
        Year year = Year.Y23;
        Map<String, List<Student>> groupByStand = studentList.stream().collect(Collectors.groupingBy(Student::getStandard));
        Map<String, List<Student>> filterResultBasedByYear = groupByStand.entrySet().stream().map((x1) -> {
            List<Student> students = (x1.getValue()).stream().map((x) -> {
                List<MarksWrapper> studentMarks = x.getMarksWrappers().stream().filter((s1) -> {
                    return s1.getYear().equals(year);
                }).toList();
                x.setMarksWrappers(studentMarks);
                return x;
            }).filter((x2) -> {
                return x2.getMarksWrappers().size() > 0;
            }).toList();
            x1.setValue(students);
            return x1;
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        Map<String, Map<MarksSumDto, List<StudentDto>>> standardWiseMap = new HashMap<>();
        filterResultBasedByYear.entrySet().stream().map((x) -> {
            List<Student> resultStudent = x.getValue();
            Map<Department, List<Student>> groupingByDept = resultStudent.stream().collect(Collectors.groupingBy(Student::getDepartment));
            Map<MarksSumDto, List<StudentDto>> map1 = new HashMap<>();
            groupingByDept.entrySet().stream().map((z) -> {
                List<Student> students = z.getValue();
                Integer maxSession1 = (Integer)students.stream().map((x1) -> {
                    List<MarksWrapper> marksWrappers = x1.getMarksWrappers();
                    Integer maxSession = (Integer)marksWrappers.stream().map((x2) -> {
                        return x2.getSession();
                    }).max(Integer::compareTo).get();
                    return maxSession;
                }).max(Integer::compareTo).get();
                MarksSumDto marksSumDto = new MarksSumDto();
                marksSumDto.setDepartment((Department)z.getKey());
                List<Student> studentList1 = z.getValue();
                List<Map<Subject, Double>> marksList = studentList1.stream().map((p1) -> {
                    List<MarksWrapper> marksWrappers = p1.getMarksWrappers();
                    Map<Subject, Double> enumMap = new EnumMap<>(Subject.class);
                    marksWrappers.stream().map((p2) -> {
                        p2.getMarks().getMarksMap().entrySet().stream().map((p3) -> {
                            enumMap.merge((Subject)p3.getKey(), (Double)p3.getValue(), Double::sum);
                            return p3;
                        }).toList();
                        return p2;
                    }).collect(Collectors.toList());
                    Map<Subject, Double> avgMarkByStudent = enumMap.entrySet().stream().map((a) -> {
                        a.setValue((Double)a.getValue() / (double)maxSession1);
                        return a;
                    }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                    return avgMarkByStudent;
                }).toList();
                Map<Subject, Double> sumMarksList = new EnumMap<>(Subject.class);
                marksList.stream().map((xp) -> {
                    xp.entrySet().stream().map((xp1) -> {
                        sumMarksList.merge((Subject)xp1.getKey(), (Double)xp1.getValue(), Double::sum);
                        return xp1;
                    }).collect(Collectors.toList());
                    return xp;
                }).collect(Collectors.toList());
                Map<Subject, Double> avgMarkByDept = sumMarksList.entrySet().stream().map((xp3) -> {
                    xp3.setValue((Double)xp3.getValue() / (double)marksList.size());
                    return xp3;
                }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                marksSumDto.setAvgMarksMap(avgMarkByDept);
                List<StudentDto> studentDtoList = studentList1.stream().map((xs) -> {
                    return new StudentDto(xs.getId(), xs.getName(), xs.getStandard(), xs.getDepartment().getName());
                }).toList();
                map1.put(marksSumDto, studentDtoList);
                return z;
            }).collect(Collectors.toList());
            standardWiseMap.put((String)x.getKey(), map1);
            return (String)x.getKey();
        }).toList();
        System.out.println("====================Final Result===============");
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

    public static List<Student> createStudentData() {
        Department department1 = new Department(1L, "CSE");
        Department department2 = new Department(2L, "CIV");
        Map<Subject, Double> a91 = new HashMap<>();
        a91.put(Subject.MATHS, 92.0);
        a91.put(Subject.PHYSICS, 85.0);
        a91.put(Subject.CHEMISTRY, 91.0);
        Marks marksA91 = new Marks(1, a91);
        MarksWrapper am91 = new MarksWrapper(1L, "9", 1, Year.Y23, 1, Result.PASS, marksA91);
        Map<Subject, Double> a92 = new HashMap<>();
        a92.put(Subject.MATHS, 91.0);
        a92.put(Subject.PHYSICS, 80.0);
        a92.put(Subject.CHEMISTRY, 81.0);
        Marks marksA92 = new Marks(2, a92);
        MarksWrapper am92 = new MarksWrapper(2L, "9", 2, Year.Y23, 1, Result.PASS, marksA92);
        Map<Subject, Double> a81 = new HashMap<>();
        a81.put(Subject.MATHS, 73.0);
        a81.put(Subject.PHYSICS, 88.0);
        a81.put(Subject.CHEMISTRY, 98.0);
        Marks marksA81 = new Marks(3, a81);
        MarksWrapper am81 = new MarksWrapper(3L, "8", 1, Year.Y22, 1, Result.PASS, marksA81);
        List<MarksWrapper> akashMarksWrapper = new ArrayList<>(Arrays.asList(am92, am91, am81));
        Student akash = new Student(1L, "Akash", department1, "9", akashMarksWrapper);
        Map<Subject, Double> r91 = new HashMap<>();
        r91.put(Subject.MATHS, 88.0);
        r91.put(Subject.PHYSICS, 84.0);
        r91.put(Subject.CHEMISTRY, 81.0);
        Marks marksR91 = new Marks(4, r91);
        Map<Subject, Double> r92 = new HashMap<>();
        MarksWrapper ar91 = new MarksWrapper(4L, "9", 1, Year.Y23, 1, Result.PASS, marksR91);
        r92.put(Subject.MATHS, 78.0);
        a92.put(Subject.PHYSICS, 76.0);
        a92.put(Subject.CHEMISTRY, 70.0);
        Marks marksR92 = new Marks(5, r92);
        MarksWrapper ar92 = new MarksWrapper(5L, "9", 2, Year.Y23, 1, Result.PASS, marksR92);
        Map<Subject, Double> r81 = new HashMap<>();
        r81.put(Subject.MATHS, 89.0);
        r81.put(Subject.PHYSICS, 80.0);
        r81.put(Subject.CHEMISTRY, 93.0);
        Marks marksR81 = new Marks(6, r81);
        MarksWrapper ar81 = new MarksWrapper(6L, "8", 1, Year.Y22, 1, Result.PASS, marksR81);
        List<MarksWrapper> rMarksWrapper = new ArrayList<>(Arrays.asList(ar92, ar91, ar81));
        Student rakesh = new Student(2L, "Rakesh", department2, "9", rMarksWrapper);
        Map<Subject, Double> s91 = new HashMap<>();
        s91.put(Subject.MATHS, 56.0);
        s91.put(Subject.PHYSICS, 67.0);
        s91.put(Subject.CHEMISTRY, 45.0);
        Marks marksS91 = new Marks(7, s91);
        Map<Subject, Double> s92 = new HashMap<>();
        MarksWrapper as91 = new MarksWrapper(7L, "9", 1, Year.Y23, 1, Result.PASS, marksS91);
        s92.put(Subject.MATHS, 91.0);
        s92.put(Subject.PHYSICS, 98.0);
        s92.put(Subject.CHEMISTRY, 94.0);
        Marks marksS92 = new Marks(8, s92);
        MarksWrapper as92 = new MarksWrapper(8L, "9", 2, Year.Y23, 1, Result.PASS, marksS92);
        Map<Subject, Double> s81 = new HashMap<>();
        s81.put(Subject.MATHS, 99.0);
        s81.put(Subject.PHYSICS, 89.0);
        s81.put(Subject.CHEMISTRY, 92.0);
        Marks marksS81 = new Marks(9, s81);
        MarksWrapper as81 = new MarksWrapper(9L, "8", 1, Year.Y22, 1, Result.PASS, marksS81);
        List<MarksWrapper> sMarksWrapper = new ArrayList<>(Arrays.asList(as92, as91, as81));
        Student supreeth = new Student(3L, "Supreeth", department1, "9", sMarksWrapper);
        Map<Subject, Double> ami91 = new HashMap<>();
        ami91.put(Subject.MATHS, 94.0);
        ami91.put(Subject.PHYSICS, 99.0);
        ami91.put(Subject.CHEMISTRY, 92.0);
        Marks marksAmi91 = new Marks(10, ami91);
        MarksWrapper mami91 = new MarksWrapper(10L, "9", 1, Year.Y23, 1, Result.PASS, marksAmi91);
        Map<Subject, Double> ami92 = new HashMap<>();
        ami92.put(Subject.MATHS, 81.0);
        ami92.put(Subject.PHYSICS, 85.0);
        ami92.put(Subject.CHEMISTRY, 81.0);
        Marks marksAmi92 = new Marks(11, ami92);
        MarksWrapper mami92 = new MarksWrapper(11L, "9", 2, Year.Y23, 1, Result.PASS, marksAmi92);
        Map<Subject, Double> ami81 = new HashMap<>();
        ami81.put(Subject.MATHS, 92.0);
        ami81.put(Subject.PHYSICS, 88.0);
        ami81.put(Subject.CHEMISTRY, 92.0);
        Marks marksAmi81 = new Marks(12, ami81);
        MarksWrapper mami81 = new MarksWrapper(13L, "8", 1, Year.Y22, 1, Result.PASS, marksAmi81);
        List<MarksWrapper> amiMarksWrapper = new ArrayList<>(Arrays.asList(mami92, mami91, mami81));
        Student amit = new Student(4L, "Amit", department2, "9", amiMarksWrapper);
        Map<Subject, Double> man91 = new HashMap<>();
        man91.put(Subject.MATHS, 92.0);
        man91.put(Subject.PHYSICS, 73.0);
        man91.put(Subject.CHEMISTRY, 76.0);
        Marks marksMan91 = new Marks(13, man91);
        MarksWrapper mMan91 = new MarksWrapper(14L, "9", 1, Year.Y23, 1, Result.PASS, marksMan91);
        Map<Subject, Double> man92 = new HashMap<>();
        man92.put(Subject.MATHS, 92.0);
        man92.put(Subject.PHYSICS, 85.0);
        man92.put(Subject.CHEMISTRY, 91.0);
        Marks marksMan92 = new Marks(14, man92);
        MarksWrapper mMan92 = new MarksWrapper(15L, "9", 2, Year.Y23, 1, Result.PASS, marksMan92);
        Map<Subject, Double> man81 = new HashMap<>();
        man81.put(Subject.MATHS, 94.0);
        man81.put(Subject.PHYSICS, 84.0);
        man81.put(Subject.CHEMISTRY, 91.0);
        Marks marksMan81 = new Marks(15, man81);
        MarksWrapper mMan81 = new MarksWrapper(16L, "8", 1, Year.Y22, 1, Result.PASS, marksMan81);
        List<MarksWrapper> manMarksWrapper = new ArrayList<>(Arrays.asList(mMan91, mMan92, mMan81));
        Student manish = new Student(5L, "Manish", department1, "9", manMarksWrapper);
        Map<Subject, Double> p81_2 = new HashMap<>();
        p81_2.put(Subject.MATHS, 92.0);
        p81_2.put(Subject.PHYSICS, 73.0);
        p81_2.put(Subject.CHEMISTRY, 76.0);
        Marks marksP81_2 = new Marks(13, p81_2);
        MarksWrapper mp81_2 = new MarksWrapper(16L, "8", 1, Year.Y23, 2, Result.PASS, marksP81_2);
        Map<Subject, Double> p82 = new HashMap<>();
        p82.put(Subject.MATHS, 92.0);
        p82.put(Subject.PHYSICS, 85.0);
        p82.put(Subject.CHEMISTRY, 91.0);
        Marks marksP82 = new Marks(14, p82);
        MarksWrapper mp82 = new MarksWrapper(17L, "8", 2, Year.Y23, 2, Result.PASS, marksP82);
        Map<Subject, Double> p81_1 = new HashMap<>();
        p81_1.put(Subject.MATHS, 23.0);
        p81_1.put(Subject.PHYSICS, 31.0);
        p81_1.put(Subject.CHEMISTRY, 2.0);
        Marks marksP81_1 = new Marks(15, p81_1);
        MarksWrapper mp81_1 = new MarksWrapper(18L, "8", 1, Year.Y22, 1, Result.FAIL, marksP81_1);
        List<MarksWrapper> pMarksWrapper = new ArrayList<>(Arrays.asList(mp81_1, mp81_2, mp82));
        Student praveen = new Student(6L, "Praveen", department1, "8", pMarksWrapper);
        return new ArrayList<>(Arrays.asList(akash, rakesh, supreeth, amit, manish, praveen));
    }
}