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
@Document(indexName = "movies", createIndex = true)
public class MovieEntity {
    @Id
    private String id;

    @Field(type = FieldType.Text, name = "nombre")
    private String nombre;

    @Field(type = FieldType.Text, name = "director")
    private String director;

    @Field(type = FieldType.Integer, name = "ano_publicacion")
    private Integer anoPublicacion;

    @Field(type = FieldType.Text, name = "sinopsis")
    private String sinopsis;

    @Field(type = FieldType.Text, name = "criticas")
    private String criticas;

    @Field(type = FieldType.Integer, name = "duracion")
    private Integer duracion;

    @Field(type = FieldType.Text, name = "trailer_url")
    private String trailerUrl;

    @Field(type = FieldType.Integer, name = "puntuacion")
    private Integer puntuacion;

    @Field(type = FieldType.Keyword, name = "lenguaje")
    private String lenguaje;

    @Field(type = FieldType.Text, name = "poster_url")
    private String posterUrl;

    @Field(type = FieldType.Text, name = "backdrop_url")
    private String backdropUrl;

    @Field(type = FieldType.Double, name = "precio")
    private Double precio;

    @Field(type = FieldType.Double, name = "precio_renta")
    private Double precioRenta;


    public MovieEntity(Integer id, String nombre, String director, Integer anoPublicacion, String sinopsis, String criticas, Integer duracion, String trailerUrl, Integer puntuacion, String lenguaje, String posterUrl, String backdropUrl, Double precio, Double precioRenta) {
        this.id = id != null ? id.toString() : null;
        this.nombre = nombre;
        this.director = director;
        this.anoPublicacion = anoPublicacion;
        this.sinopsis = sinopsis;
        this.criticas = criticas;
        this.duracion = duracion;
        this.trailerUrl = trailerUrl;
        this.puntuacion = puntuacion;
        this.lenguaje = lenguaje;
        this.posterUrl = posterUrl;
        this.backdropUrl = backdropUrl;
        this.precio = precio;
        this.precioRenta = precioRenta;
    }
}
