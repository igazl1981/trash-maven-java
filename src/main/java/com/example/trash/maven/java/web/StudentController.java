package com.example.trash.maven.java.web;

import java.util.List;

import com.example.trash.maven.java.dao.StudentRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/students")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    List<Student> getAll() {
        return studentRepository.findAll()
                .stream()
                .map(Student::fromEntity)
                .toList();
    }

}
