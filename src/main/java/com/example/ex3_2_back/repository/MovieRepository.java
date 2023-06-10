package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Movie;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RepositoryRestResource(path = "MovieRepository")
@Tag(name = "MovieRepository")
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findByOrderByVoteAverage();

    @RestResource(path = "findByOrderByVoteAverage-Pageable")
    @Operation(summary = "通过评分排序电影（分页）")
    Page<Movie> findByOrderByVoteAverage(Pageable pageable);

    @RestResource(path = "findByOrderByVoteAverageDesc-Pageable")
    @Operation(summary = "通过评分排序电影（降序，分页）")
    Page<Movie> findByOrderByVoteAverageDesc(Pageable pageable);

    @Operation(summary = "通过评分排序电影")
    @Query("select k.movie from Keyword k,TagHub t where t.id = k.tagHub.id and t.name in :tags")
    List<Movie> findMovieWithTags(List<String> tags);

    @Query("select k.movie from Keyword k,TagHub t where t.id = k.tagHub.id and t.name in :tags")
    @RestResource(path = "findMovieWithTags-Pageable")
    Page<Movie> findMovieWithTags(List<String> tags, Pageable pageable);

    @Operation(summary = "增加浏览次数")
    @Transactional
    @Modifying
    @Query("UPDATE Movie m SET m.seenCount = m.seenCount + 1 WHERE m.id = :movieId")
    @RestResource(path = "incrementSeenCount")
    void incrementSeenCount(Integer movieId);

    @Query("select gm.movie from GenreHub g, Genre gm where g.id = gm.genreHub.id and g.name in :genres")
    List<Movie> findMovieWithGenres(List<String> genres);

    @Query("select gm.movie from GenreHub g, Genre gm where g.id = gm.genreHub.id and g.name in :genres")
    @RestResource(path = "findMovieWithGenres-Pageable")
    Page<Movie> findMovieWithGenres(List<String> genres, Pageable pageable);

    @RestResource(path = "findByOriginalTitleLike(String originalTitle, Pageable pageable)")
    Page<Movie> findByOriginalTitleLike(String originalTitle, Pageable pageable);


    List<Movie> findByOriginalTitleLike(String originalTitle);
}
