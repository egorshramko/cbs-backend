package io.github.egorshramko.cbs.config;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.github.egorshramko.cbs.model.Movie;
import io.github.egorshramko.cbs.model.enums.AgeLimit;
import io.github.egorshramko.cbs.model.enums.GenreCode;
import io.github.egorshramko.cbs.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class MoviesInitializer implements CommandLineRunner {

    @Value("${spring.cloud.aws.s3.endpoint}")
    private String s3Endpoint;

    private final MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        
        log.info("S3 Endpoint: {}", s3Endpoint);

        List<Movie> movies = new ArrayList<>();
        if (movieRepository.findAll().size() == 0) {
            movies.add(
                    Movie.builder()
                            .name("Последний богатырь. Колобок")
                            .genres(Set.of(GenreCode.COMEDY, GenreCode.FANTASY, GenreCode.ADVENTURE, GenreCode.FAMILY))
                            .actual(true)
                            .duration(Duration.ofMinutes(109))
                            .releaseDate(LocalDate.parse("2026-08-06"))
                            .country("Россия")
                            .posterFilename("kolobok.jpg")
                            .ageLimit(AgeLimit.OLDER_6)
                            .build()
            );
            movieRepository.saveAll(movies);
        }

    }

}
