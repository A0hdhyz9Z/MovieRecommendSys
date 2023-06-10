package com.example.ex3_2_back.repository;


import com.example.ex3_2_back.entity.Rate;
import com.example.ex3_2_back.entity.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "RateRepository")
@Tag(name = "数据库Rate接口")
public interface RateRepository extends JpaRepository<Rate, Integer> {
    List<Rate> findAllByUser(User user);
}
