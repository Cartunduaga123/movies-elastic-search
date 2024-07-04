package com.unir.movie_app_search.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Document(indexName = "actors", createIndex = true)
public class ActorEntity {
    @Id
    private String id;

    @Field(type = FieldType.Text, name = "nombre")
    private String nombre;

    @Field(type = FieldType.Text, name = "nombre_personaje")
    private String nombrePersonaje;

    @Field(type = FieldType.Text, name = "img_url")
    private String imgUrl;

    public ActorEntity(Integer id, String nombre, String nombrePersonaje, String imgUrl) {
        this.id = id != null ? id.toString() : null;
        this.nombre = nombre;
        this.nombrePersonaje = nombrePersonaje;
        this.imgUrl = imgUrl;
    }
}
