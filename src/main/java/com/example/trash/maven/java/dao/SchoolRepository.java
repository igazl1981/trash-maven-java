package com.example.trash.maven.java.dao;

import com.example.trash.maven.java.dao.model.School;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}
