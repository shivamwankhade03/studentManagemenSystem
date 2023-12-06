package com.student.management.modal;

import com.student.management.entity.College;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDetailResponse {
    private String studentId;
    private String firstName;
    private String lastName;
    private String password;
    private String course;
    private int credits;
    private int collegeId;
    private String collegeName;
    private String collegeType;
    private String courseType;
    private String courseYear;
    private String enrollStatus;
}
