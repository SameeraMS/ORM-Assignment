package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class Book {

    @Id
    private String id;
    private String title;
    private int publicationYear;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
