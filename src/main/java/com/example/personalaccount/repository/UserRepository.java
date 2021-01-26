package com.example.personalaccount.repository;

import com.example.personalaccount.table.UserLK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserLK, Long> {
    List<UserLK> findByFirstName(String FirstName);

}
