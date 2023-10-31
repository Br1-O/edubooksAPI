CREATE TABLE authors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) not null,
    lastname VARCHAR(100) not null,
    country VARCHAR(100),
    birthday DATE,
    description TEXT
);

CREATE INDEX idx_authors_name ON authors (name);