package com.example.personalaccount.controller;

import com.example.personalaccount.repository.UserRepository;
import com.example.personalaccount.service.UserServiceImpl;
import com.example.personalaccount.table.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {
    private final UserServiceImpl userServiceImpl;

    public UserRestController(UserServiceImpl userServiceImpl){
        this.userServiceImpl=userServiceImpl;
    }

    @PostMapping("/createurd/{userId}/{roleId}/{depId}")
    public UserRoleDepartment createUTD(@PathVariable Long userId, @PathVariable Long roleId, @PathVariable Long depId ){
        return userServiceImpl.createUTD(userId, roleId, depId);
    }

    @PostMapping("/createug/{userId}/{groupId}}")
    public UserGroup createUserGroups(@PathVariable Long userId, @PathVariable Long groupId){
        return userServiceImpl.createUserGroups(userId, groupId);
    }

    @PostMapping("/createusc/{userId}/{specialId}/{courseId}")
    public UserSpecialCourse findEntity(@PathVariable Long userId, @PathVariable Long specialId, @PathVariable Long courseId ){
        return userServiceImpl.createUSC(userId, specialId, courseId);
    }

    @PostMapping("/createucd/{userId}/{courseId}/{depId}")
    public UserCoursersDepartment create(@PathVariable Long userId, @PathVariable Long courseId, @PathVariable Long depId){
        return userServiceImpl.createUCD(userId, courseId, depId);
    }

    @DeleteMapping("/deleteurd/{userId}/{roleId}/{depId}")
    public void deleteUDT(@PathVariable Long userId, @PathVariable Long roleId, @PathVariable Long depId){
        userServiceImpl.deleteUDT(userId, roleId, depId);
    }

    @DeleteMapping("/deleteug/{userId}/{groupId}}")
    public void deleteUG(@PathVariable Long userId, @PathVariable Long groupId) {
        userServiceImpl.deleteUserGroup(userId, groupId);
    }

    @DeleteMapping("/delete/{userId}/{roleId}/{depId}")
    public void deleteUSC(@PathVariable Long userId, @PathVariable Long specialId, @PathVariable Long courseId){
        userServiceImpl.deleteUSC(userId, specialId, courseId);
    }

    @DeleteMapping("/deleteucd/{userId}/{courseId}/{depId}")
    public void deleteUCD(@PathVariable Long userId, @PathVariable Long courseId, @PathVariable Long depId){
        userServiceImpl.deleteUCD(userId, courseId, depId);
    }




}
