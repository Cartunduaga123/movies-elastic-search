package com.unir.movie_app_search.service;

import com.unir.movie_app_search.persistence.entity.ActorEntity;
import com.unir.movie_app_search.persistence.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<ActorEntity> getAll() {
        return null;//this.actorRepository.findAll();
    }

    public Optional<ActorEntity> get(String idActor) {
        return this.actorRepository.findById(idActor);
    }

    public ActorEntity save(ActorEntity actorEntity) {
        return this.actorRepository.save(actorEntity);
    }

    public void delete(String idActor) {
        this.actorRepository.deleteById(idActor);
    }

    public boolean exists(String idActor) {
        return this.actorRepository.existsById(idActor);
    }

}
