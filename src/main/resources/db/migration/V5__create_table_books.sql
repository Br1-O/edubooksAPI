CREATE TABLE books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author_id INT NOT NULL,
    genre_id INT NOT NULL,
    publication_date DATE,
    description TEXT,
    is_available tinyint default 1,
    available_since DATE,
    file_path VARCHAR(255) UNIQUE NOT NULL,
    FOREIGN KEY (author_id) REFERENCES authors (id),
    FOREIGN KEY (genre_id) REFERENCES genres (id)
);

CREATE INDEX idx_books_title ON books (title);
CREATE INDEX idx_books_author_id ON books (author_id);
CREATE INDEX idx_books_genre_id ON books (genre_id);