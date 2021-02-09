package com.example.personalaccount.service;

import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserService<T,R>{

    <T,R> List<T> findall(R repository);

    <T,R> T getOne(T element,R repository);

    <T,R> T create(T element,R repository);

    <T,R> T update(T updateDB, T element, R repository);

    <T,R> T delete(T element, R repository);

}
