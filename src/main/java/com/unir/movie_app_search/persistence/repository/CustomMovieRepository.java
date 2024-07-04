package com.unir.movie_app_search.persistence.repository;

import com.unir.movie_app_search.persistence.entity.MovieEntity;

import java.util.List;

public interface CustomMovieRepository {

    List<MovieEntity> searchMovies(String nombre, String director, Integer anoPublicacion, String sinopsis, String criticas, Integer duracion, Integer puntuacion, String lenguaje, Double precio, Double precioRenta);

}
