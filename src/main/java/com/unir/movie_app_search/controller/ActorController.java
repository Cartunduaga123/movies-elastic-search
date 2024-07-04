package com.unir.movie_app_search.controller;

import com.unir.movie_app_search.persistence.entity.ActorEntity;
import com.unir.movie_app_search.service.ActorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ActorController {

    private final ActorService actorService;

    @GetMapping("/actores")
    public ResponseEntity<List<ActorEntity>> getAll() {
        List<ActorEntity> actors = actorService.getAll();
        return ResponseEntity.ok(Objects.requireNonNullElse(actors, Collections.emptyList()));
    }

    @GetMapping("/actores/{idActor}")
    public ResponseEntity<Optional<ActorEntity>> get(@PathVariable String idActor) {
        Optional<ActorEntity> actor = actorService.get(idActor);
        if (actor != null) {
            return ResponseEntity.ok(actor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/actores")
    public ResponseEntity<ActorEntity> add(@RequestBody ActorEntity actor) {
        ActorEntity createdActor = actorService.save(actor);
        return ResponseEntity.status(createdActor != null ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST).body(createdActor);
    }

    @PutMapping("/actores/{id}")
    public ResponseEntity<ActorEntity> update(@PathVariable String id, @RequestBody ActorEntity actor) {
        actor.setId(id); // Ensure the ID is set for update
        ActorEntity updatedActor = actorService.save(actor);
        return ResponseEntity.ok(updatedActor);
    }

    @DeleteMapping("/actores/{idActor}")
    public ResponseEntity<Void> delete(@PathVariable String idActor) {
        actorService.delete(idActor);
        return ResponseEntity.noContent().build();
    }

}
