package com.br1.edubooks.model.dto.response;

import com.br1.edubooks.model.domain.Book;
import java.util.Date;

public record dtoBook_displayData(
        Long id,
        String title,
        Long authorId,
        Long genreId,
        Date publicationDate,
        String description,
        Boolean isAvailable,
        Date availableSince,
        String filePath
) {
    public dtoBook_displayData(Book book) {
        this(book.getId(), book.getTitle(), book.getAuthorId(), book.getGenreId(), book.getPublicationDate(),
                book.getDescription(), book.getIsAvailable(), book.getAvailableSince(), book.getFilePath());
    }
}
