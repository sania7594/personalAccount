package com.example.personalaccount.controller;


import com.example.personalaccount.repository.*;
import com.example.personalaccount.table.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Controller
//@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository repository;

    public UserController(UserRepository repository){
        this.repository=repository;
    }


    @GetMapping("/add")
    public String formGet() {
        return "index";
    }

    @PostMapping("/add")
    public String formPost(UserLK userLK, Model model) {
        model.addAttribute("userLK", userLK);
        repository.save(userLK);
        return "index";
    }

    @GetMapping("/users")
    public String formUsers(@ModelAttribute("model") ModelMap model){
        model.addAttribute("repository",repository);
        repository.findAll();
        return "result";
    }



}
