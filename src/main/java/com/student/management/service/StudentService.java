package com.student.management.service;

import com.student.management.entity.Student;
import com.student.management.modal.StudentDTO;
import com.student.management.modal.StudentDetailResponse;
import com.student.management.modal.StudentRequest;

import java.util.List;

public interface StudentService {

    List<StudentDetailResponse> getAllStudentDetails();
    Student getStudentById(String id);

    Student getStudentByColgId(String id);

    Student saveStudentByColgId(int collegeId,Student studentRequest);

    List<StudentDetailResponse> getEnrollmentRequest();

    Student updateEnrollmentRequest(Student studentRequest);
}
