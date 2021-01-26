package com.example.personalaccount.repository;

import com.example.personalaccount.table.Role;
import com.example.personalaccount.table.SpecialityLK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends JpaRepository<SpecialityLK, Long> {

}
