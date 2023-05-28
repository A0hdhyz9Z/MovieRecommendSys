package com.example.ex3_2_back.repository;

import com.example.ex3_2_back.entity.Movie;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findByOriginalTitle(String originalTitle);


    List<Movie> findByOrderByVoteAverage(Pageable pageable);

    @Query("select m from Movie m, Recommendation r where r.user.id = :userId and m.id = r.movie1.id and m.id = r.movie2.id and m.id = r.movie3.id and m.id = r.movie4.id and m.id = r.movie5.id and m.id = r.movie6.id and m.id = r.movie7.id and m.id = r.movie8.id and m.id = r.movie9.id and m.id = r.movie10.id and m.id = r.movie11.id and m.id = r.movie12.id and m.id = r.movie13.id and m.id = r.movie14.id and m.id = r.movie15.id and m.id = r.movie16.id and m.id = r.movie17.id and m.id = r.movie18.id and m.id = r.movie19.id and m.id = r.movie20.id")
    List<Movie> findMovieRecommendedForUser(Integer userId);
}
