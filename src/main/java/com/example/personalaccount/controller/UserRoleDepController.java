package com.example.personalaccount.controller;

import com.example.personalaccount.repository.DepartmentRepository;
import com.example.personalaccount.repository.RoleRepository;
import com.example.personalaccount.repository.UserRepository;
import com.example.personalaccount.repository.UserRolesDepartRepository;
import com.example.personalaccount.table.Department;
import com.example.personalaccount.table.Role;
import com.example.personalaccount.table.UserLK;
import com.example.personalaccount.table.UserRoleDepartment;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/urc")
public class UserRoleDepController {
    @Autowired
    UserRolesDepartRepository userRolesDepartRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    public UserRoleDepController(UserRolesDepartRepository userRolesDepartRepository){
        this.userRolesDepartRepository=userRolesDepartRepository;
    }

    @GetMapping("/findall")
    public List<UserRoleDepartment> findALL(){
        return userRolesDepartRepository.findAll();
    }

    @GetMapping("/findone/{id}")
    public UserRoleDepartment getOne(@PathVariable("id") UserRoleDepartment userRoleDepartment){return userRoleDepartment;}

    @PostMapping("/create/{userId}/{roleId}/{depId}")
    public UserRoleDepartment findEntity(@PathVariable Long userId, @PathVariable Long roleId, @PathVariable Long depId ){
        UserRoleDepartment userRoleDepartment = null;
        UserLK userLK=userRepository.findByUserId(userId);
        Role role=roleRepository.findByUserIdR(roleId);
        Department department=departmentRepository.findByDepartmentId(depId);
        userRoleDepartment.setUserLK(userLK);
        userRoleDepartment.setRoleUser(role);
        userRoleDepartment.setDepartment(department);
        return userRolesDepartRepository.save(userRoleDepartment);
    }

    //@DeleteMapping("/delete/{userId}/{roleId}/{depId}")
    //public void delete(@PathVariable Long userId, @PathVariable Long roleId, @PathVariable Long depId){
        //UserRoleDepartment userRoleDepartment = null;
        //UserLK userLK=userRepository.findByUserId(userId);
        //Role role=roleRepository.findByUserIdR(roleId);
        //Department department=departmentRepository.findByDepartmentId(depId);
        //assert userRoleDepartment != null;
        //userRoleDepartment.setUserLK(userLK);
        //userRoleDepartment.setRoleUser(role);
        //userRoleDepartment.setDepartment(department);
        //userRolesDepartRepository.delete(userRoleDepartment);
    //}

    @PutMapping("/update/{id}")
    public UserRoleDepartment update(@PathVariable("id") UserRoleDepartment erdUpdateDB, @RequestBody UserRoleDepartment urd){
        BeanUtils.copyProperties(urd,erdUpdateDB,"id");

        return userRolesDepartRepository.save(erdUpdateDB);
    }
}
