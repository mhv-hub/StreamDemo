package org.example.streamdemo.studentdemo.dto;

import org.example.streamdemo.studentdemo.entity.Student;

public class StudentDtoMapper {

    public static StudentDto mapToStudentDto(Student student){
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setStandard(student.getStandard());
        studentDto.setDepartmentName(student.getDepartment().getName());
        return studentDto;
    }
}
