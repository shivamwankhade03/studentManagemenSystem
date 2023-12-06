package com.student.management.repository;

import com.student.management.entity.Course;
import com.student.management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {

    @Query(nativeQuery = true, value = "SELECT * FROM Student where enroll_status = 'requested'")
    List<Student> findEnrollmentRequestsRequested();
}
