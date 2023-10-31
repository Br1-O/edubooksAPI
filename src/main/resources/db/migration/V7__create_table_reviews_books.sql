CREATE TABLE reviews_books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id bigint NOT NULL,
    book_id INT NOT NULL,
    review_text TEXT,
    rating DECIMAL(3, 2),
    review_date DATE,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (book_id) REFERENCES books (id)
);

CREATE INDEX idx_reviews_books_user_id ON reviews_books (user_id);
CREATE INDEX idx_reviews_books_book_id ON reviews_books (book_id);