package com.example.personalaccount.repository;

import com.example.personalaccount.table.CourcesLK;
import com.example.personalaccount.table.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends JpaRepository<CourcesLK, Long> {
    CourcesLK findByCourcesId(Long courcesId);
}
