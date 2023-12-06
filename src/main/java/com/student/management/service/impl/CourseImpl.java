package com.student.management.service.impl;

import com.student.management.entity.Course;
import com.student.management.modal.CourseResponse;
import com.student.management.repository.CourseRepository;
import com.student.management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public CourseResponse getAllCoursesDetails() {

        List<Course> response = courseRepository.findByOrderByCourseTypeAsc();

        CourseResponse courseList = new CourseResponse();
        List<Course> itList = new ArrayList<>();
        List<Course> csList = new ArrayList<>();
        List<Course> eceList = new ArrayList<>();
        List<Course> meList = new ArrayList<>();

        for (int i=0;i<response.size();i++){
            if(response.get(i).getCourseType().equalsIgnoreCase("IT") ){
                itList.add(response.get(i));
            }
            if(response.get(i).getCourseType().equalsIgnoreCase("CSE") ){
                csList.add(response.get(i));
            }
            if(response.get(i).getCourseType().equalsIgnoreCase("ECE") ){
                eceList.add(response.get(i));
            }
            if(response.get(i).getCourseType().equalsIgnoreCase("ME") ){
                meList.add(response.get(i));
            }
        }
        courseList.setIt(itList);
        courseList.setCse(csList);
        courseList.setMe(meList);
        courseList.setEce(eceList);

        return courseList;
    }
}
