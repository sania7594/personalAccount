package com.example.personalaccount.controller;


import com.example.personalaccount.repository.*;
import com.example.personalaccount.table.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
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
    
    //@PostMapping("/create")
    //public UserLK create(@RequestBody UserLK userLK){
        //return repository.save(userLK);
    //}

    @PostMapping("/create")
    public UserLK create(@ModelAttribute("userLK") UserLK userLK){
        return repository.save(userLK);
    }

    //@PostMapping("/create")
    //public UserLK create(@RequestBody UserLK userLK, Model model){
        //model.addAttribute("userForm",new UserLK());
        //return repository.save(userLK);
    //}

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
