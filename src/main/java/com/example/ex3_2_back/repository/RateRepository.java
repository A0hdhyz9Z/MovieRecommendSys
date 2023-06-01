package com.example.ex3_2_back.repository;


import com.example.ex3_2_back.entity.Rate;
import com.example.ex3_2_back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RateRepository extends JpaRepository<Rate,Integer> {
     List<Rate> findAllByUser(User user);
}
