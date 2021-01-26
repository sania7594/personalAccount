package com.example.personalaccount.repository;

import com.example.personalaccount.table.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGroupsRepository extends JpaRepository<UserGroup,Long> {
}
