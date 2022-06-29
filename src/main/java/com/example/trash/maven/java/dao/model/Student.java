package com.example.trash.maven.java.dao.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "students")
@IdClass(StudentSchoolId.class)
public class Student {

    @Id
    @Column(name = "school_id", nullable = false)
    private Integer schoolId;

    @Id
    @Column(name = "student_id", nullable = false)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID studentId;

    private String firstname;

    private String lastname;

    private String address;

    public Student() {}

    public Student(Integer schoolId, UUID studentId, String firstname, String lastname, String address) {
        this.schoolId = schoolId;
        this.studentId = studentId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public void setStudentId(UUID studentId) {
        this.studentId = studentId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
