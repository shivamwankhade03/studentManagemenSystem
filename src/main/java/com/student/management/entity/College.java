package com.student.management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int collegeId;
    private String collegeName;
    private String collegeType;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "college",cascade = CascadeType.ALL)
    private List<Student> Students = new ArrayList<>();


}
