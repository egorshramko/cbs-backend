package io.github.egorshramko.cbs.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.github.egorshramko.cbs.dto.MovieDto;
import io.github.egorshramko.cbs.facade.MovieServiceFacade;
import io.github.egorshramko.cbs.model.Movie;
import io.github.egorshramko.cbs.service.MovieService;
import io.github.egorshramko.cbs.service.S3PresignedUrlService;
import io.github.egorshramko.cbs.util.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MovieServiceFacadeImpl implements MovieServiceFacade {

    @Value("${domain.name}")
    private String domainName;

    private final MovieMapper movieMapper;
    private final MovieService movieService;
    private final S3PresignedUrlService s3PresignedUrlService;

    @Override
    public List<MovieDto> getAllMovies() {
        final List<Movie> movies = movieService.getAllMovies();
        final List<MovieDto> movieDtos = new ArrayList<>(movies.size());

        for (Movie movie : movies) {

            // TODO: добавить кеширование подписанного URL и запрос из кеша

            final String moviesBucket = "movies";
            
            final String imageUrl = s3PresignedUrlService.getPresignedUrl(moviesBucket, movie.getPosterFilename());

            final MovieDto movieDto = movieMapper.toDto(movie, imageUrl);
            movieDtos.add(movieDto);

        }

        return movieDtos;
    }



}
