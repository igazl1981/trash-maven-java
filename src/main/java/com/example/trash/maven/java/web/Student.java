package com.example.trash.maven.java.web;

import java.util.UUID;

import com.example.trash.maven.java.dao.model.School;
import com.example.trash.maven.java.dao.model.StudentSchoolId;

public record Student(Integer schoolId, UUID studentId, String firstname, String lastname, String address) {

    public static Student fromEntity(com.example.trash.maven.java.dao.model.Student student) {
        return new Student(student.getId().getSchool().getId(), student.getId().getStudentId(), student.getFirstname(), student.getLastname(), student.getAddress());
    }

    public com.example.trash.maven.java.dao.model.Student toEntity(School school) {
        return new com.example.trash.maven.java.dao.model.Student(new StudentSchoolId(school, studentId), firstname, lastname, address);
    }
}
