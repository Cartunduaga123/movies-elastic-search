package com.unir.movie_app_search.persistence.repository;

import com.unir.movie_app_search.persistence.entity.MovieEntity;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class CustomMovieRepositoryImpl implements CustomMovieRepository {

    public final ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    public CustomMovieRepositoryImpl(ElasticsearchRestTemplate elasticsearchRestTemplate) {
        this.elasticsearchRestTemplate = elasticsearchRestTemplate;
    }

    @Override
    public List<MovieEntity> searchMovies(String nombre, String director, Integer anoPublicacion, String sinopsis, String criticas, Integer duracion, Integer puntuacion, String lenguaje, Double precio, Double precioRenta) {
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();

        if (nombre != null) {
            queryBuilder.must(QueryBuilders.matchQuery("nombre", nombre));
        }
        if (director != null) {
            queryBuilder.must(QueryBuilders.matchQuery("director", director));
        }
        if (anoPublicacion != null) {
            queryBuilder.must(QueryBuilders.matchQuery("ano_publicacion", anoPublicacion));
        }
        if (sinopsis != null) {
            queryBuilder.must(QueryBuilders.matchQuery("sinopsis", sinopsis));
        }
        if (criticas != null) {
            queryBuilder.must(QueryBuilders.matchQuery("criticas", criticas));
        }
        if (duracion != null) {
            queryBuilder.must(QueryBuilders.matchQuery("duracion", duracion));
        }
        if (puntuacion != null) {
            queryBuilder.must(QueryBuilders.matchQuery("puntuacion", puntuacion));
        }
        if (lenguaje != null) {
            queryBuilder.must(QueryBuilders.matchQuery("lenguaje", lenguaje));
        }
        if (precio != null) {
            queryBuilder.must(QueryBuilders.matchQuery("precio", precio));
        }
        if (precioRenta != null) {
            queryBuilder.must(QueryBuilders.matchQuery("precio_renta", precioRenta));
        }

        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .build();

        SearchHits<MovieEntity> searchHits = elasticsearchRestTemplate.search(searchQuery, MovieEntity.class);
        return (List<MovieEntity>) ((SearchHits<?>) searchHits).getSearchHits().stream()
                .map(hit -> hit.getContent())
                .collect(Collectors.toList());
    }

}
