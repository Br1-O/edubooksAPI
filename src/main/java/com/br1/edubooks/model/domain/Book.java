package com.br1.edubooks.model.domain;

import com.br1.edubooks.model.dto.request.dtoBook_createData;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of= "id")
@Entity(name="Book")
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "author_id")
    private Long authorId;

    @Column(name = "genre_id")
    private Long genreId;

    @Column(name = "publication_date")
    private Date publicationDate;

    private String description;

    @Column(name = "is_available")
    private Boolean isAvailable = true;

    @Column(name = "available_since")
    private Date availableSince;

    @Column(name = "file_path")
    private String filePath;

    public Book(dtoBook_createData dtoBook_createData) {
        this.title = dtoBook_createData.title();
        this.authorId = dtoBook_createData.authorId();
        this.genreId = dtoBook_createData.genreId();
        this.publicationDate = dtoBook_createData.publicationDate();
        this.description = dtoBook_createData.description();
        this.isAvailable = dtoBook_createData.isAvailable();
        this.availableSince = dtoBook_createData.availableSince();
        this.filePath = dtoBook_createData.filePath();
    }
}
