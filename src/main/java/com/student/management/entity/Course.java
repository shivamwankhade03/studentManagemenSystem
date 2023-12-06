package com.student.management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int couseId;
    private String courseType;
    private String courseYear;
    private int availableSeats;

//    @OneToMany(fetch = FetchType.LAZY,mappedBy = "course",cascade = CascadeType.ALL)
//    private List<Student> StudentList = new ArrayList<>();
}
