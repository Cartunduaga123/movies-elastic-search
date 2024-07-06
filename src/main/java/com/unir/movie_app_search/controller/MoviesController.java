package com.unir.movie_app_search.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.unir.movie_app_search.persistence.entity.MovieEntity;
import com.unir.movie_app_search.service.MovieService;
import java.util.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MoviesController {

    private final MovieService movieService;

    @GetMapping("/peliculas")
    public ResponseEntity<List<MovieEntity>> getAll(
            @RequestHeader Map<String, String> headers,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String director,
            @RequestParam(required = false) Integer anoPublicacion,
            @RequestParam(required = false) String sinopsis,
            @RequestParam(required = false) String criticas,
            @RequestParam(required = false) Integer duracion,
            @RequestParam(required = false) Integer puntuacion,
            @RequestParam(required = false) String lenguaje,
            @RequestParam(required = false) Double precio,
            @RequestParam(required = false) Double precioRenta
    ) {
        List<MovieEntity> movies = movieService.getAll(nombre, director, anoPublicacion, sinopsis, criticas, duracion, puntuacion, lenguaje, precio, precioRenta);
        return ResponseEntity.ok(Objects.requireNonNullElse(movies, Collections.emptyList()));
    }

    @GetMapping("/peliculas/{idMovie}")
    public ResponseEntity<Optional<MovieEntity>> get(@PathVariable String idMovie) {
        return ResponseEntity.ok(this.movieService.get(idMovie));
    }

    @PostMapping("/peliculas")
    public ResponseEntity<MovieEntity> add(@RequestBody MovieEntity movie) {
        if (movie.getId() == null || !this.movieService.exists(movie.getId())) {
            return ResponseEntity.ok(this.movieService.save(movie));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/peliculas/{id}")
    public ResponseEntity<MovieEntity> update(@PathVariable String id, @RequestBody MovieEntity movie) {
        if (id != null && movieService.exists(id)) {
            movie.setId(id);
            return ResponseEntity.ok(movieService.save(movie));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/peliculas/{idMovie}")
    public ResponseEntity<Void> delete(@PathVariable String idMovie) {
        if (this.movieService.exists(idMovie)) {
            this.movieService.delete(idMovie);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/peliculas/exist/{idMovie}")
    public ResponseEntity<Boolean> exist(@PathVariable String idMovie) {
        return ResponseEntity.ok(this.movieService.exists(idMovie));
    }

    @GetMapping("/search")
    public SearchHits<MovieEntity> search(@RequestParam String query) {
        return movieService.searchMovies(query);
    }

}

