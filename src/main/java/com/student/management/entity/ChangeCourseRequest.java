package com.student.management.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ChangeCourseRequest {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int requestId;
    private String courseType;
    private String courseYear;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_fk_id",referencedColumnName = "studentId")
    private Student student;


}
