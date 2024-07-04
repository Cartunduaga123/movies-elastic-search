package com.unir.movie_app_search.persistence.repository;

import com.unir.movie_app_search.persistence.entity.CategoryEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CategoryRepository extends ElasticsearchRepository<CategoryEntity, String> {

}
