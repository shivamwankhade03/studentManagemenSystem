package com.student.management.service;

import com.student.management.entity.Student;
import com.student.management.modal.StudentDTO;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudentDetails();
    Student getStudentById(String id);

    Student getStudentByColgId(String id);


}
