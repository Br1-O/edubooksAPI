CREATE TABLE user_books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id bigint NOT NULL,
    book_id INT NOT NULL,
    is_favorite tinyint default 1,
    fav_date DATE,
    unfav_date DATE,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (book_id) REFERENCES books (id)
);

CREATE INDEX idx_user_books_user_id ON user_books (user_id);
CREATE INDEX idx_user_books_book_id ON user_books (book_id);