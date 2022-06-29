package com.example.trash.maven.java.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

import com.example.trash.maven.java.dao.SchoolRepository;
import com.example.trash.maven.java.dao.StudentRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
        List<Student> students = getRandomAmountGeneratedStudents(school);
        school.getStudents().addAll(students.stream().map(student -> student.toEntity(school)).toList());
        schoolRepository.save(school);
        return School.fromEntity(school);
    }

    @DeleteMapping("/{id}/students/first")
    public School deleteFirstStudent(@PathVariable Integer id) {
        var school = schoolRepository.findById(id).orElseThrow();
        var firstStudent = school.getStudents().stream().findFirst().orElseThrow();
        school.getStudents().remove(firstStudent);
        studentRepository.delete(firstStudent);
        return School.fromEntity(school);
    }

    @DeleteMapping("/{id}/students/all")
    public School deleteAllStudent(@PathVariable Integer id) {
        var school = schoolRepository.findById(id).orElseThrow();
        var allStudents = school.getStudents();
        school.setStudents(List.of());
        studentRepository.deleteAll(allStudents);
        return School.fromEntity(school);
    }

    @PutMapping("/{id}/students/all")
    public School replaceAllStudent(@PathVariable Integer id) {
        var school = schoolRepository.findById(id).orElseThrow();
        var allStudents = school.getStudents();
        var newStudents = getRandomAmountGeneratedStudents(school)
                .stream()
                .map(student -> student.toEntity(school))
                .collect(Collectors.toList());
        school.setStudents(newStudents);
        studentRepository.deleteAll(allStudents);
        return School.fromEntity(school);
    }

    private List<Student> getRandomAmountGeneratedStudents(com.example.trash.maven.java.dao.model.School school) {
        var students = new ArrayList<Student>();
        for (int i = 0; i < getRandomAmount(); i++) {
            students.add(
                    new Student(school.getId(), UUID.randomUUID(), "Firstname " + i, "Lastname " + i, "Address " + i)
            );
        }
        return students;
    }

    private int getRandomAmount() {
        return 1 + new Random().nextInt(10);
    }
}
