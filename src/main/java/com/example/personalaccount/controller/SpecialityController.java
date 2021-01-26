package com.example.personalaccount.controller;


import com.example.personalaccount.repository.SpecialityRepository;
import com.example.personalaccount.table.Role;
import com.example.personalaccount.table.SpecialityLK;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/speciality")
public class SpecialityController {
    @Autowired
    SpecialityRepository specialityRepository;

    public SpecialityController(SpecialityRepository specialityRepository){
        this.specialityRepository=specialityRepository;
    }

    @GetMapping("/findall")
    public List<SpecialityLK> findALL(){
        return specialityRepository.findAll();
    }

    @GetMapping("/findone/{id}")
    public SpecialityLK getOne(@PathVariable("id") SpecialityLK specialityLK){return specialityLK;}

    @PostMapping("/create")
    public SpecialityLK create(@RequestBody SpecialityLK specialityLK){
        return specialityRepository.save(specialityLK);
    }

    @PutMapping("/update/{id}")
    public SpecialityLK update(@PathVariable("id") SpecialityLK specialityLKUpdateDB, @RequestBody SpecialityLK specialityLK){
        BeanUtils.copyProperties(specialityLK,specialityLKUpdateDB,"id");

        return specialityRepository.save(specialityLKUpdateDB);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") SpecialityLK specialityLK){
        specialityRepository.delete(specialityLK);
    }
}
