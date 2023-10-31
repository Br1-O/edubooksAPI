CREATE TABLE bookmarks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id bigint NOT NULL,
    book_id INT NOT NULL,
    page_number INT NOT NULL,
    bookmark_date DATETIME NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (book_id) REFERENCES books (id)
);

CREATE INDEX idx_bookmarks_user_id ON bookmarks (user_id);