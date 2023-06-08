package com.example.ex3_2_back.initializer;

import com.example.ex3_2_back.repository.MovieRepository;
import com.example.ex3_2_back.repository.SimilarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CsvReader implements CommandLineRunner {

    private MovieRepository movieRepository;
    private SimilarRepository similarRepository;

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Autowired
    public void setSimilarRepository(SimilarRepository similarRepository) {
        this.similarRepository = similarRepository;
    }

    @Override
    @SuppressWarnings("all")
    public void run(String... args) throws Exception {


//        Resource resource = new ClassPathResource("csv/related_movie.csv");
//        log.info("file: " + resource.getFile());
//
//        try (Reader reader = new FileReader(resource.getFile())) {
//            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
//            Iterator<CSVRecord> iterator = csvParser.stream().iterator();
//            iterator.next();
//            while (iterator.hasNext()) {
//                var csvRecord = iterator.next();
//                try {
//                    Integer movieId1 = Integer.valueOf(csvRecord.get(0));
//                    Integer movieId2 = Integer.valueOf(csvRecord.get(1));
//                    var movie1 = Movie.builder().id(movieId1).build();
//                    var movie2 = Movie.builder().id(movieId2).build();
//                    movieRepository.save(movie1);
//                    movieRepository.save(movie2);
//                    similarRepository.save(Similar.builder()
//                            .movie1(movie1)
//                            .movie2(movie2)
//                            .build());
//                } catch (Exception e) {
//                    log.info(e.getMessage());
//                }
//            }
//        }

    }
}
