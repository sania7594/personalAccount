package com.example.personalaccount.controller;

import com.example.personalaccount.repository.DepartmentRepository;
import com.example.personalaccount.table.Department;
import com.example.personalaccount.table.GroupLK;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository=departmentRepository;
    }

    @GetMapping("/findall")
    public List<Department> findALL(){
        return departmentRepository.findAll();
    }

    @GetMapping("/findone/{id}")
    public Department getOne(@PathVariable("id") Department department){return department;}

    @PostMapping("/create")
    public Department create(@RequestBody Department department){
        return departmentRepository.save(department);
    }

    @PutMapping("/update/{id}")
    public Department update(@PathVariable("id") Department departmentUpdateDB, @RequestBody Department department){
        BeanUtils.copyProperties(department,departmentUpdateDB,"id");

        return departmentRepository.save(departmentUpdateDB);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Department department){
        departmentRepository.delete(department);
    }
}
