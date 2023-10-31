CREATE TABLE user_actions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) not null
);

CREATE INDEX idx_user_actions_name ON user_actions (name);