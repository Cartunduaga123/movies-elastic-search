package com.unir.movie_app_search.persistence.repository;

import com.unir.movie_app_search.persistence.entity.ActorEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ActorRepository extends ElasticsearchRepository<ActorEntity, String> {

}
