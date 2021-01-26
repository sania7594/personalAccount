package com.example.personalaccount.repository;

import com.example.personalaccount.table.Department;
import com.example.personalaccount.table.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findByDepartmentName(String departmentName);
}
