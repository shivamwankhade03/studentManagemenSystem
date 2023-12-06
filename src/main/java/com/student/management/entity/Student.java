package com.student.management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    @UuidGenerator
    private String studentId;
    private String firstName;
    private String lastName;
    private String password;
    private String courseType;
    private String courseYear;
    private int credits;
    private String enrollStatus;


    @JsonIgnore //added bcz of this error "after the response has been committed?"
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn( name = "college_fk_id")
    private College college;

    @ManyToOne
    @JoinColumn( name = "course_fk_id")
    private Course course;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "student",fetch = FetchType.LAZY)
    private ChangeCourseRequest changeCourseRequest;

}
