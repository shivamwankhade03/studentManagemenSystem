package com.student.management.service.impl;

import com.student.management.controller.StudentController;
import com.student.management.entity.Student;
import com.student.management.exception.StudentNotFoundException;
import com.student.management.modal.StudentDTO;
import com.student.management.repository.StudentRepository;
import com.student.management.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentImpl implements StudentService {

    public static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudentDetails() {
        Optional<List<Student>> studentList = Optional.ofNullable(studentRepository.findAll());
        if(!studentList.isEmpty()){
            LOGGER.info(studentList.get().get(0).getCollege().getCollegeId()+"");
            LOGGER.info(studentList.get().get(0).getCollege().getCollegeName()+"");
            LOGGER.info(studentList.get().get(0).toString()+"");
            return studentList.get();
        }
        throw new StudentNotFoundException("Student Not found");

    }

    @Override
    public Student getStudentById(String id) {
        Optional<Student> st = studentRepository.findById(id);
        if(st.isEmpty()){
            throw new StudentNotFoundException("No record found");
        }
        LOGGER.info("Studnet ",st.get());
        return st.get();
    }

    @Override
    public Student getStudentByColgId(String id) {


        return null;
    }
}
