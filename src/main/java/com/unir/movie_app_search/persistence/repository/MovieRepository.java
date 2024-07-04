package com.unir.movie_app_search.persistence.repository;

import com.unir.movie_app_search.persistence.entity.MovieEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends ElasticsearchRepository<MovieEntity, String>, CustomMovieRepository {

    List<MovieEntity> findByNombre(String nombre);

    @Override
    Optional<MovieEntity> findById(String id);

    @Override
    List<MovieEntity> findAll();

    @Override
    void deleteById(String id);

    @Override
    void delete(MovieEntity movieEntity);

}
