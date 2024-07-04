package com.unir.movie_app_search.controller;

import com.unir.movie_app_search.persistence.entity.CategoryEntity;
import com.unir.movie_app_search.persistence.entity.MovieEntity;
import com.unir.movie_app_search.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/categorias")
    public ResponseEntity<List<CategoryEntity>> getAll() {
        List<CategoryEntity> movies = categoryService.getAll();
        return ResponseEntity.ok(Objects.requireNonNullElse(movies, Collections.emptyList()));
    }

    @GetMapping("/categorias/{idCategory}")
    public ResponseEntity<Optional<CategoryEntity>> get(@PathVariable String idCategory) {
        return ResponseEntity.ok(this.categoryService.get(idCategory));
    }

    @PostMapping("/categorias")
    public ResponseEntity<CategoryEntity> add(@RequestBody CategoryEntity movie) {
        if (movie.getId() == null || !this.categoryService.exists(movie.getId())) {
            return ResponseEntity.ok(this.categoryService.save(movie));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/categorias/{id}")
    public ResponseEntity<CategoryEntity> update(@PathVariable String id, @RequestBody CategoryEntity movie) {
        if (id != null && categoryService.exists(id)) {
            movie.setId(id);
            return ResponseEntity.ok(categoryService.save(movie));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/categorias/{idCategory}")
    public ResponseEntity<Void> delete(@PathVariable String idCategory) {
        if (this.categoryService.exists(idCategory)) {
            this.categoryService.delete(idCategory);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
