package com.example.personalaccount.controller;

import com.example.personalaccount.repository.CoursesRepository;
import com.example.personalaccount.repository.SpecialityRepository;
import com.example.personalaccount.repository.UserRepository;
import com.example.personalaccount.repository.UserSpecialCourseRepository;
import com.example.personalaccount.table.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/uscc")
public class UserSpecialCoursesController {
    @Autowired
    UserSpecialCourseRepository userSpecialCourseRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SpecialityRepository specialityRepository;

    @Autowired
    CoursesRepository coursesRepository;


    public UserSpecialCoursesController(UserSpecialCourseRepository userSpecialCourseRepository, UserRepository userRepository, SpecialityRepository specialityRepository, CoursesRepository coursesRepository) {
        this.userSpecialCourseRepository = userSpecialCourseRepository;
        this.userRepository = userRepository;
        this.specialityRepository = specialityRepository;
        this.coursesRepository = coursesRepository;
    }

    @PostMapping("/create/{userId}/{specialId}/{courseId}")
    public UserSpecialCourse findEntity(@PathVariable Long userId, @PathVariable Long specialId, @PathVariable Long courseId ){
        UserSpecialCourse userSpecialCourse=vale(userId,specialId,courseId);
        return userSpecialCourseRepository.save(userSpecialCourse);
    }

    @DeleteMapping("/delete/{userId}/{roleId}/{depId}")
    public void delete(@PathVariable Long userId, @PathVariable Long specialId, @PathVariable Long courseId){
        UserSpecialCourse userSpecialCourse=vale(userId,specialId,courseId);;
        userSpecialCourseRepository.delete(userSpecialCourse);
    }

    private UserSpecialCourse vale(Long userId, Long specialId, Long courseId){
        UserSpecialCourse userSpecialCourse = new UserSpecialCourse();
        UserLK userLK=userRepository.findByUserId(userId);
        SpecialityLK specialityLK=specialityRepository.findBySpecialityId(specialId);
        CourcesLK courcesLK=coursesRepository.findByCourcesId(courseId);
        userSpecialCourse.setUserSLK(userLK);
        userSpecialCourse.setSpecialityLK(specialityLK);
        userSpecialCourse.setCourcesSLK(courcesLK);
        return userSpecialCourse;
    }


}
