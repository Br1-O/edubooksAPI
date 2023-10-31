CREATE TABLE plan_types (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) not null,
    price DECIMAL(10, 2) not null,
    duration VARCHAR(20) not null,
    description TEXT
);

CREATE INDEX idx_plan_types_price ON plan_types (price);