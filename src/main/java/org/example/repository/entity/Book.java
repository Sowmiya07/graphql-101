package org.example.repository.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity(name = "book")
@Data
public class Book {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Integer id;
    private String title;
    private Double price;
    private Integer pages;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_author")
    private Author author;
}
