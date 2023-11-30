package com.student.management.service.impl;

import com.student.management.entity.College;
import com.student.management.entity.Student;
import com.student.management.exception.StudentNotFoundException;
import com.student.management.repository.CollegeRepository;
import com.student.management.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CollegeImpl implements CollegeService {

    @Autowired
    CollegeRepository collegeRepository;

    @Override
    public List<College> getALLCollegeDetailList() {
        Optional<List<College>> collegeList = Optional.ofNullable(collegeRepository.findAll());
        if(!collegeList.isEmpty()){
            return collegeList.get();
        }
        throw new StudentNotFoundException("College Not found");
    }
}
