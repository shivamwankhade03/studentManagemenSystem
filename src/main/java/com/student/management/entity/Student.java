package com.student.management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String studentId;
    private String firstName;
    private String lastName;
    private String password;
    private String course;
    private int credits;


    @JsonIgnore //added bcz of this error "after the response has been committed?"
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn( name = "college_fk_id")
    private College college;


}
