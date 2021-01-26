package com.example.personalaccount.repository;

import com.example.personalaccount.table.Department;
import com.example.personalaccount.table.Role;
import com.example.personalaccount.table.UserLK;
import com.example.personalaccount.table.UserRoleDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRolesDepartRepository extends JpaRepository<UserRoleDepartment, Long> {
    //UserRoleDepartment findByUserLKAndRoleUserAndDepartment(UserLK userLK, Role roleUser, Department department);
    //Set<UserLK> findByUserLK()
}
