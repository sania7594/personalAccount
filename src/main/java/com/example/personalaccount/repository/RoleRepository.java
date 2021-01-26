package com.example.personalaccount.repository;


import com.example.personalaccount.table.Department;
import com.example.personalaccount.table.Role;
import com.example.personalaccount.table.UserLK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Long> {
    Set<Role> findByRoleName(String roleName);
    Role findByUserIdR(Long id);
}
