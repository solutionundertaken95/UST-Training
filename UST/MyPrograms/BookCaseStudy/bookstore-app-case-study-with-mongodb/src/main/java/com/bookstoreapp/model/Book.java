package com.bookstoreapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @JsonProperty("id")
    @Field(name="_id")
    private int id;
    // The title should not be empty and should not exceed 100 characters
    @NotBlank(message = "Title is mandatory")
    @Size(max = 100,message = "Title should not exceed 250 characters")
    @Field(name = "title")
    private String title;

    // The author should not be empty and should not exceed 200 characters
    @NotBlank(message = "Author Field must not be empty")
    @Size(max = 100, message = "Author should not exceed 200 characters")
    @Field(name = "author")
    private String author;

    // The publication year should be a valid year
    @Min(value = 1000)
    @Max(value = 2024)
    @Field(name = "publication_year")
    private int publicationYear;

    // The ISBN should be a valid 10- or 13-digit number.
    @Min(value = 100000000L)
    @Max(value = 9999999999999L)
    @Field(name = "ISBN")
    private long isbn;

    // The price should be a positive decimal value.
    @Positive(message = "Price should be a positive decimal value")
    @Field(name="price")
    private double price;

}
