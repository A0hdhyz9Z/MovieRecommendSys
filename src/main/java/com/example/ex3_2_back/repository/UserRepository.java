package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//DAO
//<表名，主键>
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByName(String name);

    Optional<User> findByNameAndPassword(String name, String password);

    boolean existsByName(String name);

    boolean existsByNameAndPassword(String name, String password);

    void deleteByName(String name);
}
