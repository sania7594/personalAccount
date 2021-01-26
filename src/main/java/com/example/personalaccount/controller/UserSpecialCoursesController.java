package com.example.personalaccount.controller;

import com.example.personalaccount.repository.CoursesRepository;
import com.example.personalaccount.repository.SpecialityRepository;
import com.example.personalaccount.repository.UserRepository;
import com.example.personalaccount.repository.UserSpecialCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
