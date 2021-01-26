package com.example.personalaccount.controller;


import com.example.personalaccount.repository.*;
import com.example.personalaccount.table.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {
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
    CoursesRepository coursesRepository;

    @Autowired
    SpecialityRepository specialityRepository;

     */

    @GetMapping("/usercreate")
    public String userAdd(){
       //repository.save(new UserLK("Ivanov","Ivanov","lieyha@mail.ru","89103217634","05.08.2020","ret","1233455"));
       UserLK user1=new UserLK("Ivanov","Ivanov","lieyha@mail.ru","89103217634","05.08.2020","ret","1233455");
       UserLK user2=new UserLK("Grin","Ivanov","lieyha1@mail.ru","89103217634","05.08.2019","retf","12334551");
       //roleRepository.save(new Role("ректор"));

       //departmentRepository.save(new Department("АХЧ"));
       //groupRepository.save(new GroupLK("3ПИ"));
       //coursesRepository.save(new Courses("2"));
       //specialityRepository.save(new Speciality("ПИ"));

        /**
        Role role1=new Role("ректор");
        Role role2=new Role("администратор");

        Department department=new Department("АХЧ");

        role1.setDepartmentLK(Arrays.asList(department));
        role2.setDepartmentLK(Arrays.asList(department));

        user1.setRoleUser(Arrays.asList(role1));
        user2.setRoleUser(Arrays.asList(role2,role1));

        List<UserLK> userLK= Arrays.asList(user1,user2);
        repository.saveAll(userLK);

       /*
       List<Role> roles1=new ArrayList<Role>() ;
       roles1.add(role1);

        List<Role> roles2=new ArrayList<Role>() ;
        roles2.add(role2);

        user1.setRoleUser(roles1);
        user2.setRoleUser(roles2);

        List<UserLK> userLK= Arrays.asList(user1,user2);
        repository.saveAll(userLK);
        //до сюда
        */
       //List<UserRoles> role1l=new ArrayList<>();
       //role1l.add(role1);
        //user1.setRoles(role1l);
        //List<Role> role2l=new ArrayList<>();
        //role1l.add(role2);
        //List<UserLK> user= Arrays.asList(user1);


       return "user create";
    }

    @GetMapping("/findall")
    public List<UserLK> findAll(){
        List<UserLK> users=repository.findAll();
        List<UserLK> userResult=new ArrayList<>();

        for (UserLK user:users){
            userResult.add(new UserLK(user.getFirstName(), user.getLastName(),user.getEmail(),user.getPhone(),user.getBirthday(),user.getLogin(),user.getPassword()));
        }
        return userResult;
    }

    @GetMapping("/deletealluser")
    public String deleteAllUser(){
        repository.deleteAll();
        return "delete all user";
    }
    
    //public String deleteUser(){

    //}





}
