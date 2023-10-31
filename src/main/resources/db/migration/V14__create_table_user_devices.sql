CREATE TABLE user_devices (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id bigint NOT NULL,
    device_name VARCHAR(255),
    device_ip VARCHAR(255),
    device_type VARCHAR(255),
    last_used DATETIME,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE INDEX idx_user_devices_user_id ON user_devices (user_id);

