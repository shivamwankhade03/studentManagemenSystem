package com.student.management.controller;

import com.student.management.entity.Student;
import com.student.management.modal.StudentRequest;
import com.student.management.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class StudentController {

    public static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity getAllStudentListWithDetails(){
        LOGGER.info("Inside getAllStudentListWithDetails");
//       return studentService.getAllStudentDetails();
        return new ResponseEntity(studentService.getAllStudentDetails(), HttpStatusCode.valueOf(200));
    }


    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id")String id){

        return new ResponseEntity(studentService.getStudentById(id),HttpStatusCode.valueOf(200));
    }

    @GetMapping("/students/{colgid}")
    public ResponseEntity<Student> getStudentByColgId(@PathVariable("colgid")String id){

        return new ResponseEntity(studentService.getStudentByColgId(id),HttpStatusCode.valueOf(200));
    }

    @PostMapping("/register-student/{colgId}")
    public ResponseEntity<Student> saveStudentByColgId(@PathVariable("colgId")int id,@RequestBody Student
                                                       studentRequest){

        return new ResponseEntity(studentService.saveStudentByColgId(id,studentRequest),HttpStatusCode.valueOf(200));
    }

    @GetMapping("/enrollmentRequests")
    public ResponseEntity<Student> getEnrollmentRequest(){

        return new ResponseEntity(studentService.getEnrollmentRequest(),HttpStatusCode.valueOf(200));
    }

    @PutMapping("/updateenrollmentRequests")
    public ResponseEntity<Student> updateEnrollmentRequest(@RequestBody Student studentRequest){

        return new ResponseEntity(studentService.updateEnrollmentRequest(studentRequest),HttpStatusCode.valueOf(200));
    }

}
