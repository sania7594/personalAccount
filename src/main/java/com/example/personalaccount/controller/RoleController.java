package com.example.personalaccount.controller;

import com.example.personalaccount.repository.RoleRepository;
import com.example.personalaccount.table.Role;
import com.example.personalaccount.table.UserLK;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository){
        this.roleRepository=roleRepository;
    }

    @GetMapping("/findall")
    public List<Role> findALL(){
        return roleRepository.findAll();
    }

    @GetMapping("/findone/{id}")
    public Role getOne(@PathVariable("id") Role role){return role;}

    @PostMapping("/create")
    public Role create(@RequestBody Role role){
        return roleRepository.save(role);
    }

    @PutMapping("/update/{id}")
    public Role update(@PathVariable("id") Role roleUpdateDB, @RequestBody Role role){
        BeanUtils.copyProperties(role,roleUpdateDB,"id");

        return roleRepository.save(roleUpdateDB);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Role role){
        roleRepository.delete(role);
    }

}
