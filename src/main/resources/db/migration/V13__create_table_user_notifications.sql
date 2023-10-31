CREATE TABLE user_notifications (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id bigint NOT NULL,
    message TEXT NOT NULL,
    notification_date DATETIME NOT NULL,
    is_read tinyint DEFAULT 0,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE INDEX idx_user_notifications_user_id ON user_notifications (user_id);