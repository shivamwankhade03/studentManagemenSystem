package com.student.management.controller;

import com.student.management.service.CollegeService;
import com.student.management.service.StudentService;
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
public class CollegeController {
    public static final Logger LOGGER = LoggerFactory.getLogger(CollegeController.class);

    @Autowired
    CollegeService collegeService;

    @GetMapping("/colleges")
    public ResponseEntity getAllCollegeListWithDetails(){
        LOGGER.info("Inside getALLCollegeDetailList");
        return new ResponseEntity(collegeService.getALLCollegeDetailList(), HttpStatusCode.valueOf(200));
    }

}
