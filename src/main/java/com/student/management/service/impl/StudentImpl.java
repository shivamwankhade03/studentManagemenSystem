package com.student.management.service.impl;

import com.student.management.controller.StudentController;
import com.student.management.entity.College;
import com.student.management.entity.Course;
import com.student.management.entity.Student;
import com.student.management.exception.StudentNotFoundException;
import com.student.management.modal.StudentDTO;
import com.student.management.modal.StudentDetailResponse;
import com.student.management.modal.StudentRequest;
import com.student.management.repository.CollegeRepository;
import com.student.management.repository.CourseRepository;
import com.student.management.repository.StudentRepository;
import com.student.management.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentImpl implements StudentService {

    public static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CollegeRepository collegeRepository;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public List<StudentDetailResponse> getAllStudentDetails() {
        Optional<List<Student>> studentList = Optional.ofNullable(studentRepository.findAll());
        if(!studentList.isEmpty()){
            List<Student> sList = studentList.get();
            LOGGER.info(studentList.get().get(0).getCollege().getCollegeId()+"");
            LOGGER.info(studentList.get().get(0).getCollege().getCollegeName()+"");


            List<StudentDetailResponse> responseList = new ArrayList<>();
            sList.forEach(c -> {
                StudentDetailResponse response = new StudentDetailResponse();
                response.setStudentId(c.getStudentId());
                response.setFirstName(c.getFirstName());
                response.setLastName(c.getLastName());
                response.setCredits(c.getCredits());
                response.setCourse(c.getCourseType());
                response.setEnrollStatus(c.getEnrollStatus());
                response.setCollegeId(c.getCollege().getCollegeId());
                response.setCollegeName(c.getCollege().getCollegeName());
                response.setCollegeType(c.getCollege().getCollegeType());
                response.setCourseType(c.getCourse().getCourseType());
                response.setCourseYear(c.getCourse().getCourseYear());
                responseList.add(response);
            });
            return responseList;
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

    @Override
    public Student saveStudentByColgId(int collegeId ,Student studentRequest) {

       Student student  = collegeRepository.findById(collegeId).map(college1 -> {
           Course course = courseRepository.findByCourseYearAndCourseType(studentRequest.getCourseYear(),studentRequest.getCourseType());
           studentRequest.setCourse(course);
           studentRequest.setCollege(college1);
          return studentRepository.save(studentRequest);
       }).orElseThrow(() -> new StudentNotFoundException("Not found"));
        return student;
    }

    @Override
    public List<StudentDetailResponse> getEnrollmentRequest() {
        Optional<List<Student>> studentList = Optional.ofNullable(studentRepository.findEnrollmentRequestsRequested());
        if(!studentList.isEmpty()){
            List<Student> sList = studentList.get();
            List<StudentDetailResponse> responseList = new ArrayList<>();
            sList.forEach(c -> {
                StudentDetailResponse response = new StudentDetailResponse();
                response.setStudentId(c.getStudentId());
                response.setFirstName(c.getFirstName());
                response.setLastName(c.getLastName());
                response.setCredits(c.getCredits());
                response.setCourse(c.getCourseType());
                response.setEnrollStatus(c.getEnrollStatus());
                response.setCollegeId(c.getCollege().getCollegeId());
                response.setCollegeName(c.getCollege().getCollegeName());
                response.setCollegeType(c.getCollege().getCollegeType());
                response.setCourseType(c.getCourse().getCourseType());
                response.setCourseYear(c.getCourse().getCourseYear());
                responseList.add(response);
            });
            return responseList;
        }
        throw new StudentNotFoundException("Student Not found");

    }

    @Override
    public Student updateEnrollmentRequest(Student studentRequest) {

        if(studentRequest!=null) {
            return studentRepository.save(studentRequest);
        }

        throw new StudentNotFoundException("Student Not found");
    }


}
