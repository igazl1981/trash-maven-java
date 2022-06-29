package com.example.trash.maven.java.dao.model;


import java.io.Serializable;
import java.util.StringJoiner;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class StudentSchoolId implements Serializable {

    @Column(name = "student_id")
    private UUID studentId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "school_id")
    private School school;

    public StudentSchoolId() {
    }

    public StudentSchoolId(School school, UUID studentId) {
        this.school = school;
        this.studentId = studentId;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School schoolId) {
        this.school = schoolId;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StudentSchoolId.class.getSimpleName() + "[", "]")
                .add("schoolId=" + school)
                .add("studentId=" + studentId)
                .toString();
    }

    public UUID getStudentId() {
        return studentId;
    }

    public void setStudentId(UUID studentId) {
        this.studentId = studentId;
    }
}
