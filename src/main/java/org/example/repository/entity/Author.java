package org.example.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "author")
@Data
public class Author {

    @Id
    @GeneratedValue
    private Integer id;
    private String firstname;
    private String lastname;
}
