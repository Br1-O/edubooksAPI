CREATE TABLE genres (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) not null,
    description TEXT
);

CREATE INDEX idx_genres_name ON genres (name);