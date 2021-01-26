package com.example.personalaccount.controller;

import com.example.personalaccount.repository.CoursesRepository;
import com.example.personalaccount.repository.DepartmentRepository;
import com.example.personalaccount.repository.UserCoursesDepartRepository;
import com.example.personalaccount.repository.UserRepository;
import com.example.personalaccount.table.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usercourdepart")
public class UserCourceDepartController {
    @Autowired
    UserCoursesDepartRepository userCoursesDepartRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CoursesRepository coursesRepository;

    @Autowired
    DepartmentRepository departmentRepository;


    public UserCourceDepartController(UserCoursesDepartRepository userCoursesDepartRepository, UserRepository userRepository, CoursesRepository coursesRepository, DepartmentRepository departmentRepository) {
        this.userCoursesDepartRepository = userCoursesDepartRepository;
        this.userRepository = userRepository;
        this.coursesRepository = coursesRepository;
        this.departmentRepository = departmentRepository;
    }

    @GetMapping("/findall")
    public List<UserCoursersDepartment> findALL(){
        return userCoursesDepartRepository.findAll();
    }

    @GetMapping("/findone/{id}")
    public UserCoursersDepartment getOne(@PathVariable("id") UserCoursersDepartment userCoursersDepartment){return userCoursersDepartment;}

    @PostMapping("/create/{userId}/{courseId}/{depId}")
    public UserCoursersDepartment create(@PathVariable Long userId, @PathVariable Long courseId, @PathVariable Long depId){
        UserCoursersDepartment userCoursersDepartment = null;
        UserLK userLK=userRepository.findByUserId(userId);
        CourcesLK courcesLK=coursesRepository.findByCourcesId(courseId);
        Department departmentLK=departmentRepository.findByDepartmentId(depId);
        userCoursersDepartment.setUserL(userLK);
        userCoursersDepartment.setCourcesLK(courcesLK);
        userCoursersDepartment.setDepartmentL(departmentLK);

        return userCoursesDepartRepository.save(userCoursersDepartment);

    }

    @DeleteMapping("/delete/{userId}/{courseId}/{depId}")
    public void delete(@PathVariable Long userId, @PathVariable Long courseId, @PathVariable Long depId){
        UserCoursersDepartment userCoursersDepartment = null;
        UserLK userLK=userRepository.findByUserId(userId);
        CourcesLK courcesLK=coursesRepository.findByCourcesId(courseId);
        Department departmentLK=departmentRepository.findByDepartmentId(depId);
        userCoursersDepartment.setUserL(userLK);
        userCoursersDepartment.setCourcesLK(courcesLK);
        userCoursersDepartment.setDepartmentL(departmentLK);

        userCoursesDepartRepository.delete(userCoursersDepartment);
    }

    @PutMapping("/update/{id}")
    public UserCoursersDepartment update(@PathVariable("id") UserCoursersDepartment erdUpdateDB, @RequestBody UserCoursersDepartment urd){
        BeanUtils.copyProperties(urd,erdUpdateDB,"id");

        return userCoursesDepartRepository.save(erdUpdateDB);
    }
}

