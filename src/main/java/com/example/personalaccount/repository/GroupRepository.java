package com.example.personalaccount.repository;

import com.example.personalaccount.table.GroupLK;
import com.example.personalaccount.table.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface GroupRepository extends JpaRepository<GroupLK, Long> {
    Set<GroupLK> findByGroupName(String groupName);
    GroupLK findByGroupId(Long id);
}
