package com.example.personalaccount.repository;

import com.example.personalaccount.table.UserLK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<UserLK, Long> {
    //Set<UserLK> findByFirstId(String FirstName);
    UserLK findByUserId(Long id);

}
