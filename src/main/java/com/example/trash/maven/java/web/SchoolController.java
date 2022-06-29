package com.example.trash.maven.java.web;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

import com.example.trash.maven.java.dao.SchoolRepository;
import com.example.trash.maven.java.dao.StudentRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/schools")
public class SchoolController {

    private final SchoolRepository schoolRepository;
    private final StudentRepository studentRepository;

    public SchoolController(SchoolRepository schoolRepository, StudentRepository studentRepository) {
        this.schoolRepository = schoolRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/{id}")
    public School get(@PathVariable Integer id) {
        return schoolRepository.findById(id)
                .map(School::fromEntity)
                .orElseThrow();
    }

    @GetMapping("/{id}/generate")
    public School generate(@PathVariable Integer id) {
        var school = schoolRepository.findById(id).orElseThrow();
        var students = new ArrayList<Student>();
        for (int i = 0; i < getRandomAmount(); i++) {
            students.add(
                    new Student(school.getId(), UUID.randomUUID(), "Firstname " + i, "Lastname " + i, "Address " + i)
            );
        }
        school.getStudents().addAll(students.stream().map(Student::toEntity).toList());
        schoolRepository.save(school);
        return School.fromEntity(school);
    }

    @DeleteMapping("/{id}/students/first")
    public School deleteFirstStudent(@PathVariable Integer id) {
        var school = schoolRepository.findById(id).orElseThrow();
        var firstStudent = school.getStudents().stream().findFirst().orElseThrow();
        studentRepository.delete(firstStudent);
        return School.fromEntity(school);
    }

    private int getRandomAmount() {
        return 1 + new Random().nextInt(10);
    }
}
