package com.example.trash.maven.java.dao;

import com.example.trash.maven.java.dao.model.Student;
import com.example.trash.maven.java.dao.model.StudentSchoolId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, StudentSchoolId> {
}
