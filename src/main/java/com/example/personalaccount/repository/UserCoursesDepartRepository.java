package com.example.personalaccount.repository;

import com.example.personalaccount.table.UserCoursersDepartment;
import com.example.personalaccount.table.UserLK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserCoursesDepartRepository extends JpaRepository<UserCoursersDepartment,Long> {
    //UserCoursersDepartment findByUserLK(String FirstName);
}
