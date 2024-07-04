package com.unir.movie_app_search.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@NoArgsConstructor
@Document(indexName = "categories", createIndex = true)
public class CategoryEntity {
    @Id
    private String id;

    @Field(type = FieldType.Text, name = "nombre")
    private String nombre;

    public CategoryEntity(Integer id, String nombre) {
        this.id = id != null ? id.toString() : null;
        this.nombre = nombre;
    }
}
