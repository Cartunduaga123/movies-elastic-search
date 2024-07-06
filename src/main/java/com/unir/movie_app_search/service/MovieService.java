package com.unir.movie_app_search.service;

import com.unir.movie_app_search.persistence.entity.MovieEntity;
import com.unir.movie_app_search.persistence.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.query.StringQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieEntity> getAll(String nombre, String director, Integer anoPublicacion, String sinopsis, String criticas, Integer duracion, Integer puntuacion, String lenguaje, Double precio, Double precioRenta) {
        return movieRepository.searchMovies(nombre, director, anoPublicacion, sinopsis, criticas, duracion, puntuacion, lenguaje, precio, precioRenta);
    }
    public Optional<MovieEntity> get(String idMovie) {
        return this.movieRepository.findById(idMovie);
    }

    public MovieEntity save(MovieEntity movieEntity) {
        return this.movieRepository.save(movieEntity);
    }

    public void delete(String idMovie) {
        this.movieRepository.deleteById(idMovie);
    }

    public List<MovieEntity> findByNombre(String nombre) {
        return this.movieRepository.findByNombre(nombre);
    }

    public boolean exists(String idMovie) {
        return this.movieRepository.existsById(idMovie);
    }

    public SearchHits<MovieEntity> searchMovies(String query) {
        Query searchQuery = new StringQuery("{\"match\": {\"title\": {\"query\": \"" + query + "\"}}}");
        return elasticsearchRestTemplate.search(searchQuery, MovieEntity.class);
    }

}
