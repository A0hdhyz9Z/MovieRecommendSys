package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.TagHub;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "TagHubRepository")
@Tag(name = "TagHubRepository")
public interface TagHubRepository extends JpaRepository<TagHub, Integer> {
}