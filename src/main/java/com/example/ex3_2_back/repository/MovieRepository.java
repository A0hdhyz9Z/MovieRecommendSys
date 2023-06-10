package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RepositoryRestResource(path = "repo-movie")
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findByOrderByVoteAverage();

    // @czy 这里 Pageable pageable
    Page<Movie> findByOrderByVoteAverage(Pageable pageable);


    @Query("select k.movie from Keyword k,TagHub t where t.id = k.tagHub.id and t.name in :tags")
    List<Movie> findMovieWithTags(List<String> tags);

    @Query("select k.movie from Keyword k,TagHub t where t.id = k.tagHub.id and t.name in :tags")
    Page<Movie> findMovieWithTags(List<String> tags, Pageable pageable);

    @Transactional
    @Modifying
    @Query("UPDATE Movie m SET m.seenCount = m.seenCount + 1 WHERE m.id = :movieId")
    void incrementSeenCount(Integer movieId);
}
