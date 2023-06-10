package com.example.ex3_2_back.repository;


import com.example.ex3_2_back.entity.Rate;
import com.example.ex3_2_back.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "RateRepository")
@Tag(name = "RateRepository")
public interface RateRepository extends JpaRepository<Rate, Integer> {
    @Operation(summary = "查询所有打分")
    List<Rate> findAllByUser(User user);
}
