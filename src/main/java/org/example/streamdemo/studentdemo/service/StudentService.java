package org.example.streamdemo.studentdemo.service;

import org.example.streamdemo.studentdemo.dto.MarksSumDto;
import org.example.streamdemo.studentdemo.dto.StudentDto;
import org.example.streamdemo.studentdemo.dto.StudentDtoMapper;
import org.example.streamdemo.studentdemo.entity.*;

import java.util.*;
import java.util.stream.Collectors;

public class StudentService {

    public Map<String, Map<MarksSumDto, List<StudentDto>>> getStandardAndDepartmentWiseMarksMap(List<Student> studentList, Year year){

        Map<String, Map<MarksSumDto, List<StudentDto>>> result = new HashMap<>();
        List<Standard> standards = Arrays.asList(Standard.values());
        standards.forEach(standard -> {
            String std = standard.getDigitValue();
            Map<MarksSumDto, List<StudentDto>> mappedResult =  getDepartmentWiseTotalMarksMap(studentList, std, year);
            if (mappedResult.size() > 0) {
                result.put(std, mappedResult);
            }
        });
        return result;
    }

    public Map<MarksSumDto, List<StudentDto>> getDepartmentWiseTotalMarksMap(List<Student> studentList, String standard, Year year){

        Map<MarksSumDto, List<StudentDto>> result = new HashMap<>();

        Map<Department, List<Student>> departmentMap = studentList.stream()
                .filter(student -> standard.equals(student.getStandard()))
                .collect(Collectors.groupingBy(Student::getDepartment));

        departmentMap.forEach((department, students) -> {
            Map<Subject, Double> totalMarksMap = new EnumMap<>(Subject.class);
            List<MarksWrapper> filteredWrappers = students.stream()
                    .flatMap(student -> student.getMarksWrappers().stream())
                    .filter(marksWrapper -> standard.equals(marksWrapper.getStandard()))
                    .filter(marksWrapper -> year.equals(marksWrapper.getYear()))
                    .toList();
            filteredWrappers.forEach(marksWrapper -> {
                        marksWrapper.getMarks().getMarksMap().forEach(((subject, marks) -> {
                            totalMarksMap.merge(subject, marks, Double::sum);
                        }));
                    });
            if (filteredWrappers.size() > 0) {
                totalMarksMap.forEach(((subject, marks) -> totalMarksMap.put(subject, marks / filteredWrappers.size())));
                MarksSumDto marksSumDto = new MarksSumDto();
                marksSumDto.setDepartment(department);
                marksSumDto.setAvgMarksMap(totalMarksMap);
                List<StudentDto> studentDtoList = students.stream().map(StudentDtoMapper::mapToStudentDto).toList();
                result.put(marksSumDto, studentDtoList);
            }
        });
        return result;
    }
}
