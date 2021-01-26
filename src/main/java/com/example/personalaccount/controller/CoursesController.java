package com.example.personalaccount.controller;

import com.example.personalaccount.repository.CoursesRepository;
import com.example.personalaccount.table.CourcesLK;
import com.example.personalaccount.table.UserLK;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesController {
    @Autowired
    CoursesRepository coursesRepository;

    public CoursesController(CoursesRepository coursesRepository){
        this.coursesRepository=coursesRepository;
    }

    @GetMapping("/findall")
    public List<CourcesLK> findALL(){
        return coursesRepository.findAll();
    }

    @GetMapping("/findone/{id}")
    public CourcesLK getOne(@PathVariable("id") CourcesLK courcesLK){return courcesLK;}

    @PostMapping("/create")
    public CourcesLK create(@RequestBody CourcesLK courcesLK){
        return coursesRepository.save(courcesLK);
    }

    @PutMapping("/update/{id}")
    public CourcesLK update(@PathVariable("id") CourcesLK courcesUpdateDB, @RequestBody CourcesLK courcesLK){
        BeanUtils.copyProperties(courcesLK,courcesUpdateDB,"id");

        return coursesRepository.save(courcesUpdateDB);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") CourcesLK courcesLK){
        coursesRepository.delete(courcesLK);
    }
}
