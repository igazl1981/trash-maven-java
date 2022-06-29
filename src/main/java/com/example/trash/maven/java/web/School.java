package com.example.trash.maven.java.web;

import java.util.List;

public record School(Integer id, String name, String address, List<Student> students) {
    public static School fromEntity(com.example.trash.maven.java.dao.model.School school) {
        return new School(school.getId(), school.getName(), school.getAddress(), convertStudents(school.getStudents()));
    }

    private static List<Student> convertStudents(List<com.example.trash.maven.java.dao.model.Student> students) {
        if (students == null) {
            return null;
        }
        return students.stream().map(Student::fromEntity).toList();
    }
}
