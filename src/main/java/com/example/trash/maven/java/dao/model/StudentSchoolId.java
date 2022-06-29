package com.example.trash.maven.java.dao.model;


import java.io.Serializable;
import java.util.StringJoiner;
import java.util.UUID;

import javax.persistence.Column;

public class StudentSchoolId implements Serializable {

    @Column(name = "school_id")
    private Integer schoolId;

    @Column(name = "student_id")
    private UUID studentId;

    public StudentSchoolId() {
    }

    public StudentSchoolId(Integer schoolId, UUID studentId) {
        this.schoolId = schoolId;
        this.studentId = studentId;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StudentSchoolId.class.getSimpleName() + "[", "]")
                .add("schoolId=" + schoolId)
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
