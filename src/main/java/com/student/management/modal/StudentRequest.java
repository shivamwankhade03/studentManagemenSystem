package com.student.management.modal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequest {

    private String collegeId;
    private String courseType;
    private int courseYear;
    private int credits;
    private String firstName;
    private String lastName;
    private String password;
}
