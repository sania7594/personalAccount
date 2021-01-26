package com.example.personalaccount.repository;

import com.example.personalaccount.table.UserSpecialCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSpecialCourseRepository extends JpaRepository<UserSpecialCourse,Long> {
}
