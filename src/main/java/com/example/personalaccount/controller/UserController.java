package com.example.personalaccount.controller;


import com.example.personalaccount.repository.*;
import com.example.personalaccount.table.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@RestController
//@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository repository;

    public UserController(UserRepository repository){
        this.repository=repository;
    }


    @GetMapping("/findall")
    public List<UserLK> findALL(){
        return repository.findAll();
    }

    @GetMapping("/findone/{id}")
    public UserLK getOne(@PathVariable("id") UserLK userLK){return userLK;}


    @GetMapping(value={"/user/create"})
    public String init(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("repository", repository);
        return "index";
    }

    public String showAddUser(Model model){
        UserLK userLK=new UserLK();
        model.addAttribute("create",true);
        model.addAttribute("userLK",userLK);

        return "user-edit";
    }

    @PostMapping(value={"/add"})
    public UserLK addUser(Model model, @ModelAttribute("userLK") UserLK userLK){
        return repository.save(userLK);
    }
   ///
    //@PostMapping("/create")
    //public UserLK create(@RequestBody UserLK userLK){
        //return repository.save(userLK);
    //}////

    //@RequestMapping(value="/user", method = RequestMethod.GET)
    //public String init(@ModelAttribute("userLK") ModelMap userLK){
        //userLK.addAttribute("users",repository);
       // return "OK";
    //}

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public UserLK addUser(@ModelAttribute("userLK") UserLK userLK){
        return repository.save(userLK);
    }


    @PutMapping("/update/{id}")
    public UserLK update(@PathVariable("id") UserLK userUpdateDB, @RequestBody UserLK userLK){
        BeanUtils.copyProperties(userLK,userUpdateDB,"id");

        return repository.save(userUpdateDB);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") UserLK userLK){
        repository.delete(userLK);
    }
}
