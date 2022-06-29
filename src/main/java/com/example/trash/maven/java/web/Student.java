package com.example.trash.maven.java.web;

import java.util.UUID;

import com.example.trash.maven.java.dao.model.School;

public record Student(Integer schoolId, UUID studentId, String firstname, String lastname, String address) {

    public static Student fromEntity(com.example.trash.maven.java.dao.model.Student student) {
        return new Student(student.getSchoolId(), student.getStudentId(), student.getFirstname(), student.getLastname(), student.getAddress());
    }

    public com.example.trash.maven.java.dao.model.Student toEntity() {
        return new com.example.trash.maven.java.dao.model.Student(schoolId, studentId, firstname, lastname, address);
    }
}
