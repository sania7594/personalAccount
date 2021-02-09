package com.example.personalaccount.controller;


import com.example.personalaccount.repository.*;
import com.example.personalaccount.service.UserServiceImpl;
import com.example.personalaccount.service.UserServiceT;
import com.example.personalaccount.table.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/probuser")
public class ProbUserController {

    private final UserServiceImpl userServiceImpl;

    public ProbUserController(UserServiceImpl userServiceImpl){
        this.userServiceImpl=userServiceImpl;
    }

    @GetMapping("/users")
    public String findALLUser(@ModelAttribute("model") ModelMap model){
        List<UserLK> repositorys=userServiceImpl.findALLuser();
        return "resultuser";
    }

    @GetMapping("/roles")
   public String findAllRole(@ModelAttribute("model") ModelMap model){
        List<Role> repositorys=userServiceImpl.findALLrole();
        return "resultrole";
    }

    @GetMapping("/groups")
    public String findAllGroup(){
        List<GroupLK>  repositorys= userServiceImpl.findALLgroup();
        return "resultgroup";
    }

    @GetMapping("/department")
    public String findAllDepartment(){
        List<Department>  repositorys= userServiceImpl.findAlldepartment();
        return "resultdepartment";
    }

    @GetMapping("/specialitys")
    public String findAllSpeciality(){
        List<SpecialityLK>  repositorys= userServiceImpl.findAllspeciality();
        return "resultdepartment";
    }

    @GetMapping("/courses")
    public String findAllCourses(){
        List<SpecialityLK>  repositorys= userServiceImpl.findAllspeciality();
        return "resultcourse";
    }

    @GetMapping("/add")
    public String formGet() {
        return "indexuser";
    }

    @PostMapping("/add")
    public String formPost(UserLK userLK, Model model) {
        model.addAttribute("userLK", userLK);
        userServiceImpl.createUser(userLK);
        //return "indexuser";
        return "indexrole";
    }

    @GetMapping("/addrole")
    public String formGetRole() {
        return "indexrole";
    }

    @PostMapping("/addrole")
    public String formPostRole(Role role, Model model) {
        model.addAttribute("role", role);
        userServiceImpl.createRole(role);
        return "indexgroup";
    }

    @GetMapping("/addgroup")
    public String formGetGroup() {
        return "indexgroup";
    }

    @PostMapping("/addgroup")
    public String formPostGroup(GroupLK groupLK, Model model) {
        model.addAttribute("group", groupLK);
        userServiceImpl.createGroup(groupLK);
        return "indexdepartment";
    }

    @GetMapping("/adddepartment")
    public String formGetDepartment() {
        return "indexdepartment";
    }

    @PostMapping("/adddepartment")
    public String formPostDeoartment(Department department, Model model) {
        model.addAttribute("department", department);
        userServiceImpl.createDepartment(department);
        return "indexspeciality";
    }

    @GetMapping("/addspeciality")
    public String formGetSpecialuty() {
        return "indexspeciality";
    }

    @PostMapping("/addspeciality")
    public String formPostSpeciality(SpecialityLK specialityLK, Model model) {
        model.addAttribute("specialityLK", specialityLK);
        userServiceImpl.createSpeciality(specialityLK);
        return "indexcourse";
    }

    @GetMapping("/addcourse")
    public String formGetCource() {
        return "indexcourse";
    }

    @PostMapping("/addcourse")
    public String formPostCource(CourcesLK courseLK, Model model) {
        model.addAttribute("courseLK", courseLK);
        userServiceImpl.create(courseLK);
        return "indexcourse";
    }

    @GetMapping("/delete")
    public String getDeleteUser(){
        return "deleteuser";
    }

    @PostMapping("/delete")
    public String deleteGetUser(Long id,Model model){
        userServiceImpl.deleteUser(id);
        //repository.delete(userLK);
        return "deleteuser";
    }

    @GetMapping("/deleterole")
    public String getDeleteRole(){
        return "deleterole";
    }

    @PostMapping("/deleterole")
    public String deleteGetRole(Long id,Model model){
        userServiceImpl.deleteRole(id);
        return "deleterole";
    }

    @GetMapping("/deletegroup")
    public String getDeleteGroup(){
        return "deletegroup";
    }

    @PostMapping("/deletegroup")
    public String deleteGetGroup(Long id,Model model){
        userServiceImpl.deleteRole(id);
        return "deletegroup";
    }

    @GetMapping("/deletedepartment")
    public String getDeleteDepartment(){
        return "deletedepartment";
    }

    @PostMapping("/deletedepartment")
    public String deleteGetDepartment(Long id,Model model){
        userServiceImpl.deleteDepartment(id);
        return "deletedepartment";
    }

    @GetMapping("/deletespeciality")
    public String getDeleteSpeciality(){
        return "deletespeciality";
    }

    @PostMapping("/deletespeciality")
    public String deleteGetSpeciality(Long id,Model model){
        userServiceImpl.deleteSpeciality(id);
        return "deletespeciality";
    }

    @GetMapping("/deletecourse")
    public String getDeleteCourse(){
        return "deletecourse";
    }

    @PostMapping("/deletecourse")
    public String deleteGetCourse(Long id,Model model){
        userServiceImpl.deleteCourse(id);
        return "deletecource";
    }



}
