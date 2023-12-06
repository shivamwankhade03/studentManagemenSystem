package com.student.management.controller;

import com.student.management.service.CollegeService;
import com.student.management.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class CourseController {
    public static final Logger LOGGER = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    CourseService courseService;

    @GetMapping("/courses")
    public ResponseEntity getAllCourseDetails(){
        LOGGER.info("Inside getAllCourseDetails");
        return new ResponseEntity(courseService.getAllCoursesDetails(), HttpStatusCode.valueOf(200));
    }

}
