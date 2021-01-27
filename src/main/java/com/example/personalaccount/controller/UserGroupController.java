package com.example.personalaccount.controller;


import com.example.personalaccount.repository.GroupRepository;
import com.example.personalaccount.repository.UserGroupsRepository;
import com.example.personalaccount.repository.UserRepository;
import com.example.personalaccount.table.GroupLK;
import com.example.personalaccount.table.UserGroup;
import com.example.personalaccount.table.UserLK;
import com.example.personalaccount.table.UserRoleDepartment;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usergroup")
public class UserGroupController {

    @Autowired
    UserGroupsRepository userGroupsRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    GroupRepository groupRepository;

    public UserGroupController(UserGroupsRepository userGroupsRepository, UserRepository userRepository, GroupRepository groupRepository) {
        this.userGroupsRepository = userGroupsRepository;
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
    }

    @GetMapping("findall")
    public List<UserGroup> findALL(){
        return userGroupsRepository.findAll();
    }

    @GetMapping("/findone/{id}")
    public UserGroup getOne(@PathVariable("id") UserGroup userGroup){return userGroup;}

    @PostMapping("/create/{userId}/{groupId}}")
    public UserGroup createUserGroups(@PathVariable Long userId, @PathVariable Long groupId){
        UserGroup userGroup = vale(userId,groupId);
        return userGroupsRepository.save(userGroup);
    }
    //@PutMapping("/update/{id}")
    //public UserGroup update(@PathVariable("id") UserGroup userGroupDB, @RequestBody UserGroup userGroup){
        //BeanUtils.copyProperties(userGroup,userGroupDB,"id");

        //return userGroupsRepository.save(userGroupDB);
    //}
    @DeleteMapping("/delete/{userId}/{groupId}}")
    public void delete(@PathVariable Long userId, @PathVariable Long groupId) {
        UserGroup userGroup = vale(userId,groupId);
        userGroupsRepository.delete(userGroup);
    }

    private UserGroup vale(Long userId, Long groupId){
        UserGroup userGroup = new UserGroup();
        UserLK userLK = userRepository.findByUserId(userId);
        GroupLK groupLK = groupRepository.findByGroupId(groupId);
        userGroup.setUserGroupLK(userLK);
        userGroup.setGroupLK(groupLK);
        return userGroup;
    }

}
