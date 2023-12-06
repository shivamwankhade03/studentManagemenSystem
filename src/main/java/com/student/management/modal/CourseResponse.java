package com.student.management.modal;

import com.student.management.entity.Course;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CourseResponse {

    private List<Course> it;
    private List<Course> cse;
    private List<Course> me;
    private List<Course> ece;

}
