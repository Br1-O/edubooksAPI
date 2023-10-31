CREATE TABLE user_book_history (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id bigint NOT NULL,
    book_id INT NOT NULL,
    start_date DATETIME NOT NULL,
    last_page_read INT,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (book_id) REFERENCES books (id)
);

CREATE INDEX idx_user_book_history_user_id ON user_book_history (user_id);