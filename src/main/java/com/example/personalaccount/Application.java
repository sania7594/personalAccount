package com.example.personalaccount;

import com.example.personalaccount.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    @Autowired
    UserRepository repository;

    @Autowired
    RoleRepository roleRepository;


    @Autowired
    DepartmentRepository departmentRepository;

    /*
    @Autowired
    GroupRepository groupRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    CoursesRepository coursesRepository;


     */

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
