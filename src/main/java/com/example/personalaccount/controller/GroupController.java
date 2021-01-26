package com.example.personalaccount.controller;

import com.example.personalaccount.repository.GroupRepository;
import com.example.personalaccount.table.GroupLK;
import com.example.personalaccount.table.UserLK;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    GroupRepository groupRepository;

    public GroupController(GroupRepository groupRepository){
        this.groupRepository=groupRepository;
    }

    @GetMapping("/findall")
    public List<GroupLK> findALL(){
        return groupRepository.findAll();
    }

    @GetMapping("/findone/{id}")
    public GroupLK getOne(@PathVariable("id") GroupLK groupLK){return groupLK;}

    @PostMapping("/create")
    public GroupLK create(@RequestBody GroupLK groupLK){
        return groupRepository.save(groupLK);
    }

    @PutMapping("/update/{id}")
    public GroupLK update(@PathVariable("id") GroupLK groupUpdateDB, @RequestBody GroupLK groupLK){
        BeanUtils.copyProperties(groupLK,groupUpdateDB,"id");

        return groupRepository.save(groupUpdateDB);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") GroupLK groupLK){
        groupRepository.delete(groupLK);
    }

}
