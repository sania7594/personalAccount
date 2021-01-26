package com.example.personalaccount.repository;

import com.example.personalaccount.table.Department;
import com.example.personalaccount.table.Role;
import com.example.personalaccount.table.UserLK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Set<Department> findByDepartmentName(String departmentName);
    Department findByDepartmentId(Long id);
}
