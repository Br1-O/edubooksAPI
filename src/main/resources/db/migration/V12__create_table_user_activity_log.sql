CREATE TABLE user_activity_log (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id bigint NOT NULL,
    action_id INT NOT NULL,
    activity_timestamp DATETIME NOT NULL
);

CREATE INDEX idx_user_activity_log_user_id ON user_activity_log (user_id);